<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amount for Transfer</title>

<style type="text/css">

html{
background-color: #33f6ff 
}



</style>

</head>
<body>


<h1 style="color:#FF3346 ;">Enter the amount you want to transfer</h1>

<table>
<spri:form modelAttribute="bankdata" action="processtotransfer">

<tr><td>Amount : <td><td> <spri:input type="number" path="balance" required="true"/><td><tr><br>

<tr><td><input type="submit" value="Save"><br><td><tr>
</spri:form>
</table>
<br>


</body>
</html>