<%-- 
    Document   : changeDetails
    Created on : 11-Dec-2013, 21:17:32
    Author     : Miteto
--%>

<%@page import="DAO.Package.User_DAO"%>
<%@page import="DTO.Package.User_DTO"%>

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
                                <% 
                                    User_DAO dao = new User_DAO();
                                    if(session.getAttribute("uName") != null)
                                    {
                                        String name = (String)session.getAttribute("uName");
                                        User_DTO u = new User_DTO();
                                        u = dao.getUser(name);   
                                    %>
				<form id="userDetails" action="UserActionServlet" method="post" >
                                    
					<fieldset id="details">
						<label class="reg" id ="unamereg_label ">
							Username
							<input type="text" id="uname_txt" name="uname_txt" value="<%=u.getUserName()%>" />	
						</label>
						
						<label class="reg" id ="passreg_label">
							Password
							<input type="text" id="pass_txt" name="pass_txt" value="<%=u.getPassword()%>" />	
						</label>
						
						<label class="reg" id ="fname_label">
							First Name
							<input type="text" id="fname_txt" name="fname_txt" value="<%=u.getFirstName()%>" />	
						</label>
						
						<label class="reg" id ="lname_label">
							Last Name
							<input type="text" id="lname_txt" name="lname_txt" value="<%=u.getLastName()%>" />	
						</label>
						
						<label class="reg" id ="addr1_label">
							Address Line 1
							<input type="text" id="addr1_txt" name="addr1_txt" value="<%=u.getAddress1()%>" />	
						</label>
						
						<label class="reg" id ="addr2_label">
							Address Line 2
							<input type="text" id="addr2_txt" name="addr2_txt" value="<%=u.getAddress2()%>" />	
						</label>
						
						<label class="reg" id ="city_label">
							City
							<input type="text" id="city_txt" name="city_txt" value="<%=u.getCity()%>" />	
						</label>
						
						<label class="reg" id ="country_label">
							Country
							<input type="text" id="country_txt" name="country_txt" value="<%=u.getCountry()%>"/>	
						</label>
						
						<label class="reg" id ="phone_label">
							Phone Number
							<input type="text" id="phone_txt" name="phone_txt" value="<%=u.getPhone()%>" />	
						</label>
						
                                            <label class="reg" id="dob">
							Date of Birth
                                                        <input type="text" id="dob_txt" name="dob_txt" value="<%=u.getDob()%>" />
							
                                            </label>
                                        
					<input type="hidden" name="action" value="update" />
					<input style="cursor:pointer;" type="submit" value="Update Details" id="updateDetails" />
				
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
