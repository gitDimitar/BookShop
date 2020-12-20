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
public class DeleteUserCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        String result;

        //Check the 'action' parameter to see what the user wants...
        
            
            //The user wants to log in...
            int id = Integer.parseInt(request.getParameter("value"));
            User_DAO udao = new User_DAO();
            User_DTO u = new User_DTO();
            u = udao.getUserByID(id);

            if (u.getAdmin() == 0)
            {
              
                
                userService.deleteUser(id);
                    result = "The User has been removed Successfully";
                    session.setAttribute("resultUser",result);
                    forwardToJsp = "/manageUsers.jsp";				
            }
            else 
            {
                    result = "This user is an admin! You cannot delete another admin";
                    session.setAttribute("resultUser", result);
                    forwardToJsp = "/manageUsers.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
    
}
