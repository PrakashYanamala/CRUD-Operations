<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Amount</title>

<style type="text/css">

html{
background-color: #FF33E3
}



</style>

</head>
<body>
<h1 style="color:#33FF49 ;">Enter the below details for withdraw amount</h1><br>

<table>
<spri:form modelAttribute="bankdata" action="withdrawmoney">
<tr><td>Account Number :<td><td>  <spri:input type="number" path="accountNum" required="true"/><td><tr><br>
<tr><td>Pin Number:<td><td>  <spri:input type="number" path="pinNum" required="true"/><td><tr><br>
<tr><td><input type="submit" value="Submit" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>

</body>
</html>