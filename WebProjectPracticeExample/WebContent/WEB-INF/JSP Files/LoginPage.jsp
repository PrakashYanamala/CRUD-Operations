<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<style>
    body {
        background-color: #F527E7; /* light blue background */
    }
    table {
        color: #003366; /* dark blue text inside table */
    }
    input[type="email"],
    input[type="password"],
    input[type="submit"] {
        color: #003366; /* text color inside inputs */
        background-color: #f9f9f9; /* light gray background for inputs */
        border: 1px solid #007bff; /* blue border */
        padding: 5px;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
    
    a {
        color: green; /* blue link color */
        text-decoration: none;
        font-weight: bold;
    }
    a:hover {
        color: #ff4500; /* orange hover color */
        text-decoration: underline;
    }
</style>


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

<a href="register"> Register here if not register</a>


</body>
</html>