<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Enter below details for login</h1>

<form action="login" method="post">
<table>
<tr><td>Email: <td><td><input type="email" name="Email" required="true"></input><br><td><tr>
<tr><td>Password: <td><td><input type="password" name="Password" required="true"></input><br><br><td><tr>
<tr><td><input type="submit" value="Login"></button><td><tr>

</table>
</form>
<br>

<a href="registerPage">If not register please register here</a>

</body>
</html>