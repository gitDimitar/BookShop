<%-- 
    Document   : listOrders
    Created on : 17-Dec-2013, 13:39:08
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
                            
                            <h1> All Orders </h1>
                            
                            <table >
                                <tr>
                                    <th>UserID</th>
                                    <th>Order Num</th>
                                    <th>Book ID</th>
                                    <th>Quantity</th>
                                    
                                </tr>
                            
                            <% 
                                order_DAO odao = new order_DAO();
                                ArrayList<order_DTO> orders = new ArrayList<order_DTO>();
                                orders = odao.displayAllOrders();
                                if(orders != null)
                                {
                                
                                    for(order_DTO o: orders )
                                    {
                                       
                                       
                             %>
				<tr>
				<div style="clear:left;">
				
                                    <td><%=o.getUserID()%></td>
                                    <td><%=o.getOrderID()%></td>
                                    <td><%=o.getBookID()%></td>
                                    <td><%=o.getQuantity()%></td>
                                    <%--<td><a href="UserActionServlet?action=deleteUser&value=<%=o.getUserID()%>"><INPUT Type="BUTTON" VALUE="Delete" ONCLICK="" id="del_user"></a></td>
                                	--%>
					
                                               
					
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
