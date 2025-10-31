<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>


<style>
    body {
        background-color: #27F5F2;
        font-family: Arial, sans-serif;
       
        text-align: left;
        
        margin-top: 100px;
    }

    h1 {
    background-color: navy;
        color: #fff;
        font-size: 24px;
        margin-bottom: 30px;
        padding: 10px 20px;
        margin: 10px;
        border-radius: 5px;
    }

    a {
        display: inline-block;
        text-decoration: none;
        background-color: navy;
        color: white;
        padding: 10px 20px;
        margin: 10px;
        border-radius: 5px;
    }

    a:hover {
        background-color: darkblue;
    }
</style>

</head>
<body>
<h1>Click the below link for Login/ Register/ Update/ Delete of a student record</h1><br><br>

<a href="register">Register</a><br><br>
<a href="login">Login</a><br><br>
<a href="update">Update A Record</a><br><br>
<a href="delete">Delete A Record</a><br><br>


</body>
</html>