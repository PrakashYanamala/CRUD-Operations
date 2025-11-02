<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spri" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Page</title>


<!-- <script src="jsFolder/myScript.js"></script>
<link rel="stylesheet" href="cssFolder/myStyle.css">
<link rel="icon" type="image/x-icon" href="imageFolder/lakshmi.jpg">
 -->
 
 

 <style type="text/css">

html{
	background-color: #FF33E3 ;
}

.regi{
	background-color: #33FFE9 ;
	width: 400px;
}
.logi{
	background-color: #33FF68 ;
		width: 400px;
}

button {
	background: #FAD7A0;
}

</style> 

<script type="text/javascript">

function createAcc(){
	var reg = document.getElementById("reg");
	var log = document.getElementById("log");
	
	log.style.display = "none";
	reg.style.display = "block";
	
	
}

function check(){
	var reg = document.getElementById("reg");
	var log = document.getElementById("log");
	
	log.style.display = "block";
	reg.style.display = "none";
	
	
}



</script> 

</head>
<body>

<h1>Click the below buttons for create acc/ Check Acc Details</h1><br><br>

<button onclick="createAcc();">Create Acc</button>&nbsp;&nbsp;&nbsp;<button onclick="check();">Check Acc</button>
<br><br>
<div style="display: none;" id="reg" class="regi">
<br>
<h1>Create your account with filling the form</h1><br>
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
<br>
</div>

<div style="display: none;" id="log" class="logi">
<br>
<h1>Check your Account Details</h1><br>
<table>
<spri:form modelAttribute="bankdata" action="login">
<tr><td>Account Number :</td><td> <spri:input type="number" path="AccountNum" required="true"/><br></td></tr>
<tr><td>Pin Number: </td><td> <spri:input type="number" path="PinNum" required="true"/><br></td></tr>
<tr><td><input type="submit" value="Submit" style="background-color: #A3E4D7"></td></tr>
</spri:form>
</table>

<br>
</div>

</body>
</html>