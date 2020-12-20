/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author D00133809
 */
public interface Command 
{
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
