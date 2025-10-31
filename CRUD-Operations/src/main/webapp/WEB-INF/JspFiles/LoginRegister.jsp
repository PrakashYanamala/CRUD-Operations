<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login/Register</title>


<!-- <script src="jsFolder/myScript.js"></script>
<link rel="stylesheet" href="cssFolder/myStyle.css">
<link rel="icon" type="image/x-icon" href="imageFolder/lakshmi.jpg">
 -->

<style type="text/css">

html{
	background-color: #48C9B0;
}

.regi{
	background-color: green;
	width: 320px;
}
.logi{
	background-color: red;
		width: 320px;
}

button {
	background: #FAD7A0;
}

</style>

<script type="text/javascript">

function register(){
	var reg = document.getElementById("reg");
	var log = document.getElementById("log");
	
	log.style.display = "none";
	reg.style.display = "block";
	
	
}

function login(){
	var reg = document.getElementById("reg");
	var log = document.getElementById("log");
	
	log.style.display = "block";
	reg.style.display = "none";
	
	
}



</script>

</head>
<body>

<button onclick="register();">Register</button>&nbsp;&nbsp;&nbsp;<button onclick="login();">Login</button>
<br><br>


<div style="display: none;" id="reg" class="regi">
<br>
<table>
<spri:form modelAttribute="studentData" action="register">
<tr><td>Roll Number: </td><td> <spri:input type="number" path="rollNum" required="true"/><br></td></tr>
<tr><td>Name: </td><td> <spri:input type="text" path="stName" required="true"/><br></td></tr>
<tr><td>Mail: </td><td> <spri:input type="email" path="stMail" required="true"/><br></td></tr>
<tr><td>Joining Date: </td><td> <spri:input type="date" path="joiningDate" required="true"/><br></td></tr>
<tr><td><input type="submit" value="Register" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>	
<br>
</div>

<div style="display: none;" id="log" class="logi">
<br>
<table>
<spri:form modelAttribute="studentData" action="login">
<tr><td>Roll Number: </td><td> <spri:input type="number" path="rollNum" required="true"/><br></td></tr>
<tr><td>Mail: </td><td> <spri:input type="email" path="stMail" required="true"/><br></td></tr>
<tr><td><input type="submit" value="Login" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>
<br>
</div>

</body>
</html>