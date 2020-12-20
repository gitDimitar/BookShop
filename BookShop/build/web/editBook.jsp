<%-- 
    Document   : editBook
    Created on : 16-Dec-2013, 13:14:32
    Author     : D00133809
--%>

<%@page import="DAO.Package.book_DAO"%>
<%@page import="DTO.Package.book_DTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML SYSTEM>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/project.css"/>
		<link rel="stylesheet" type="text/css" href="css/form_css.css"/> 
	</head>

	<body id="top">
		<div id="bodycont">
                    <div id="logo">
			<img src="css/logo2.jpg" width="450" height="100"/>
                        <%
                            if(session.getAttribute("userName") == null)
                            {
                            
                        %>
			<form id="logreg" action="UserActionServlet" method="post">
                            <fieldset>
                                <label id="uname_label">
                                Username:
                                <input type="text" id="username" name="username" />
                                </label>
                                <label id="pass_label">
                                Password:
                                <input type="password" id="pass" name="pass" />
                                </label>
                                <input type="hidden" name="action" value="Log-in" />
                                <input type="submit" value="Log-in" id="login_button"/>
                                <INPUT Type="BUTTON" VALUE="Register" ONCLICK="window.location.href='register.jsp'" id="register_button">  
                            </fieldset>
			</form>
                        <%
                            }
                            else
                            {
                                
                        %>
                        <form id="logreg" action="UserActionServlet" method="post">
                            
                        <h1>Welcome: <%=session.getAttribute("userName")%></h1> 
                         <input type="hidden" name="action" value="Log-out" >
                         <input type="submit" value="Log-out" id="logout_button">   
                         <INPUT Type="BUTTON" VALUE="User Details" ONCLICK="window.location.href='userDetails.jsp'" id="user_details">
                                
                         <%
                                Integer admin = (Integer)session.getAttribute("admin");
                                if(admin != null)
                                {
                                    if(  admin == 1)
                                    {
                         %>           
                          <INPUT Type="BUTTON" VALUE="Admin Panel" ONCLICK="window.location.href='adminPanel.jsp'" id="admin_panel">
                          <%           
                                    } 
                                }
                            }
                         %>
                         </form>
			</div>
                    <form id="searchForm" action="UserActionServlet" method="post" >
			<div id="searching">
				<label id ="searchLabel">
						Search by
							<select id="searchType" name="Type">
								<option value="Name">Name</option>
								<option value="Author">Author</option>
							</select>
				</label> 
				<input type="text" id="search" name="search" />
                                <input type="hidden" name="action" value="search" >
				<input style="cursor:pointer;" type="submit" value="Search" id="search_button" />
			</div>
                    </form>
				
			<nav id="navigation_bar_left">
				<ul class="lhs">
					<li><a class="lhs"href="index.jsp"> Home </a></li>
					<li><a class="lhs"href="addBook.jsp"> Add Book </a></li>
                                        <li><a class="lhs"href="manageBooks.jsp"> Manage Books </a></li>
					<li><a class="lhs"href="manageUsers.jsp">Manage Users</a></li>
					<li><a class="lhs"href="listOrders.jsp"> List Orders </a></li>
				</ul>
			</nav>



			<div id="content">
                            
				<h1> Books Details Form</h1>
                                <% 
                                    book_DAO dao = new book_DAO();
                                    if(request.getParameter("value") != null)
                                    {
                                        String name = (String)request.getParameter("value");
                                        book_DTO b = new book_DTO();
                                        b = dao.getBook(name);   
                                    %>
				<form id="userDetails" action="UserActionServlet" method="post" >
                                    
					<fieldset id="details">
                                                
                                                <label class="reg" id ="bID_label ">
							Book ID
							<input type="text" id="bookID_txt" name="bookID_txt" value="<%=b.getId()%>" readonly/>	
						</label>
                                            
						<label class="reg" id ="bname_label ">
							Book Name
							<input type="text" id="bname_txt" name="bname_txt" value="<%=b.getName()%>" />	
						</label>
						
						<label class="reg" id ="author_label">
							Author
							<input type="text" id="author_txt" name="author_txt" value="<%=b.getAuthor()%>" />	
						</label>
						
						<label class="reg" id ="genre_label">
							Genre
							<input type="text" id="genre_txt" name="genre_txt" value="<%=b.getGenre()%>" />	
						</label>
						
						<label class="reg" id ="quantity_label">
							Quantity
							<input type="text" id="quantity_txt" name="quantity_txt" value="<%=b.getQuantity()%>" />	
						</label>
						
						<label class="reg" id ="price_label">
							Price
							<input type="text" id="price_txt" name="price_txt" value="<%=b.getPrice()%>" />	
						</label>
	
					<input type="hidden" name="action" value="editBook" />
					<input style="cursor:pointer;" type="submit" value="Update Details" id="updateBook" />
				
					</fieldset>
                                       <%
                                        }
                            else
                            {
                                    
                            }
                                       %>                                                                                               
				</form>
				<footer>
					<p>
					<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie
					</p>
				</footer>

			</div>
		</div>
		
	</body>
</html>
