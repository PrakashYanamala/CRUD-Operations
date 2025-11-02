<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Amount page</title>

<style type="text/css">

html{
background-color: #33fff3
}

</style>
</head>
<body>

<h1 style="color:#FF3346 ;">Enter the amount you want to draw</h1>

<table>
<spri:form modelAttribute="bankdata" action="process">

<tr><td>Amount : <td><td> <spri:input type="number" path="balance" required="true"/><td><tr><br>

<tr><td><input type="submit" value="Save"><br><td><tr>
</spri:form>
</table>
<br>


</body>
</html>