<%-- 
    Document   : userDetails
    Created on : 10-Dec-2013, 11:43:18
    Author     : D00133809
--%>

<%@page import="DAO.Package.User_DAO"%>
<%@page import="DTO.Package.User_DTO"%>
<%@page import="service.UserService"%>
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
                            
				<h1> User Details Form</h1>
                                
				<form id="userDetails" action="UserActionServlet" method="post" >
                                    <% 
                                    User_DAO dao = new User_DAO();
                                    if(session.getAttribute("uName") != null)
                                    {
                                        String name = (String)session.getAttribute("uName");
                                        User_DTO u = new User_DTO();
                                        u = dao.getUser(name);
                                
                                    %>
					<fieldset id="details">
						<label class="reg" id ="unamereg_label ">
                                                    <u>Username :</u> <%=u.getUserName()%>
								
						</label>
						
						<label class="reg" id ="passreg_label">
							<u>Password :</u> <%=u.getPassword()%>
								
						</label>
						
						<label class="reg" id ="fname_label">
							<u>First Name :</u> <%=u.getFirstName()%>
								
						</label>
						
						<label class="reg" id ="lname_label">
							<u>Last Name :</u> <%=u.getLastName()%>
								
						</label>
						
						<label class="reg" id ="addr1_label">
							<u>Address Line 1 :</u> <%=u.getAddress1()%>
								
						</label>
						
						<label class="reg" id ="addr2_label">
							<u>Address Line 2 :</u> <%=u.getAddress2()%>
								
						</label>
						
						<label class="reg" id ="city_label">
							<u>City :</u> <%=u.getCity()%>
								
						</label>
						
						<label class="reg" id ="country_label">
							<u>Country :</u> <%=u.getCountry()%>
								
						</label>
						
						<label class="reg" id ="phone_label">
							<u>Phone Number :</u> <%=u.getPhone() %>
								
						</label>
						
                                            <label class="reg" id="dob">
							<u>Date of Birth :</u> <%=u.getDob()%>
                 
							
                                                        </label>
                                        
					<INPUT Type="BUTTON" VALUE="Change Details" ONCLICK="window.location.href='changeDetails.jsp'" id="changeDetails">
				
					</fieldset>
                                       <%
                                        }
                                        else
                                    {
                                        %>
                                        <p>Session has Timed out, Please log-in again!</p>
                                        <%
                                      
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
