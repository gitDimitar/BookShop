<%-- 
    Document   : manageBooks
    Created on : 12-Dec-2013, 13:51:28
    Author     : D00133809
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML SYSTEM>
<%@ page import="java.util.*" %>
<%@ page import="DTO.Package.*"%>
<%@ page import="DAO.Package.*"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/project.css"/>

	</head>

	<body id="top" >
            <script type="text/javascript">
                function selectedItemName() {
                  document.myForm.selectedItemId.value ;
                  alert(document.myForm.selectedItemId.value);

                 // For you this would place the selected item id in the hidden
                 // field in stead of 2, and submit the form in stead of alert
                }
             </script>
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
                            
                            <h1> Top 10 Books</h1>
                            <% if(session.getAttribute("result") != null)
                                {
                            %>            
                            <h2><%=session.getAttribute("result")%></h2>
                            <%
                                }
                            %>
                            <% 
                                book_DAO bdao = new book_DAO();
                                ArrayList<book_DTO> books = new ArrayList<book_DTO>();
                                books = bdao.displayBooks();
                                if(books != null)
                                {
                                
                                    for(book_DTO b: books )
                                    {
                                       
                                       
                             %>
				<form action="UserActionServlet" method="post">
				<div style="clear:left;">
					
					<p style="float:left;"><a href=""><img src="<%=b.getImg()%>" width="100" height="150" /></a></p>
					<p style="padding-top:0.001em;">
                                            
                                        <h3><a href=""><label id="bookName" name="bookName"><%=b.getName()%></label></a></h3>
                                        <p style =" float:right;">Price: € <%=b.getPrice() %> 
                                            <input type="hidden" name="action" value="delete" />
                                            <input type="hidden" name="bookName" value="<%=b.getName()%>" />
                                            <input style="cursor:pointer;" type="submit" name="type" value="Delete" id="delete_book" />
                                            <INPUT Type="BUTTON" VALUE="Edit" ONCLICK="window.location.href='editBook.jsp?value=<%=b.getName()%>'  " id="editBook">
                                            </p>
                                            <h4><%=b.getAuthor()%></h4>
                                            <h4><%=b.getGenre()%></h4>
                                            <h5>Quantity: <%=b.getQuantity()%></h5>
                                            
                                            
                                        </p>
                                               
					
				</div>
                             </form>
                            <%
                                    }
                                }

                            %>
                           
				<footer>
					<p>
					<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie
					</p>
				</footer>

			</div>
		</div>
		
	</body>
</html>
