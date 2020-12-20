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
public class EditBookCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        String forwardToJsp = null;
        BookService bookService = new BookService();
        HttpSession session = request.getSession();
        String result;

       
            String name = request.getParameter("bname_txt");
            String author = request.getParameter("author_txt");
            Integer quantity = Integer.parseInt(request.getParameter("quantity_txt"));
            String genre = request.getParameter("genre_txt");
            Double price = Double.parseDouble(request.getParameter("price_txt"));
            Integer bookID = Integer.parseInt(request.getParameter("bookID_txt"));
            

            if (name != null && author != null && quantity != null && genre != null && price != null )
            {
              
                
                    bookService.editBook(name, author, quantity, genre, price,bookID);
                    result = "The Book has been edited Successfully";
                    session.setAttribute("result",result);
                    forwardToJsp = "/manageBooks.jsp";				    
            }
            else 
            {
                    result = "The book has not been eddited!";
                    session.setAttribute("result", result);
                    forwardToJsp = "/manageBooks.jsp";	
            }
            
        
    
        return forwardToJsp;
    }
    
}
