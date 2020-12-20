/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import DTO.Package.User_DTO;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author D00133809
 */
public class LoginCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;;
        UserService userService = new UserService();

            
           
            String username = request.getParameter("username");
            String password = request.getParameter("pass");

            if (username != null && password != null)
            {
               
                User_DTO userLoggingIn = userService.login(username, password);

                if (userLoggingIn != null)
                {
                   
                    HttpSession session = request.getSession();
                    String clientSessionId = session.getId();
                    session.setAttribute("loggedSessionId", clientSessionId);
                    session.setAttribute("userDTO", userLoggingIn);
                    session.setAttribute("uName", userLoggingIn.getUserName());
                    session.setAttribute("userName", userLoggingIn.getFirstName());
                    session.setAttribute("admin", userLoggingIn.getAdmin());

                    forwardToJsp = "/logInSuccess.jsp";				
                }
                else
                {
                    forwardToJsp = "/logInFailure.jsp";	
                }
            }
            else 
            {
                forwardToJsp = "/logInFailure.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
}
