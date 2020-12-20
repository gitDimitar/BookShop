/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import DTO.Package.*;
import DAO.Package.*;
import java.util.*;

/**
 *
 * @author D00133809
 */
public class UserService {
    
    public User_DTO login(String username, String password)
    {
        User_DTO u = null;
        try 
        {
            User_DAO dao = new User_DAO();
            u = dao.log_in(username, password);
        } 
        catch (NullPointerException e) 
        {
            e.printStackTrace();
        }
        return u;
    }
    
    public void updateUser(String pass, String fname, String lname,String address1, String address2, String city, String country, String phone, String dob, int userID)
    {
        User_DAO dao = new User_DAO();
        try
        {
            dao.updateUser(pass, fname, lname, address1, address2, city, country, phone, dob, userID);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
    }
    
    public void register(String userName, String pass, String fname, String lname,String address1, String address2, String city, String country, String phone, String dob)
    {
        User_DAO dao = new User_DAO();
        try
        {
            dao.register(userName, pass, fname, lname, address1, address2, city, country, phone, dob);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
    }
    
    public boolean checkUsername(String uName)
    {
         User_DAO dao = new User_DAO();
         boolean check = true;
        try
        {
          check = dao.checkUserName(uName);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        return check;
        
    }
    
    public User_DTO getUser(String uName)
    {
        User_DAO dao = new User_DAO();
        User_DTO dto = new User_DTO();
        
        try
        {
            dto = dao.getUser(uName);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        return dto;
    }
    
    public void deleteUser(int id)
    {
        User_DAO dao = new User_DAO();
        try
        {
             dao.deleteMember(id);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();  
        }
        
    }
}
