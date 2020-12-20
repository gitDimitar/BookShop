/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author D00133809
 */
public class CommandFactory {
    
    private static CommandFactory factory = null;
    
    private CommandFactory() {
    }
	
    public static synchronized CommandFactory getInstance()
    {
        if(factory == null)
        {
            factory = new CommandFactory();
        }
        return factory;
    }
    
    public synchronized Command createCommand(String com) 
    {
    	Command command = null;
    	SearchCommand s = new SearchCommand();
	
    	if (com.equals("Log-in")) 
        {
            command = new LoginCommand();
    	}
    	if (com.equals("Log-out")) 
        {
            command = new LogoutCommand();
    	}
        if (com.equals("Register"))
        {
            command = new RegisterCommand();
        }
        if (com.equals("search"))
        {
            command = new SearchCommand();
        }
        if (com.equals("showBooks"))
        {
            command = new GenreSearchCommand();
        }
        if (com.equals("update"))
        {
            command = new UpdateCommand();
        }
        if (com.equals("addBook"))
        {
            command = new AddBookCommand();
        }
        if (com.equals("delete"))
        {
            command = new DeleteBookCommand();
        }
        if(com.equals("editBook"))
        {
            command = new EditBookCommand();
        }
        if(com.equals("deleteUser"))
        {
            command = new DeleteUserCommand();
        }
        return command;
    }
    
}
