<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
</head>
<body>


	<style>
#adminlogin {
	position: absolute;
	width: 350px;
	height: 500px;
	padding: 20px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);

	/* background-image: "C:\Users\Admin\Downloads\Bgp"; */
}

.form {
	padding: 20px;
}
</style>



	<section id="adminlogin">
		<div class="card z-depth-3">
			<div class="card-panel center light-blue darken-3">
				<span class=" light-blue darken-3">Admin Login</span>
			</div>

			<form class="form" action="signin" method="post">

				<div class="input-field">
					<input type="email" class="validate" name="Email" required="true">
					<label>Email</label>
				</div>

				<div class="input-field">
					<input type="password" class="validate" name="Password"
						required="true"> <label>Password</label>
				</div>

				<div class="center">
					<button type="submit" class="btn-large light-blue darken-3">Sign
						In</button>
				</div>

				<div class="center">
					<a href="forget">Forget Password?</a>
				</div>

				<div class="center">
					<a href="newuser">New User</a>
				</div>
		</div>

		</form>

		</div>

	</section>

	<!-- Compiled and minified JavaScript -->

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>