/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import DAO.Package.User_DAO;
import DTO.Package.User_DTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author D00133809
 */
public class RegisterCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        UserService userService = new UserService();
        

        //Check the 'action' parameter to see what the user wants...
        
            
            //The user wants to log in...
            String uname = request.getParameter("uname_txt");
            String pass = request.getParameter("pass_txt");
            String fname = request.getParameter("fname_txt");
            String lname = request.getParameter("lname_txt");
            String add1 = request.getParameter("addr1_txt");
            String add2 = request.getParameter("addr2_txt");
            String city = request.getParameter("city_txt");
            String country = request.getParameter("country_txt");
            String phone = request.getParameter("phone_txt");
            String dob = request.getParameter("day") + "/" + request.getParameter("month") + "/" + request.getParameter("year");
            

            if (uname != null && pass != null && fname != null && lname != null && add1 != null && add2 != null && city != null && country != null && phone != null && dob != null )
            {
                //Use the UserServive class to login...
                
                

                if (userService.checkUsername(uname) == true)
                {
                 userService.register(uname, pass, fname, lname, add1, add2, city, country, phone, dob);
                  

                    forwardToJsp = "/registerSuccess.jsp";				
                }
                else
                {
                    forwardToJsp = "/registerAgain.jsp";	
                }
            }
            else 
            {
                forwardToJsp = "/register.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
    
}
