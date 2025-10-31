<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "cor" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Page</title>
</head>
<body>

<table border="1" style="width: 100%;">
<tr style="background-color: red;"><th>NAME</th><th>EMAIL</th><th>Password</th><th>MOBILE</th><th>DOB</th></tr>
<cor:forEach items="${studentsData}" var="student">
<tr style="background-color: #48C9B0;">
<td><cor:out value="${student.stName}"></cor:out></td>
<td><cor:out value="${student.stMail}"></cor:out></td>
<td><cor:out value="${student.password}"></cor:out></td>
<td><cor:out value="${student.mobileNum}"></cor:out></td>
<td><cor:out value="${student.dob}"></cor:out></td>
</tr>
</cor:forEach>
</table>

</body>
</html>