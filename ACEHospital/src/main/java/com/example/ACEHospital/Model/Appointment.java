package com.example.ACEHospital.Model;

import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="ACE_HOSPITALS")
public class Appointment {

	@Id
	@Column(name = "APPOINTMENT_ID")
	private int AppointmentID;
	
	@Column(name = "PATIENT_NAME")
	private String Patient_Name;
	
	
	@Column(name = "PATIENT_EMAIL")
	private String Patient_Email;
	
	
	@Column(name = "PATIENT_PHONE_NUM")
	private Long Patient_Phone;
	
	
	@Column(name = "CONS_DEPARTMENT")
	private String Consult_Dept;
	
	
	@Column(name = "CONS_DOCTOR")
	private String Consult_Doctor;
	
	@Column(name = "APPOINTMENT_DATE")
	private Date Appointment_Date ;

	
	public Date getAppointment_Date() {
		return Appointment_Date;
	}


	public void setAppointment_Date(Date appointment_Date) {
		Appointment_Date = appointment_Date;
	}


	@Column(name = "PATIENT_MESSAGE")
	private String Patient_Messge;


	public int getAppointmentID() {
		return AppointmentID;
	}


	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}


	public String getPatient_Name() {
		return Patient_Name;
	}


	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}


	public String getPatient_Email() {
		return Patient_Email;
	}


	public void setPatient_Email(String patient_Email) {
		Patient_Email = patient_Email;
	}


	public Long getPatient_Phone() {
		return Patient_Phone;
	}


	public void setPatient_Phone(Long patient_Phone) {
		Patient_Phone = patient_Phone;
	}


	public String getConsult_Dept() {
		return Consult_Dept;
	}


	public void setConsult_Dept(String consult_Dept) {
		Consult_Dept = consult_Dept;
	}


	public String getConsult_Doctor() {
		return Consult_Doctor;
	}


	public void setConsult_Doctor(String consult_Doctor) {
		Consult_Doctor = consult_Doctor;
	}


	public String getPatient_Messge() {
		return Patient_Messge;
	}


	public void setPatient_Messge(String patient_Messge) {
		Patient_Messge = patient_Messge;
	}
	
	
	
	
}
