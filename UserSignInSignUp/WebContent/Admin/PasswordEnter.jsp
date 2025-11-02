<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Upadte</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


</head>
<body>


	<style>
#createid {
	position: absolute;
	width: 350px;
	height: 500px;
	padding: 20px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.form {
	padding: 20px;
}
</style>


	<section id="createid">
		<div class="card z-depth-3">
			<div class="card-panel center light blue darken-3">
				<span class="btn-large light-blue darken-3">Create New Password</span>

			</div>
			<form class="form" action="update" method="post">

				<div class="input-field">
					<input type="password" class="validate" name="Password" required="true">
					 <label>Password</label>
				</div>

				<div class="center">
					<button type="submit" class="btn-large light-blue darken-3">Confirm&Submit</button>

				</div>

			</form>

		</div>


	</section>

</body>
</html>