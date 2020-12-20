<%-- 
    Document   : registerAgain
    Created on : 21-Nov-2013, 13:20:36
    Author     : D00133809
--%>

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
                            <p style="color:red;"><b>Username already exists, please choose another !!!</b></p>
				<h1> Registration Form</h1>
				<form id="register">
					<fieldset id="details">
						<label class="reg" id ="unamereg_label ">
							Username
							<input type="text" id="uname_txt" name="uname_txt" />	
						</label>
						
						<label class="reg" id ="passreg_label">
							Password
							<input type="text" id="pass_txt" name="pass_txt" />	
						</label>
						
						<label class="reg" id ="fname_label">
							First Name
							<input type="text" id="fname_txt" name="fname_txt" />	
						</label>
						
						<label class="reg" id ="lname_label">
							Last Name
							<input type="text" id="lname_txt" name="lname_txt" />	
						</label>
						
						<label class="reg" id ="addr1_label">
							Address Line 1
							<input type="text" id="addr1_txt" name="addr1_txt" />	
						</label>
						
						<label class="reg" id ="addr2_label">
							Address Line 2
							<input type="text" id="addr2_txt" name="addr2_txt" />	
						</label>
						
						<label class="reg" id ="city_label">
							City
							<input type="text" id="city_txt" name="city_txt" />	
						</label>
						
						<label class="reg" id ="country_label">
							Country
							<input type="text" id="country_txt" name="country_txt" />	
						</label>
						
						<label class="reg" id ="phone_label">
							Phone Number
							<input type="text" id="phone_txt" name="phone_txt" />	
						</label>
						
                                            <label class="reg" id="dob">
							Date of Birth
							<select id="day" name="day">
                                                                <option value="">Day</option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
							</select>
                                                        
                                                      
							<select id="month" name="month">
                                                                <option value="">Month</option>
								<option value="01">Jan</option>
								<option value="02">Feb</option>
								<option value="03">Mar</option>
								<option value="04">Apr</option>
								<option value="05">May</option>
								<option value="06">Jun</option>
								<option value="07">Jul</option>
								<option value="08">Aug</option>
								<option value="09">Sep</option>
								<option value="10">Oct</option>
								<option value="11">Nov</option>
								<option value="12">Dec</option>
							</select>
                                                      
							<select id="year" name="year">
                                                                <option value="">Year</option>
								<option value="1995">1995</option>
								<option value="1994">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
								<option value="1987">1987</option>
								<option value="1986">1986</option>
								<option value="1985">1985</option>
								<option value="1984">1984</option>
								<option value="1983">1983</option>
								<option value="1982">1982</option>
								<option value="1981">1981</option>
								<option value="1980">1980</option>
								<option value="1979">1979</option>
								<option value="1978">1978</option>
								<option value="1977">1977</option>
								<option value="1976">1976</option>
								<option value="1975">1975</option>
								<option value="1974">1974</option>
								<option value="1973">1973</option>
								<option value="1972">1972</option>
								<option value="1971">1971</option>
								<option value="1970">1970</option>
								<option value="1969">1969</option>
							</select>
                                        </label>
					<input type="hidden" name="action" value="Register" />
					<input style="cursor:pointer;" type="submit" value="Register" id="finish_reg" />
				
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
