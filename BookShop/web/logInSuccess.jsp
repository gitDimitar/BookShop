<%-- 
    Document   : index
    Created on : 12-Nov-2013, 10:40:53
    Author     : D00133809
--%>

<%@page import="DTO.Package.book_DTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Package.book_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML SYSTEM>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/project.css"/>

	</head>

	<body id="top">
		<div id="bodycont">
			<div id="logo">
			<img src="css/logo2.jpg" width="450" height="100"/>
			<form id="logreg" action="UserActionServlet" method="post">
                            <h1>Welcome:<%= request.getSession().getAttribute("userName")%></h1>
                            <input type="hidden" name="action" value="Log-out" />
                            <input type="submit" value="Log-out" id="logout_button"/>
                            <INPUT Type="BUTTON" VALUE="User Details" ONCLICK="window.location.href='userDetails.jsp'" id="user_details">
                            <% 
                                int admin = (Integer)session.getAttribute("admin");
                                
                                if(  admin == 1)
                                {
                                
                            %>
                            <INPUT Type="BUTTON" VALUE="Admin Panel" ONCLICK="window.location.href='adminPanel.jsp'" id="admin_panel">
                            <%
                                }      
                            %>        
			</form>
			</div>
			<div id="searching">
				<label id ="searchLabel">
						Search by
							<select id="searchType" name="Type">
								<option value="Name">Name</option>
								<option value="Author">Author</option>
							</select>
				</label> 
				<input type="text" id="search" name="search" />
				<input type="submit" value="Search" id="search_button" />
			</div>
				
			<nav id="navigation_bar_left">
				<ul class="lhs">
					<li><a class="lhs"href="index.jsp"> Home </a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Adventure"> Adventure </a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Autobiography">Autobiography</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Crime">Crime </a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Fantasy">Fantasy </a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Fiction">Fiction </a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=FoodandDrink">Food and Drink</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=History">History</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Horror">Horror</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Philosophy">Philosophy</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Romance">Romance</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Scifi">Sci-fi</a></li>
					<li><a class="lhs"href="UserActionServlet?action=showBooks&genre=Thrillers">Thrillers</a></li>
				</ul>
			</nav>



			<div id="content">

				 <h1> Top 10 Books</h1>
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
                                        <h3><a href=""><%=b.getName()%></a></h3>
                                            <h4><%=b.getAuthor()%></h4>
                                            <p style =" float:right;">Price: € <%=b.getPrice() %> 
                                            <input type="hidden" name="action" value="addToCart" />
                                            <input style="cursor:pointer;" type="submit" value="Add to cart" id="add_button" />
                                            </p>
                                        </p>
                                               
					
				</div>
                             </form>
                            <%
                                    }
                                }

                            %>	
				
				</div>
				<footer>
					<p>
					<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie
					</p>
				</footer>

			</div>
		</div>
		
	</body>
</html>



