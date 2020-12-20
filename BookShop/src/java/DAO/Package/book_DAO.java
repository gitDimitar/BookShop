/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Package;

import DTO.Package.book_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author D00133809
 */
public class book_DAO extends Dao {
    
    public ArrayList<book_DTO> displayBooks() 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<book_DTO> books = new ArrayList<book_DTO>();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books";
                    ps = con.prepareStatement(query);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                        int id = rs.getInt("BOOKID");
                       String name = rs.getString("BOOKNAME");
                       String author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       String genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        book_DTO b = new book_DTO(id, name, author, quantity, genre,price,img);
                        books.add(b);
                    }
                    
        }
        
            catch (SQLException e){
                System.out.println("showAllBooks(): " + e.getMessage());
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
                    System.out.println("showAllBooks():" + e.getMessage());
                }
                
                
        }
        return books;
}
    
    public ArrayList<book_DTO> selectBookByName(String name) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<book_DTO> books = new ArrayList<book_DTO>();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books WHERE BOOKNAME LIKE ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, "%" + name + "%");
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                       int id = rs.getInt("BOOKID");
                       String bname = rs.getString("BOOKNAME");
                       String author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       String genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        
                        book_DTO b = new book_DTO(id, bname, author, quantity, genre,price,img);
                        books.add(b);
                    }
        }
        
            catch (SQLException e){
                System.out.println("selectBookByName(): " + e.getMessage());
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
                    System.out.println("selectBookByName():" + e.getMessage());
                }
                return books;
        }
}
    
     public ArrayList<book_DTO> selectBookByGenre(String genre) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<book_DTO> books = new ArrayList<book_DTO>();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books WHERE GENRE LIKE ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, "%" + genre + "%");
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                        int id = rs.getInt("BOOKID");
                       String name = rs.getString("BOOKNAME");
                       String author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        
                        book_DTO b = new book_DTO(id, name, author, quantity, genre,price,img);
                        books.add(b);
                    }
        }
        
            catch (SQLException e){
                System.out.println("selectBookByGenre(): " + e.getMessage());
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
                    System.out.println("selectBookByGenre():" + e.getMessage());
                }
                return books;
        }
}
     
      public ArrayList<book_DTO> selectBookById(int id) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<book_DTO> books = new ArrayList<book_DTO>();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books WHERE BOOKID LIKE ?";
                    ps = con.prepareStatement(query);
                    ps.setInt(1,id);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                       id = rs.getInt("BOOKID");
                       String name = rs.getString("BOOKNAME");
                       String author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       String genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        
                        book_DTO b = new book_DTO(id, name, author, quantity, genre,price,img);
                        books.add(b);
                    }
        }
        
            catch (SQLException e){
                System.out.println("selectBookById(): " + e.getMessage());
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
                    System.out.println("selectBookById():" + e.getMessage());
                }
                return books;
        }
}
      
        public ArrayList<book_DTO> selectBookByAuthor(String author) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<book_DTO> books = new ArrayList<book_DTO>();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books WHERE AUTHOR LIKE ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, "%" + author + "%");
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                        int id = rs.getInt("BOOKID");
                       String name = rs.getString("BOOKNAME");
                       author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       String genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        
                        book_DTO b = new book_DTO(id, name, author, quantity, genre, price,img);
                        books.add(b);
                    }
        }
        
            catch (SQLException e){
                System.out.println("selectBookByAuthor(): " + e.getMessage());
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
                    System.out.println("selectBookByAuthor():" + e.getMessage());
                }
                return books;
        }
}
        
        
        public void removeBook(String bookName) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            con = getConnection();
            
            String query = "select bookID from books where bookName = ?";
            ps = con.prepareStatement(query);
            ps.setString(1,bookName);
            rs = ps.executeQuery();
            if(rs.next())
            {
                query = "delete from orderItems where bookID = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1,rs.getInt("bookID"));
                ps.execute();
                
                query = "DELETE FROM books WHERE bookName = ?";
                ps = con.prepareStatement(query);
                ps.setString(1,bookName);
                ps.execute();

                
            }        
        }
        
            catch (SQLException e){
                System.out.println("removeBook(): " + e.getMessage());
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
                    System.out.println("removeBook():" + e.getMessage());
                }
        }
}      
          public void insertBook(String bookName, String author, double quantity, String genre, double price, String img)
          {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
             try
             {
                con = getConnection();
            
                 String query = "Insert into books (bookName, author, quantity,genre,price,image) values (?,?,?,?,?,?)";
                    ps = con.prepareStatement(query);
                    ps.setString(1, bookName);
                    ps.setString(2, author);
                    ps.setDouble(3, quantity);
                    ps.setString(4,genre );
                    ps.setDouble(5, price);
                    ps.setString(6,img);
                    ps.execute();
                    
             } 
              catch (SQLException e){
                System.out.println("InsertBook(): " + e.getMessage());
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
                    System.out.println("InsertBook():" + e.getMessage());
                    
                }
              }
             
        }
          
        public void editBook(int bookID, String Name, String author, int quantity, String genre, Double price)
         {
             Connection con = null;
             PreparedStatement ps = null;
             ResultSet rs = null;
            
             try
             {
                con = getConnection();
            
                 String query = "update books set bookName = ? , author = ?, quantity = ? , genre = ?, price = ?  where bookID = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1,Name);
                    ps.setString(2,author);
                    ps.setInt(3,quantity);
                    ps.setString(4,genre);
                    ps.setDouble(5,price);
                    ps.setInt(6,bookID);
                    ps.executeUpdate();
                   
                    
                   
             } 
              catch (SQLException e){
                System.out.println("editBook(): " + e.getMessage());
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
                    System.out.println("editBookName():" + e.getMessage());
                }
              }
         }
         
         
         
         public boolean checkBookName(String name)
         {
             Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List <String> books = new ArrayList();
        
        
        try {
            if(name.equals(""))
            {
                return false;
            }
            con = getConnection();
            String query = "Select bookName from books";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                books.add(rs.getString("bookName"));
            }
            
            for(int i = 0; i <books.size(); i++)
            {
                if(books.get(i).equals(name))
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
         
         public book_DTO getBook(String name) 
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        book_DTO b = new book_DTO();
        try
        {
            con = getConnection();
            
            String query = "SELECT * FROM books WHERE BOOKNAME = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1,name);
                    rs = ps.executeQuery();
                    
                    while (rs.next()) 
                    {
                       int id = rs.getInt("BOOKID");
                       String bname = rs.getString("BOOKNAME");
                       String author = rs.getString("AUTHOR");
                       int quantity = rs.getInt("QUANTITY");
                       String genre = rs.getString("GENRE");
                       double price = rs.getDouble("price");
                       String img = rs.getString("image");
                        
                        b = new book_DTO(id, bname, author, quantity, genre,price,img);
                        return b;
                    }
                    
        }
        
            catch (SQLException e){
                System.out.println("selectBookByName(): " + e.getMessage());
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
                    System.out.println("selectBookByName():" + e.getMessage());
                }
                
        }
        return b;
}
    
}
