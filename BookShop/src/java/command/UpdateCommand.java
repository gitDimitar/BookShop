/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import DTO.Package.User_DTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author Miteto
 */
public class UpdateCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        User_DTO d = (User_DTO)session.getAttribute("userDTO");
     
        
            String pass = request.getParameter("pass_txt");
            String fname = request.getParameter("fname_txt");
            String lname = request.getParameter("lname_txt");
            String add1 = request.getParameter("addr1_txt");
            String add2 = request.getParameter("addr2_txt");
            String city = request.getParameter("city_txt");
            String country = request.getParameter("country_txt");
            String phone = request.getParameter("phone_txt");
            String dob = request.getParameter("dob_txt");
            int userID = d.getUserID();
            

            if ( pass != null && fname != null && lname != null && add1 != null && add2 != null && city != null && country != null && phone != null && dob != null )
            {

                 userService.updateUser(pass, fname, lname, add1, add2, city, country, phone, dob, userID);
            }
            else 
            {
                forwardToJsp = "/userDetails.jsp";	
            }
            forwardToJsp = "/userDetails.jsp";
            
        
    
        return forwardToJsp;
    }
    
}
