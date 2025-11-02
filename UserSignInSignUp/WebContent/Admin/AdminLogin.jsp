<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<!-- Compiled and minified JavaScript -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
	<!-- <h1>Admin Login</h1> -->


	<style type="text/css">
#loginId {
	position: absolute;
	width: 350px;
	height: 300px;
	padding: 20px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
/* div {
	width: 400px;
} */
</style>





	<div style="display: block;" id="loginId"
		class="card-panel center Light-blue darken-3">
		<span class="card-title" class="card-panel center Light-blue darken-3">Admin
			login</span>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Email:
					<td>
					<td><input type="email" name="email" required="true"></input>
				<tr>
					<td>Password:
					<td>
					<td><input type="password" name="password" required="true"></input><br>
			</table>
			<br> <input type="submit" value="login" class="center">
			</button>
			<br> <a href="forgot" class="center">Forget Password?</a>

		</form>
	</div>

	<br>
	<br>
	<br>

</body>
</html>