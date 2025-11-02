<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

</head>
<body>



	<style>
#updateid {
	position: fixed;
	width: 350px;
	height: 500px;
	padding: 20px;
	top: 50%;
	left: 50%;
	border: 3px solid #73AD21;
	/* bottom: 50%;
	right: 50%; */
	transform: translate(-50%, -50%);
	left: 50%;
}

.form {
	padding: 20px;
}
</style>


	<section id="updateid">
		<div class="card z-depth-3">

			<div class="card-panel center light blue darken-3">
				<span class=" green darken-3">Enter User name & Email</span>
			</div>

			<form class="form" action="send" method="post">

				<div class="input-field">
					<input type="text" class="validate" name="Name" required="true"></input>
					<label>User Name </label>
				</div>

				<div class="input-field">
					<input type="email" class="validate" name="Email" required="true"></input>
					<label>Email</label>
				</div>

				<div class="center">
					<button type="submit" class="btn-large light-blue darken-3">Submit</button>
				</div>


				<!-- div class="center">
<a href="enternew"></a>
</div> -->

			</form>

		</div>

	</section>


</body>
</html>