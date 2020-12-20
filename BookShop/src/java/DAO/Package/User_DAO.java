/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Package;

import DTO.Package.User_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author D00133809
 */
public class User_DAO extends Dao {
    
    public User_DTO log_in(String uname, String pass)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        User_DTO user = new User_DTO();
        
         try {
            con = getConnection();

            String query = "SELECT userID FROM userInfo where userName = ? and userPassword = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,uname);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next())
            {
              int userID = rs.getInt("userID");
              String query2 = "SELECT * FROM userInfo where userID = " + userID;
              ps = con.prepareStatement(query2);
              rs = ps.executeQuery();
              while(rs.next())
              {
                  user = new User_DTO(rs.getInt("userID"),uname, pass , rs.getString("firstName"), rs.getString("lastName") , rs.getString("address1") , rs.getString("address2"), rs.getString("city") , rs.getString("country") , rs.getString("phone") , rs.getString("dob") , rs.getInt("adminb"));
         
                  return user;
              }
            }
            else
            {
             
                return null;
            }
            
        return null;    
            
            
        }
        catch(SQLException e)
        {
        System.out.println(e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return user;
    }
    
     public void updateUser(String pass, String fname, String lname,String address1, String address2, String city, String country, String phone, String dob , int userID)
     {
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = getConnection();
                  
            String query = "Update userInfo set userPassword = ?,firstName = ?, lastName = ?, address1 = ?, address2 = ?, city = ?, country = ?, phone = ?, dob = ? where userID = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, pass);
            ps.setString(2, fname);
            ps.setString(3, lname);
            ps.setString(4, address1);
            ps.setString(5, address2);
            ps.setString(6, city);
            ps.setString(7, country);
            ps.setString(8, phone);
            ps.setString(9, dob);
            ps.setInt(10, userID);
            ps.executeUpdate();
            
            }
        catch(SQLException e)
        {
        System.out.println(e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
         
     }
    
    public void register(String userName, String pass, String fname, String lname,String address1, String address2, String city, String country, String phone, String dob)
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try {
            con = getConnection();
                  
            String query2 = "Insert into userInfo (userName, userPassword,firstName, lastName, address1, address2, city, country, phone, dob) values( ?,?,?,?,?,?,?,?,?,? )";
            ps = con.prepareStatement(query2);
            ps.setString(1, userName);
            ps.setString(2, pass);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.setString(5, address1);
            ps.setString(6, address2);
            ps.setString(7, city);
            ps.setString(8, country);
            ps.setString(9, phone);
            ps.setString(10, dob);
            ps.execute();
            
            System.out.println("User " + userName + " is Registered successully");
            }
        catch(SQLException e)
        {
        System.out.println(e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public boolean checkUserName(String userName)
    {
       Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List <String> users = new ArrayList();
        
        
        try {
            if(userName.equals(""))
            {
                return false;
            }
            con = getConnection();
            String query = "Select userName from userInfo";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                users.add(rs.getString("userName"));
            }
            
            for(int i = 0; i <users.size(); i++)
            {
                if(users.get(i).equals(userName))
                {
                    return false;
                }
                
            }
            
        }
        catch(SQLException e)
        {
        System.out.println(e.getMessage());
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return true;
       
    }
    
    public void deleteMember(int userID)
    {
         
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int adminCheck = -1;
        try
        {
            con = getConnection();
            
            String query = "select adminb from userInfo where userID = ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1,userID);
                    rs = ps.executeQuery();
                    while(rs.next())
                    {
                        adminCheck = rs.getInt("adminb");
                    }
            if(adminCheck == 0)
            {
                query = "delete oi.* , o.* from orders o , orderItems oi where o.orderID = oi.orderID and o.userID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1,userID);
                ps.execute();
      
                query = "delete from userinfo where userID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1,userID);
                ps.execute();
                

            }
            else 
            {
                System.out.println("You cannot delete another admin!");
            }
        }
        
            catch (SQLException e){
                System.out.println("removeUser(): " + e.getMessage());
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
                    System.out.println("removeUser():" + e.getMessage());
                }
        }        
        
        
    }
    
    public ArrayList<User_DTO> getAllUsers()
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User_DTO> users = new ArrayList();
        try
        {
            con = getConnection();
            
            String query = "SELECT * from userInfo";
            
                    ps = con.prepareStatement(query);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {       
                       User_DTO u = new User_DTO(rs.getInt("userID"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("firstName"), rs.getString("lastName") , rs.getString("address1") , rs.getString("address2"), rs.getString("city") , rs.getString("country") , rs.getString("phone") , rs.getString("dob"), rs.getInt("adminb"));
                        users.add(u);
                    }
                    return users;
                    
                    
                         
          }
        
            catch (SQLException e){
                System.out.println("allUsers(): " + e.getMessage());
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
                    System.out.println("allUser():" + e.getMessage());
                }
            }
        return users;
    }
    
    public User_DTO getUser(String userName)
    {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User_DTO u = new User_DTO();
        try
        {
            con = getConnection();
            
            String query = "SELECT * from userInfo where userName = ?";
            
                    ps = con.prepareStatement(query);
                    ps.setString(1, userName);
                    rs = ps.executeQuery();
                    
                   
                     while(rs.next())
                     {
                        u = new User_DTO(rs.getInt("userID"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("firstName"), rs.getString("lastName") , rs.getString("address1") , rs.getString("address2"), rs.getString("city") , rs.getString("country") , rs.getString("phone") , rs.getString("dob"), rs.getInt("adminb"));
                         
                     }
                     return u;
          }
        
            catch (SQLException e){
                System.out.println("allUsers(): " + e.getMessage());
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
                    System.out.println("allUser():" + e.getMessage());
                }
            }
        return u;   
        
    }
    
    public User_DTO getUserByID(int id)
    {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User_DTO u = new User_DTO();
        try
        {
            con = getConnection();
            
            String query = "SELECT * from userInfo where userID = ?";
            
                    ps = con.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    
                   
                     while(rs.next())
                     {
                        u = new User_DTO(rs.getInt("userID"), rs.getString("userName"), rs.getString("userPassword"), rs.getString("firstName"), rs.getString("lastName") , rs.getString("address1") , rs.getString("address2"), rs.getString("city") , rs.getString("country") , rs.getString("phone") , rs.getString("dob"), rs.getInt("adminb"));
                         
                     }
                     return u;
          }
        
            catch (SQLException e){
                System.out.println("allUsers(): " + e.getMessage());
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
                    System.out.println("allUser():" + e.getMessage());
                }
            }
        return u;   
        
    }
    
   
}
