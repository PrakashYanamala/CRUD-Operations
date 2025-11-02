<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
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


</body>
</html>