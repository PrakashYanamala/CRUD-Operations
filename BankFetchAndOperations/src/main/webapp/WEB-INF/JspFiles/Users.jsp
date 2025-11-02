<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "cor" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>
<table border="1" style="width: 100%;">
<tr style="background-color: red;"><th>Customer Name</th><th>Account Number</th><th>Balance</th><th>Pin Number</th><th>Bank Name</th></tr>
<%-- <cor:forEach items="${bankk}" var="bank" > --%>
<tr style="background-color: #33FFE9;">
 <td><cor:out value="${bankdata.customerName}"></cor:out></td>
    <td><cor:out value="${bankdata.accountNum}"></cor:out></td>
    <td><cor:out value="${bankdata.balance}"></cor:out></td>
    <td><cor:out value="${bankdata.pinNum}"></cor:out></td>
    <td><cor:out value="${bankdata.bankName}"></cor:out></td>
</tr>
<%-- </cor:forEach> --%>
</table>

</body>
</html>