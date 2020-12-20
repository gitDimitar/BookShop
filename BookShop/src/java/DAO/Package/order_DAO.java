/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Package;
import DTO.Package.book_DTO;
import DTO.Package.User_DTO;
import DTO.Package.order_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author D00133809
 */
public class order_DAO extends Dao {
    
    public void placeOrder(int userID)
    {
        Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             try
             {
                con = getConnection();
                
                String query = "insert into orders(userID) values(?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, userID);
                ps.execute();
             }
              catch (SQLException e){
                System.out.println("placeOrder(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("placeOrder():" + e.getMessage());
                }
              }   
        
    }
    
    public void addItems(int bookID, int orderID, int quantity)
    {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             try
             {
                con = getConnection();
                
                String query = "update books set quantity = quantity - ? where bookID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, quantity);
                ps.setInt(2, bookID);
                ps.executeUpdate();
                
                query = "insert into orderItems(orderID,bookID,quantity) values(?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, orderID);
                ps.setInt(2, bookID);
                ps.setInt(3, quantity);
                ps.execute();
                
                
             }
              catch (SQLException e){
                System.out.println("addItem(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("addItem():" + e.getMessage());
                }
              }
    }
    
    public void removeOrder(int orderID)
    {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             //ArrayList<book_DTO> list1 = new ArrayList<book_DTO>();
             order_DTO item = new order_DTO();
             try
             {
                con = getConnection();
                
                String query ="select * FROM orderItems where orderID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, orderID);
                rs = ps.executeQuery();
                
                while(rs.next())
                {
                    item = new order_DTO(rs.getInt("lineID"), rs.getInt("orderID"), rs.getInt("bookID"), rs.getInt("quantity"));
                    
                    query = "update books set quantity = quantity + ? where bookID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, item.getQuantity());
                    ps.setInt(2, item.getBookID());
                    ps.executeUpdate();
                }
                                              
                
                query = "delete from orderItems where orderID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, orderID);
                ps.execute();
                System.out.println("orderItem deleted!");
                query = "delete from orders where orderID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, orderID);
                ps.execute();
                
             }
              catch (SQLException e){
                System.out.println("removeOrder(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("removeOrder():" + e.getMessage());
                }
              }
        
    }
    
    public void editOrderItem(int bookID, int quantity, int orderID)
    {
            Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             int quan;
             try
             {
                con = getConnection();
                String query = "select quantity from orderItems where bookID = ? and orderID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, bookID);
                ps.setInt(2, orderID);
                rs = ps.executeQuery();
                if(rs.next())
                {
                    quan = rs.getInt("quantity");
                    
                    query = "update orderItems set quantity = ? where bookID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, quantity);
                    ps.setInt(2, bookID);
                    ps.executeUpdate();
                    
                    int excess = quan - quantity;
                    
                        query = "update books set quantity = quantity + ? where bookID = ?";
                        ps = con.prepareStatement(query);
                        ps.setInt(1, excess);
                        ps.setInt(2, bookID);
                        ps.executeUpdate();   
                }
             
             }
              catch (SQLException e){
                System.out.println("editItem(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("editItem():" + e.getMessage());
                }
              }
    }
    
    public void removeItem(int orderID, int bookID)
    {
            Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             int quan;
             try
             {
                con = getConnection();
                
                String query = "select quantity from orderItems  where bookID = ? and orderID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, bookID);
                ps.setInt(2, orderID);
                rs = ps.executeQuery();
                
                if(rs.next())
                {
                   quan = rs.getInt("quantity");
                   query = "update books set quantity = quantity + ? where bookID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, quan);
                    ps.setInt(2, bookID);
                    ps.executeUpdate();
                    
                    query = "delete from orderItems where orderID = ? and bookID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1, orderID);
                    ps.setInt(2, bookID);
                    ps.execute();
                }
                
                
                
                
                
             }
              catch (SQLException e){
                System.out.println("removeItem(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("removeItem():" + e.getMessage());
                }
              }
    }
    
    public void displayUserOrders(int userID)
    {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             ArrayList <order_DTO> list1 = new ArrayList<order_DTO>();
             order_DTO order = new order_DTO();
             try
             {
                con = getConnection();
                
                String query = "select * from orders o , orderItems oi where o.orderID = oi.orderID and o.userID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, userID);
                rs = ps.executeQuery();
                
                while(rs.next())
                {
                    order = new order_DTO(rs.getInt("orderID"),rs.getInt("userID"), rs.getInt("lineID"), rs.getInt("bookID"), rs.getInt("quantity"));
                    list1.add(order);
                }
                for(int i = 0; i<list1.size();i++)
                {
                    System.out.println("Order for user:" + userID +  list1.get(i).toString());
                }
                
             }
              catch (SQLException e){
                System.out.println("displayUserOrders(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("displayUserOrders():" + e.getMessage());
                }
              }
    }
    
    public ArrayList<order_DTO> displayAllOrders()
    {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             ArrayList <order_DTO> list1 = new ArrayList<order_DTO>();
             order_DTO order = new order_DTO();
             try
             {
                con = getConnection();
                
                String query = "select * from orders o , orderItems oi where o.orderID = oi.orderID order by userID";
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next())
                {
                    order = new order_DTO(rs.getInt("orderID"),rs.getInt("userID"), rs.getInt("lineID"), rs.getInt("bookID"), rs.getInt("quantity"));
                    list1.add(order);
                }
                return list1;
                
             }
              catch (SQLException e){
                System.out.println("displayUserOrders(): " + e.getMessage());
            } finally{
                try {
                    if(rs != null){
                        rs.close();
                    }
                    if (ps != null){
                        ps.close();
                    }
                    if (con != null){
                        freeConnection(con);
                    }
                    
                } catch (SQLException e) {
                    System.out.println("displayUserOrders():" + e.getMessage());
                }
              }
             return list1;
    }
}
