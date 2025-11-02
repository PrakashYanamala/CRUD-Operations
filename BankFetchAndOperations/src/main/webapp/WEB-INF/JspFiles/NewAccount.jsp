<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Account Create</title>
</head>
<body>

<h1>Enter the below details and create your account</h1><br>

<table>
<spri:form modelAttribute="bankdata" action="save">
<tr><td>Customer Name :<td><td> <spri:input type="text" path="customerName" required="true"/><td><tr><br>
<tr><td>Account Number :<td><td>  <spri:input type="number" path="accountNum" required="true"/><td><tr><br>
<tr><td>Bank Balance : <td><td> <spri:input type="number" path="balance" required="true"/><td><tr><br>
<tr><td>Pin Number:<td><td>  <spri:input type="number" path="pinNum" required="true"/><td><tr><br>
<tr><td>Bank Name :<td><td>  <spri:input type="text" path="bankName" required="true"/><td><tr><br>
<tr><td><input type="submit" value="Save"><br><td><tr>
</spri:form>
</table>


</body>
</html>