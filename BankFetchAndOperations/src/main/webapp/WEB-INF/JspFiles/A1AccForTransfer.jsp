<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A/C Page for A1 Account</title>
</head>
<body>

<h1>Enter the details of A1 Account details(A/c num & Pin Num )</h1><br>


<table>
<spri:form modelAttribute="bankdata" action="transferacc">
<tr><td>Account Number :</td><td> <spri:input type="number" path="AccountNum" required="true"/><br></td></tr>
<tr><td>Pin Number: </td><td> <spri:input type="number" path="PinNum" required="true"/><br></td></tr>
<tr><td><input type="submit" value="Submit" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>

<br>

</body>
</html>