/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import DTO.Package.book_DTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BookService;

/**
 *
 * @author D00133809
 */
public class GenreSearchCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        HttpSession session = request.getSession();
        String forwardToJsp;
        List<book_DTO> bookList = null;
        	
            BookService bookService = new BookService();
           
            bookList = bookService.searchBookByGenre(request.getParameter("genre"));
           
                  
            session.setAttribute("bookList", bookList);

            forwardToJsp = "/searchLinkResults.jsp";
        
        return forwardToJsp;
    }
    
}
