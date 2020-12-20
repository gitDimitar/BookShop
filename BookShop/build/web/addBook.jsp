<%-- 
    Document   : addBook
    Created on : 12-Dec-2013, 11:40:10
    Author     : D00133809
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<link rel="stylesheet" type="text/css" href="css/project.css"/>
		<link rel="stylesheet" type="text/css" href="css/form_css.css"/>

	</head>

	<body id="top" >
		<div id="bodycont">
			<div id="logo">
			<img src="css/logo2.jpg" width="450" height="100"/>
                       
                        <form id="logreg" action="UserActionServlet" method="post">
                            
                        <h1>Welcome: <%=session.getAttribute("userName")%></h1> 
                         <input type="hidden" name="action" value="Log-out" />
                         <input type="submit" value="Log-out" id="logout_button"/>   
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
                            
                         %>
                         </form>
			</div>
                    <form id="searchForm">
			<div id="searching">
				<label id ="searchLabel">
						Search by
							<select id="searchType" name="Type">
								<option value="Name">Name</option>
								<option value="Author">Author</option>
							</select>
				</label> 
				<input type="text" id="search" name="search" />
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

				<h1> Add Book Form</h1>
				<form id="addBook" action="UserActionServlet" method="post" >
					<fieldset id="details">
                                            <%
                                            if(session.getAttribute("result") != null)
                                            {
                                            %>
                                            <p><%=session.getAttribute("result")%></p>
                                            <%
                                            }
                                            %>
						<label class="reg" id ="name_label ">
							Book Name:
							<input type="text" id="name_txt" name="name_txt" />	
						</label>
						
						<label class="reg" id ="author_label">
							Author:
							<input type="text" id="author_txt" name="author_txt" />	
						</label>
						
						<label class="reg" id ="quantity_label">
							Quantity:
							<input type="text" id="quantity_txt" name="quantity_txt" />	
						</label>
						
						<label class="reg" id ="genre_label">
							Genre:
							<input type="text" id="genre_txt" name="genre_txt" />	
						</label>
						
						<label class="reg" id ="price_label">
							Price:
							<input type="text" id="price_txt" name="price_txt" />	
						</label>
						
						<label class="reg" id ="img_label">
							Img pointer:
							<input type="text" id="img_txt" name="img_txt" />	
						</label>
						
						
                                        <input type="hidden" name="action" value="addBook" />
					<input style="cursor:pointer;" type="submit" value="Add Book" id="add_book" />
				
					</fieldset>
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
