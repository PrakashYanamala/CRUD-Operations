<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Re-enter date page</title>
</head>
<body>

<h1> You entered wrong date, please re- enter the valid date</h1>


<form action="checkdate"  modelAttribute="appdata" method="post" >
        
   <!--      Row 1: Appointment ID, Name, Email, date
        <div  >
        
            <div>
                <label for="AppointmentID">Appointment ID:</label><br>
                <input type="number" id="AppointmentID" name="AppointmentID" required="true"></input>
            </div>
            
            
            <div >
                <label for="Patient_Name">Patient Name:</label><br>
                <input type="text" id="Patient_Name" name="Patient_Name" required="true" ></input>
            </div>
             -->
            
            <div >
                <label for="Appointment_Date">Appointment_Date:</label><br>
                <input type="date" id="Appointment_Date" name="Appointment_Date" required="true" ></input>
            </div><br>
            
            <div >
            <input type="submit" value="Postpone Appointment" style="background-color:red; color:white; padding:10px 25px; border:none; cursor:pointer; font-size: 16px;">
        </div>
        
           
           </div>
           </form>




</body>
</html>