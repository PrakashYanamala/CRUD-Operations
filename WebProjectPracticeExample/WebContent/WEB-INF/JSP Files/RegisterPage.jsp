<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>

<style>
    body {
        background-color: #e6f2ff; /* soft light blue background */
        font-family: Arial, sans-serif;
    }
    table {
        background-color: #ffffff; /* white table background */
        color: #003366; /* dark blue text */
        padding: 15px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="number"],
    input[type="date"],
    input[type="submit"] {
        color: #003366; /* text color */
        background-color: #f9f9f9; /* input background */
        border: 1px solid #007bff;
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
        color: #007bff; /* link color */
        text-decoration: none;
        font-weight: bold;
    }
    a:hover {
        color: #ff4500; /* hover color */
        text-decoration: underline;
    }
</style>


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