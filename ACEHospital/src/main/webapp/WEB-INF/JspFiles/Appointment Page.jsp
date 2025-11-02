<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Page</title>

  <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9; /* Light background color */
            color: #333; /* Dark text color for readability */
            margin: 0;
            padding: 0;
        }

        /* Section Styles */
        .appointment {
            background-color: #ffffff; /* White background for the form section */
            border-radius: 10px; /* Rounded corners for the form section */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Light shadow */
            padding: 40px 0;
            margin: 20px auto;
            max-width: 900px;
        }

        h2, h3 {
            color: #0288d1; /* Blue color for the headings */
        }

        h2 {
            font-size: 2rem;
            margin-bottom: 10px;
        }

        h3 {
            font-size: 1.2rem;
            margin-bottom: 20px;
        }

        /* Form Styles */
        form {
            max-width: 800px;
            margin: auto;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        /* Input and Select Fields */
        input[type="text"], input[type="email"], input[type="number"], input[type="number"], input[type="date"], select, textarea {
            width: 100%;
            padding: 12px;
            border-radius: 5px;
            border: 1px solid #ddd;  /* box boarder thickness */
            font-size: 1rem;
             box-sizing: border-box; 
        }

        input[type="text"]:focus, input[type="email"]:focus, input[type="number"]:focus, input[type="number"]:focus, input[type="date"]:focus, select:focus, textarea:focus {
            border-color: #0288d1; /* Blue focus color */
            outline: none;
        }

        /* Flexbox Layout for Input Rows */
        .flex-row {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }

        .flex-row div {
            flex: 1;
        }

        /* Message Section */
        textarea {
            margin-top: 10px;
        }

        /* Submit Button */
        input[type="submit"] {
            background-color: #0288d1; /* Blue background */
            color: white;
            padding: 12px 25px;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0277bd; /* Darker blue on hover */
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .flex-row {
                flex-direction: column;
            }

            .flex-row div {
                flex: 1 0 100%;
            }

            textarea {
                width: 90%;
            }
        }
    </style>
    
</head>
<body>



<section id="appointment" class="appointment" style="padding: 40px 0;">
    <h2 style= "text-align: center;">Book an Appointment</h2>
    <h3 style="text-align: center;">Enter the below details for Appointment booking</h3>
   
    <form action="appnt"  modelAttribute="appdata" method="post"  style="max-width: 800px; margin: auto; display: flex; flex-direction: column; gap: 20px;">
        
        <!-- Row 1: Appointment ID, Name, Email, date -->
        <div style="display: flex; gap: 20px; ">
            <div style="flex: 1;">
                <label for="AppointmentID">Appointment ID:</label><br>
                <input type="number" id="AppointmentID" name="AppointmentID" required="true" style="width: 100%;">
            </div>
            
            
            <div style="flex: 1;">
                <label for="Patient_Name">Patient Name:</label><br>
                <input type="text" id="Patient_Name" name="Patient_Name" required="true" style="width: 100%;">
            </div>
            
            
            <div style="flex: 1;">
                <label for="Patient_Email">Patient Email:</label><br>
                <input type="email" id="Patient_Email" name="Patient_Email" required="true" style="width: 100%;">
            </div>
           
           <div style="flex: 1;">
                <label for="Appointment_Date">Appointment Date:</label><br>
                <input type="date" id="Appointment_Date" name="Appointment_Date" required style="width: 100%;">
            </div> 
            
        </div>

        <!-- Row 2: Phone, Department, Doctor -->
        <div style="display: flex; gap: 20px; flex-wrap: wrap;">
            <div style="flex: 1;">
                <label for="Patient_Phone">Phone Number:</label><br>
                <input type="number" id="Patient_Phone" name="Patient_Phone" required style="width: 100%;">
            </div>
            
            
            <div style="flex: 1;">
                <label for="Consult_Dept">Department:</label><br>
                <select id="Consult_Dept" name="Consult_Dept" required style="width: 100%;">
                    <option value="">--Select--</option>
                    <option value="Cardiology">Cardiology</option>
                    <option value="Neurology">Neurology</option>
                    <option value="Pediatrics">Pediatrics</option>
                    <option value="Orthopedics">Orthopedics</option>
                    <option value="Dermitology">Dermitology</option>
                    <option value="General Surgery">General Surgery</option>
                </select>
            </div>
            
            
            <div style="flex: 1;">
                <label for="Consult_Doctor">Consulting Doctor:</label><br>
                <input type="text" id="Consult_Doctor" name="Consult_Doctor" required style="width: 100%;">
            </div>
            
            <!-- <div style="flex: 1;">
                <label for="App_date">Appointment Date:</label><br>
                <input type="date" id="Consult_Doctor" name="Consult_Doctor" required style="width: 100%;">
            </div> -->
            
        </div>


        <!-- Message Section (Centered Below) -->
        <div style="text-align: center;">
            <label for="Patient_Messge"><strong>Message / Symptoms:</strong></label><br>
            <textarea id="Patient_Messge" name="Patient_Messge" rows="5" required style="width: 80%; margin-top: 10px;"></textarea>
        </div>

        <!-- Submit Button -->
        <div style="text-align: center;">
            <input type="submit" value="Book Appointment" style="background-color:#0288d1; color:white; padding:10px 25px; border:none; cursor:pointer; font-size: 16px;">
        </div>
        
        
    </form><br>
    
    <!-- For cancel appointment  -->
    <form action="cancel"  modelAttribute="appdata" method="post"  style="max-width: 800px; margin: auto; display: flex; flex-direction: column; gap: 20px;">
    <div style="text-align: center;">
            <input type="submit" value="Cancel Appointment" style="background-color:red; color:white; padding:10px 25px; border:none; cursor:pointer; font-size: 16px;">
        </div>
        </form>
        <br>
        
         <!-- For Postpone appointment  -->
    <form action="postpone"  modelAttribute="appdata" method="post"  style="max-width: 800px; margin: auto; display: flex; flex-direction: column; gap: 20px;">
    <div style="text-align: center;">
            <input type="submit" value="Postpone Appointment" style="background-color:red; color:white; padding:10px 25px; border:none; cursor:pointer; font-size: 16px;">
        </div>
        </form>
</section>