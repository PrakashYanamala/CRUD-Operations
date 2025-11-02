<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ACE Hospital</title>


<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

header {
	background-color: #0288d1;
	color: white;
	padding: 20px;
	text-align: center;
}

nav {
	background-color: #0277bd;
	padding: 10px;
	text-align: center;
}

nav a {
	color: white;
	text-decoration: none;
	padding: 10px 20px;
}

nav a:hover {
	background-color: #01579b;
}

.content {
	padding: 30px;
	text-align: center;
}

.about, .departments, .contact{
	margin-bottom: 40px;
}

img.hospital-img {
	max-width: 80%;
	height: auto;
	border-radius: 10px;
	margin: 20px 0;
}

footer {
	background-color: #eeeeee;
	text-align: center;
	padding: 20px;
	font-size: 14px;
}
</style>
</head>
<body>

	<header>
		<h1>ACE Multi-Specialty Hospital</h1>
		<p>Your health our concern</p>
	</header>

	<nav>
		<a href="#about" style="color: #33FF49;">About Us</a> 
		<a href="#departments" style="color: #33FF49;">Departments</a> 
		<a href="#contact" style="color: #33FF49;">Contact</a>
		 <a href="Appointment" style="color: #33FF49;" >Make an Appointment</a><br>
		<!--  <a href="CancelAppointment" style="color: #33FF49;">Cancel</a> -->
		 
	</nav>

	<div class="content">
		<section id="about" class="about">
			<h2 style="color: red;">About Our Hospital</h2>
			<p>ACE Hospital is a leading health care provider with
				state-of-the-art facilities, expert doctors, and compassionate care.
				We offer 24/7 emergency services, advanced diagnostic tools, and
				patient-centered care.</p>
			<img src="C:\Users\Admin\Downloads\Images\ACE Image.webp"
				alt="Hospital Building" class="hospital-img">
		</section>

		<section id="departments" class="departments">
			<h2 style="color: red;">Our Departments</h2>
			<ul style="list-style: none; padding: 0;">
			<li style="color: green;">&#x2714; Cardiology</li>
            <li style="color: green;">&#x2714; Neurology</li>
            <li style="color: green;">&#x2714; Pediatrics</li>
            <li style="color: green;">&#x2714; Orthopedics</li>
            <li style="color: green;">&#x2714; General Surgery</li>
				
			</ul>
			
			<img
				src="https://via.placeholder.com/700x300?text=Hospital+Departments"
				alt="Departments" class="hospital-img">
		</section>
		
		

		<section id="contact" class="contact">
			<h2 style="color: red;">Contact Us</h2>
			<p>
				<strong>Address:</strong> 123 Health Street, Marathalli, Bangalore, Karnakata, 560037
			</p>
			<p>
				<strong>Email:</strong> contact@acehospital.com
			</p>
			<p>
				<strong>Phone:</strong> +91 234-567-8900
			</p>
			<img src="https://via.placeholder.com/600x300?text=Contact+Us"
				alt="Contact Info" class="hospital-img">
		</section>
	</div>
	
	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d22640.756584178216!2d77.67192124769777!3d12.958038614034423!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae13b4551d0957%3A0x597894d77e1e4919!2sMarathahalli%2C%20Bengaluru%2C%20Karnataka!5e1!3m2!1sen!2sin!4v1744306456340!5m2!1sen!2sin" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

	<footer> &copy; 2025 ACE Hospital. All rights reserved. </footer>



</body>
</html>