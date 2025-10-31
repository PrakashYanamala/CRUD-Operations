<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update Page</title>

<style>
body {
    background-color: #27F531;
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



input[type="email"],
input[type="password"],
 {
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

<h1>Enter the details which you want to update </h1><br><br>

<table>
<spri:form modelAttribute="studentsData" action="updatedd">
<tr><td>Email: </td><td> <spri:input type="email" path="stMail" required="true"/><br></td></tr>
<tr><td>Password: </td><td> <spri:input type="password" path="password" required="true"/><br></td></tr>
<tr><td><input type="submit" value="submit" style="background-color: #2A27F5"></td></tr>
</spri:form>
</table>
<br><br>


</body>
</html>