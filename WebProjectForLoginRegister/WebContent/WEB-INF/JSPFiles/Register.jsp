<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register Page</title>
</head>
<body>
<h1>Enter below details for Register</h1>

<form action="register" method="post">
<table>
<tr><td>Name:<td><td><input type="text" name="UserName" required="true"></input><br><td><tr>
<tr><td>Email:<td><td><input type="email" name="Email" required="'true"></input><br><td><tr>
<tr><td>Password:<td><td><input type="password" name="Password" required="true"></input><br><td><tr>
<tr><td>MobileNum:<td><td><input type="number" name="MobNum" required="true"></input><br><td><tr>
<tr><td>Date of Birth:<td><td><input type="date" name="DOB" required="true"></input><br><td><tr>
<tr><td><input type="submit" value="Register"><br><td><tr>
</table>
</form>
<br>

<a href="loginPage">If already register please login here</a>

</body>
</html>