<%-- 
    Document   : manageUsers
    Created on : 17-Dec-2013, 10:44:05
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
                            
                            <h1> All Users </h1>
                            <% if(session.getAttribute("resultUser") != null)
                                {
                            %>            
                            <h2><%=session.getAttribute("resultUser")%></h2>
                            <%
                                }
                            %>
                            <table >
                                <tr>
                                    <th>UserName</th>
                                    <th>Password</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Address 1</th>
                                    <th>Address 2</th>
                                    <th>City</th>
                                    <th>Country</th>
                                    <th>Phone</th>
                                    <th>DateOfBirth</th>
                                    <th>Admin 0/1</th>
                                </tr>
                            
                            <% 
                                User_DAO udao = new User_DAO();
                                ArrayList<User_DTO> users = new ArrayList<User_DTO>();
                                users = udao.getAllUsers();
                                if(users != null)
                                {
                                
                                    for(User_DTO u: users )
                                    {
                                       
                                       
                             %>
				<tr>
				<div style="clear:left;">
				
                                    <td><%=u.getUserName()%></td>
                                    <td><%=u.getPassword()%></td>
                                    <td><%=u.getFirstName()%></td>
                                    <td><%=u.getLastName()%></td>
                                    <td><%=u.getAddress1()%></td>
                                    <td><%=u.getAddress2()%></td>
                                    <td><%=u.getCity()%></td>
                                    <td><%=u.getCountry()%></td>
                                    <td><%=u.getPhone()%></td>
                                    <td><%=u.getDob()%></td>
                                    <td><%=u.getAdmin()%></td>
                                    <td><a href="UserActionServlet?action=deleteUser&value=<%=u.getUserID()%>"><INPUT Type="BUTTON" VALUE="Delete" ONCLICK="" id="del_user"></a></td>
                                	
					
                                               
					
				</div>
                                </tr>
                            <%
                                    }
                                }

                            %>
                           </table>
				<footer>
					<p>
					<b>Made by:</b> Dimitar Papazikov    <b>E-mail:</b>D00133809@student.dkit.ie
					</p>
				</footer>

			</div>
		</div>
		
	</body>
</html>
