package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import DTO.Package.*;
import DAO.Package.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE HTML SYSTEM>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/project.css\"/>\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body id=\"top\" >\n");
      out.write("\t\t<div id=\"bodycont\">\n");
      out.write("\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t<img src=\"css/logo2.jpg\" width=\"450\" height=\"100\"/>\n");
      out.write("                        ");

                            if(session.getAttribute("uName") == null)
                            {
                            
                        
      out.write("\n");
      out.write("\t\t\t<form id=\"logreg\" action=\"UserActionServlet\" method=\"post\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <label id=\"uname_label\">\n");
      out.write("                                Username:\n");
      out.write("                                <input type=\"text\" id=\"username\" name=\"username\" />\n");
      out.write("                                </label>\n");
      out.write("                                <label id=\"pass_label\">\n");
      out.write("                                Password:\n");
      out.write("                                <input type=\"password\" id=\"pass\" name=\"pass\" />\n");
      out.write("                                </label>\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"Log-in\" />\n");
      out.write("                                <input type=\"submit\" value=\"Log-in\" id=\"login_button\"/>\n");
      out.write("                                <INPUT Type=\"BUTTON\" VALUE=\"Register\" ONCLICK=\"window.location.href='register.jsp'\" id=\"register_button\">  \n");
      out.write("                            </fieldset>\n");
      out.write("\t\t\t</form>\n");
      out.write("                        ");

                            }
                            else
                            {
                                
                        
      out.write("\n");
      out.write("                        <form id=\"logreg\" action=\"UserActionServlet\" method=\"post\">\n");
      out.write("                            \n");
      out.write("                        <h1>Welcome: ");
      out.print(session.getAttribute("userName"));
      out.write("</h1> \n");
      out.write("                         <input type=\"hidden\" name=\"action\" value=\"Log-out\" >\n");
      out.write("                         <input type=\"submit\" value=\"Log-out\" id=\"logout_button\">   \n");
      out.write("                         <INPUT Type=\"BUTTON\" VALUE=\"User Details\" ONCLICK=\"window.location.href='userDetails.jsp'\" id=\"user_details\">\n");
      out.write("                                \n");
      out.write("                         ");

                                Integer admin = (Integer)session.getAttribute("admin");
                                if(admin != null)
                                {
                                    if(  admin == 1)
                                    {
                         
      out.write("           \n");
      out.write("                          <INPUT Type=\"BUTTON\" VALUE=\"Admin Panel\" ONCLICK=\"window.location.href='adminPanel.jsp'\" id=\"admin_panel\">\n");
      out.write("                          ");
           
                                    } 
                                }
                            }
                         
      out.write("\n");
      out.write("                         </form>\n");
      out.write("\t\t\t</div>\n");
      out.write("                    <form id=\"searchForm\" action=\"UserActionServlet\" method=\"post\" >\n");
      out.write("\t\t\t<div id=\"searching\">\n");
      out.write("\t\t\t\t<label id =\"searchLabel\">\n");
      out.write("\t\t\t\t\t\tSearch by\n");
      out.write("\t\t\t\t\t\t\t<select id=\"searchType\" name=\"Type\">\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Name\">Name</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"Author\">Author</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</label> \n");
      out.write("\t\t\t\t<input type=\"text\" id=\"search\" name=\"search\" />\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"search\" >\n");
      out.write("\t\t\t\t<input style=\"cursor:pointer;\" type=\"submit\" value=\"search\" id=\"search_button\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("                    </form>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t<nav id=\"navigation_bar_left\">\n");
      out.write("\t\t\t\t<ul class=\"lhs\">\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"index.jsp\"> Home </a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Adventure\"> Adventure </a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Autobiography\">Autobiography</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Crime\">Crime </a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Fantasy\">Fantasy </a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Fiction\">Fiction </a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=FoodandDrink\">Food and Drink</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=History\">History</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Horror\">Horror</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Philosophy\">Philosophy</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Romance\">Romance</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Scifi\">Sci-fi</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"lhs\"href=\"UserActionServlet?action=showBooks&genre=Thrillers\">Thrillers</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    \n");
      out.write("\t\t\t<div id=\"content\">\n");
      out.write("                            \n");
      out.write("                            <h1> Top 10 Books</h1>\n");
      out.write("                            ");
 
                                book_DAO bdao = new book_DAO();
                                ArrayList<book_DTO> books = new ArrayList<book_DTO>();
                                books = bdao.displayBooks();
                                if(books != null)
                                {
                                
                                    for(book_DTO b: books )
                                    {
                                       
                                       
                             
      out.write("\n");
      out.write("                             <form action=\"UserActionServlet\" method=\"post\">\n");
      out.write("\t\t\t\t<div style=\"clear:left;\">\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<p style=\"float:left;\"><a href=\"\"><img src=\"");
      out.print(b.getImg());
      out.write("\" width=\"100\" height=\"150\" /></a></p>\n");
      out.write("\t\t\t\t\t<p style=\"padding-top:0.001em;\">\n");
      out.write("                                        <h3><a href=\"\">");
      out.print(b.getName());
      out.write("</a></h3>\n");
      out.write("                                            <h4>");
      out.print(b.getAuthor());
      out.write("</h4>\n");
      out.write("                                            <p style =\" float:right;\">Price: € ");
      out.print(b.getPrice() );
      out.write(" \n");
      out.write("                                            <input type=\"hidden\" name=\"action\" value=\"addToCart\" />\n");
      out.write("                                            <input type=\"hidden\" name=\"bID\" value=\"");
      out.print(b.getId());
      out.write("\" />\n");
      out.write("                                            \n");
      out.write("                                            <input style=\"cursor:pointer;\" type=\"submit\" value=\"Add to cart\" id=\"add_button\" />\n");
      out.write("                                            </p>\n");
      out.write("                                        </p>\n");
      out.write("                                               \n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("                             </form>\n");
      out.write("                            ");

                                    }
                                }

                            
      out.write("\n");
      out.write("                            \n");
      out.write("\t\t\t\t<footer>\n");
      out.write("\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t</footer>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
