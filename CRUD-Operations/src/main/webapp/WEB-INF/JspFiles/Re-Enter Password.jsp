<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Re-enter password</title>
</head>
<body>

<h1>your new password is same as old password, please enter different password</h1><br><br>

<table>
<spri:form modelAttribute="studentsData" action="passup">
<%-- <tr><td>Email: </td><td> <spri:input type="email" path="stMail" required="true"/><br></td></tr> --%>
<tr><td>Password: </td><td> <spri:input type="password" path="password" required="true"/><br></td></tr>
<tr><td><input type="submit" value="submit" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>
<br><br>

</body>
</html>