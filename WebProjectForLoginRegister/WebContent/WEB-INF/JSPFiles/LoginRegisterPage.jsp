<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register Page</title>
</head>
<body>
<h1>Login/Register Page</h1>

<script type="text/javascript">

function register() {
	
	var reg = document.getElementById("registerId");
	var log = document.getElementById("loginId");
	
	reg.style.display="block";
	log.style.display="none";
	
}

function login() {
	var reg = document.getElementById("registerId");
	var log = document.getElementById("loginId");
	
	reg.style.display="none";
	log.style.display="block";
	
	
}


</script>


<style type="text/css">

.RegButt{
  background-color: red;
}

.LogButt{
   background-color: green;
}

div {
	width: 400px;
}



</style>


<button  onclick="register()" class="RegButt">Register</button><br><br>
<button onclick="login()" class="LogButt">Login</button><br><br>


<div style="display: none; background: red" id="registerId" >
<form action="register" method="post">
<table>
<tr><td>Name:<td><td><input type="text" name="UserName" required="true"></input><br><td><tr>
<tr><td>Email:<td><td><input type="email" name="Email" required="'true"></input><br><td><tr>
<tr><td>Password:<td><td><input type="password" name="Password" required="true"></input><br><td><tr>
<tr><td>MobileNum:<td><td><input type="number" name="MobNum" required="true"></input><br><td><tr>
<tr><td>Date of Birth:<td><td><input type="date" name="DOB" required="true"></input><br><td><tr>
<tr><td><input type="submit" value="Register"><br><td><tr>
</table>
</form><br><br>
<a href="loginPage">If already registered, please login</a>

</div>
<br><br><br><br>

<div style="display:none; background: green" id="loginId">
<form action="login" method="post">
<table>
<tr><td>Email: <td><td><input type="email" name="Email" required="true"></input><br><td><tr>
<tr><td>Password: <td><td><input type="password" name="Password" required="true"></input><br><br><td><tr>
<tr><td><input type="submit" value="Login"></button><td><tr>
</table>
</form><br><br>

<a href="registerPage">If not registered, please register here</a>
</div>
<br><br><br>





</body>
</html>