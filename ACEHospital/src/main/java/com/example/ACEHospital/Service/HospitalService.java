package com.example.ACEHospital.Service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.ACEHospital.Model.Appointment;

@Service
public interface HospitalService {

	public void dosave(Appointment app);

	//public boolean CheckDetails(Appointment app);

	boolean CheckDetails(Appointment app, Appointment apDB);

	 boolean deletedata(Appointment app, Appointment apDB);

	//public void deletedata(Appointment app);

	//public boolean deleteAppointment(Appointment app);

	//public boolean deletingdata(Appointment app, Appointment apDB);

	//public boolean deletedata(Appointment app,  Appointment apDB);
	 
	 boolean CheckPostDetails(Appointment app, Appointment apDB);
	 
	 boolean CheckDate(Appointment app, Appointment apDB, HttpSession ss);

	//public String dosavedate(Appointment app);
	 
	// public void doupate(Appointment appupate);
}
