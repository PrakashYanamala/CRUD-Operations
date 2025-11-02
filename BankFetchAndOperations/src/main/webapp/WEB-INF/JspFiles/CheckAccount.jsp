<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>

<h1>Enter the below details and get your account details</h1><br>

<table>
<spri:form modelAttribute="bankdata" action="login">
<tr><td>Account Number :<td><td>  <spri:input type="number" path="accountNum" required="true"/><td><tr><br>
<tr><td>Pin Number:<td><td>  <spri:input type="password" path="pinNum" required="true"/><td><tr><br>
<tr><td><input type="submit" value="Submit" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>

</body>
</html>