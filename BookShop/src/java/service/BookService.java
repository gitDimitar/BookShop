/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.*;
import DTO.Package.*;
import DAO.Package.*;

/**
 *
 * @author D00133809
 */
public class BookService {
    
    public ArrayList<book_DTO> searchBookByName(String name)
    {
        ArrayList<book_DTO> books = null;
        book_DAO b = new book_DAO();
        
        try
        {
            books = new ArrayList(b.selectBookByName(name));
            
            
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public ArrayList<book_DTO> searchBookByAuthor(String author)
    {
        ArrayList<book_DTO> books = null;
        book_DAO b = new book_DAO();
        
        try
        {
            books = new ArrayList(b.selectBookByAuthor(author));
            
            
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public ArrayList<book_DTO> searchBookByGenre(String genre)
    {
        ArrayList<book_DTO> books = null;
        book_DAO b = new book_DAO();
        
        try
        {
            books = new ArrayList(b.selectBookByGenre(genre));
            
            
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        
        return books;
    }
    
    public boolean checkBookName(String name)
    {
        book_DAO dao = new book_DAO();
         boolean check = true;
        try
        {
          check = dao.checkBookName(name);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        return check;
    }
    
    public void addBook(String bookName, String author, double quantity, String genre, double price, String img)
    {
        book_DAO dao = new book_DAO();
        
        try
        {
           dao.insertBook(bookName, author, quantity, genre, price, img);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        
        
    }
    
    public void removeBook(String bookName)
    {
        book_DAO dao = new book_DAO();
        
        try
        {
           dao.removeBook(bookName);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        
    }
    
    public void editBook(String bookName, String author, int quantity, String genre, double price,int bookID)
    {
        book_DAO dao = new book_DAO();
        
        try
        {
           dao.editBook(bookID, bookName,author,quantity, genre, price);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
    }
    
    
}
