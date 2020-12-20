/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BookService;

/**
 *
 * @author D00133809
 */
public class DeleteBookCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        BookService bookService = new BookService();
        HttpSession session = request.getSession();
        String result;

        //Check the 'action' parameter to see what the user wants...
        
            
            //The user wants to log in...
            String name = request.getParameter("bookName");
            
            

            if (name != null)
            {
              
                
                 bookService.removeBook(name);
                    result = "The Book has been removed Successfully";
                    session.setAttribute("result",result);
                    forwardToJsp = "/manageBooks.jsp";				
            }
            else 
            {
                    result = "The book has not been removed!";
                    session.setAttribute("result", result);
                    forwardToJsp = "/manageBooks.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
    
}
