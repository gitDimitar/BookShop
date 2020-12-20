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
 * @author D00133809
 */
public class LogoutCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;;

        
            HttpSession session = request.getSession(false);
         
            if(session != null)
            {
                session.removeAttribute("uName");
                forwardToJsp = "/index.jsp";
            }
                	
            
            return forwardToJsp;
        }
    
        
    }
    
