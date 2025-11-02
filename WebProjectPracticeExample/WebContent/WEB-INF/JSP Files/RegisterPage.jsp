<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
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


</body>
</html>