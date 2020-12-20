<%-- 
    Document   : registerSuccess
    Created on : 21-Nov-2013, 13:15:03
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
		<div id="bodycont">
			<div id="logo">
			<img src="css/logo2.jpg" width="450" height="100"/>
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
                            <form id="displayForm" >
                                <h2>Thank you for registering! You can now log in</h2>
                            </form>
				<footer>
					<p>
					<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie
					</p>
				</footer>

			</div>
		</div>
		
	</body>
</html>>
