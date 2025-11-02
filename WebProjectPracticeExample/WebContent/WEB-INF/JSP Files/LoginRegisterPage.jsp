<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register Page</title>
</head>
<body>

<Body background="/Images/Bankimage.jpeg">


<script type="text/javascript">

function register() {
	
	var reg = document.getElementById("registerID");
	var log = document.getElementById("loginID");
	
	reg.style.display = "block";
	log.style.display = "none";
	
}

function login() {
	
	var reg = document.getElementById("registerID");
	var log = document.getElementById("loginID");
	
	reg.style.display = "none";
	log.style.display = "block";
}

</script>

<Style>

.RegButt{
  background-color: #E329AA;
}

.LogButt{
  background-color: green;
}

div {
	width: 600px;
}

body {
	background-color: #29E3D3;
	background-image: 
}
</Style>








<h1>Click the below buttons for login/Register</h1><br><br>

<button onclick="register()" class="RegButt" >Register</button><br><br>
<button onclick="login()" class="LogButt" >Login</button><br><br>


<div style="display: none; background: green" id="loginID">
<h1>Enter the below details for login</h1><br><br>

<form action="loginservlet" method="post">
<table>
<tr><td>Email: <td><td> <input type="email" name="Email" required="true"></input><br><td><tr>
<tr><td>Password: <td><td> <input type="password" name="password" required="true"></input><br><td><tr>
<tr><td> <input type="submit" value="login" ></input><br><td><tr>

</table>
</form>
<br><br>

<a href="register"> register here if not register</a>

</div>





<div style="display: none; background: #E329AA" id="registerID">
<h1>Enter the below details for register</h1>
<form action="registerservlet" method="post">
<table>

<tr><td>Student Name: <td><td> <input type="text" name="StudentName" required="true"></input><br><td><tr>
<tr><td> Email: <td><td> <input type="email" name="Email" required="true"></input><br><td><tr>
<tr><td> Password: <td><td><input type="password" name="password" required="true"></input><br><td><tr>
<tr><td> MobileNum: <td><td> <input type="number" name="MobileNum" required="true"></input><br><td><tr>
<tr><td> Date of Birth: <td><td> <input type="date" name="DOB" required="true"></input><br><td><tr>
<tr><td> <input type="submit" value="register"></input><br><td><tr>

</table>
</form>
<br><br>

<a href="login">Please login if already registered</a>

</div>





</body>
</html>