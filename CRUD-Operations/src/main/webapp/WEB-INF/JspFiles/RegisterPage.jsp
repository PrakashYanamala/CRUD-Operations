<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>


<style>
body {
    background-color: lightblue;
    font-family: Arial;
    text-align: center;
    margin-top: 50px;
}

table {
    margin: auto;
    border: 1px solid black;
    padding: 10px;
    background-color: white;
}

td {
    padding: 5px;
}

h1 {
    color: navy;
}

h2 {
    color: green;
}

input[type="text"],
input[type="email"],
input[type="password"],
input[type="number"],
input[type="date"] {
    padding: 5px;
}

input[type="submit"] {
    /* background-color: #2A27F5; */
    color: white;
    padding: 5px 10px;
    border: none;
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
</style>


</head>
<body>

<h1>Enter the below details for register</h1><br><br>

<table>
<spri:form modelAttribute="studentsData" action="registerdd">
<tr><td>Student Name: </td><td> <spri:input type="text" path="stName" required="true"/><br></td></tr>
<tr><td>Email: </td><td> <spri:input type="email" path="stMail" required="true"/><br></td></tr>
<tr><td>Password: </td><td> <spri:input type="password" path="password" required="true"/><br></td></tr>
<tr><td>MobileNum: </td><td> <spri:input type="number" path="mobileNum" required="true"/><br></td></tr>
<tr><td>Date of Birth: </td><td> <spri:input type="date" path="dob" required="true"/><br></td></tr>
<tr><td><input type="submit" value="Register" style="background-color: #2A27F5"></td></tr>
</spri:form>
</table>	
<br><br><br>

<h2>If already registered, please login here</h2><br>
<a href="login">Login</a><br>


</body>
</html>