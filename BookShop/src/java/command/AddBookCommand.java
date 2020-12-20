/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;

/**
 *
 * @author D00133809
 */
public class AddBookCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        BookService bookService = new BookService();
        HttpSession session = request.getSession();
        String result;

        //Check the 'action' parameter to see what the user wants...
        
            
            //The user wants to log in...
            String name = request.getParameter("name_txt");
            String author = request.getParameter("author_txt");
            Integer quantity = Integer.parseInt(request.getParameter("quantity_txt"));
            String genre = request.getParameter("genre_txt");
            Double price = Double.parseDouble(request.getParameter("price_txt"));
            String img = request.getParameter("img_txt");
            

            if (name != null && author != null && quantity != null && genre != null && price != null && img != null )
            {
              
                if (bookService.checkBookName(name) == true)
                {
                 bookService.addBook(name, author, quantity, genre, price, img);
                    result = "The Book has been added Successfully";
                    session.setAttribute("result",result);
                    forwardToJsp = "/addBook.jsp";				
                }
                else
                {
                    result = "The book has not been added!(Book name already exists)";
                    session.setAttribute("result", result);
                    forwardToJsp = "/addBook.jsp";	
                }
            }
            else 
            {
                    result = "The book has not been added!(No empty fields allowed)";
                    session.setAttribute("result", result);
                    forwardToJsp = "/addBook.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
    
}
