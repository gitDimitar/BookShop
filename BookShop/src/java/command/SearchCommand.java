/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import DTO.Package.book_DTO;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BookService;

/**
 *
 * @author D00133809
 */
public class SearchCommand implements Command {
    
    public String execute(HttpServletRequest request, HttpServletResponse response) 
    {
        HttpSession session = request.getSession();
        String forwardToJsp;
        List<book_DTO> bookList = null;
        	
            BookService bookService = new BookService();
           if( request.getParameter("Type").equals("Name"))
           {
                bookList = bookService.searchBookByName(request.getParameter("search"));
           }
           else if(request.getParameter("Type").equals("Author"))
           {
                bookList = bookService.searchBookByAuthor(request.getParameter("search"));
           }
                  
            session.setAttribute("bookList", bookList);
            session.setAttribute("searchValue", request.getParameter("search"));
            session.setAttribute("searchValue2", request.getParameter("Type"));
            forwardToJsp = "/searchResults.jsp";
        
        return forwardToJsp;
    }
    
}
