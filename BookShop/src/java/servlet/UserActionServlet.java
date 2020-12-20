/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;
import DTO.Package.*;
import command.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author D00133809
 */
@WebServlet(name = "UserActionServlet", urlPatterns = {"/UserActionServlet"})
public class UserActionServlet extends HttpServlet {

    
    public UserActionServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
         processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    
    protected void displayBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
         String forwardToJsp = "";
            Command command = null;
        if ( request.getParameter("action") != null)
        {

            CommandFactory factory = CommandFactory.getInstance();
            
            
            command = factory.createCommand(request.getParameter("action"));
            

            forwardToJsp = command.execute(request, response);
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardToJsp);
        dispatcher.forward(request, response);
        
    }
    

}
