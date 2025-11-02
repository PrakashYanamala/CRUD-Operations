package com.example.ACEHospital.ServiceImpl;

import java.util.Iterator;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ACEHospital.Model.Appointment;
import com.example.ACEHospital.Repository.HospitalRepository;
import com.example.ACEHospital.Service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hr;

	@Override
	public void dosave(Appointment app) {
		hr.save(app);

	}

	// check the details correct or not for cancel
	@Override
	public boolean CheckDetails(Appointment app, Appointment apDB) {
		List<Appointment> app1 = hr.findAll(); // to Get all appointments data from DB

		for (Iterator<Appointment> itr = app1.iterator(); itr.hasNext();) {
			Appointment apDB1 = itr.next();

			if (app != null && apDB1 != null && app.getAppointmentID() != 0 && app.getPatient_Name() != null
					&& app.getAppointment_Date() != null && apDB1.getAppointmentID() != 0
					&& apDB1.getPatient_Name() != null && apDB1.getAppointment_Date() != null) {

				// Compare all fields
				if (app.getAppointmentID() == apDB1.getAppointmentID()
						&& app.getPatient_Name().equalsIgnoreCase(apDB1.getPatient_Name())
						&& app.getAppointment_Date().equals(apDB1.getAppointment_Date())) {
                      
					System.out.println("--------------Check details for cancel Appointment---------");
					System.out.println("pt name from service = " + app.getPatient_Name());
					System.out.println("pt name from DB = " + apDB1.getPatient_Name()); // FIXED: used apDB1

					return true;
				}
			}
		}

		return false;
	}

	// for cancel the appointment
	@Override
	public boolean deletedata(Appointment app, Appointment apDB) {

		List<Appointment> app1 = hr.findAll(); // To check ac num and pin are correct or not

		System.out.println("-----------cancel appointment--------------------");
		System.out.println("ID for delete = " + app.getAppointmentID());
		System.out.println("ID from DB check = " + apDB.getAppointmentID());

		// List<Appointment> app1 = hr.findAll(); // To check ac num and pin are correct
		// or not

		for (Iterator<Appointment> itr = app1.iterator(); itr.hasNext();) {
			Appointment apDB1 = itr.next();

			// System.out.println("ID from DB check = " + apDB1.getAppointmentID());
			// hr.delete(apDB1); // it delete all records
			
			if (app.getAppointmentID() == apDB1.getAppointmentID()
					&& app.getPatient_Name().equalsIgnoreCase(apDB1.getPatient_Name())
					&& app.getAppointment_Date().equals(apDB1.getAppointment_Date())) {

				hr.delete(apDB1);

			}

		}

		return false;

	}
	

	// to check details for postpone
	@Override
	public boolean CheckPostDetails(Appointment app, Appointment apDB) {

		List<Appointment> app1 = hr.findAll(); // to Get all appointments data from DB

		System.out.println(); // for some space
		for (Iterator<Appointment> itr = app1.iterator(); itr.hasNext();) {
			Appointment apDB1 = itr.next();

			
			if (app != null && apDB1 != null && app.getAppointmentID() != 0 && app.getPatient_Name() != null
					&& app.getAppointment_Date() != null && apDB1.getAppointmentID() != 0
					&& apDB1.getPatient_Name() != null && apDB1.getAppointment_Date() != null) {

				// Compare all fields
				if (app.getAppointmentID() == apDB1.getAppointmentID()
						&& app.getPatient_Name().equalsIgnoreCase(apDB1.getPatient_Name())
						&& app.getAppointment_Date().equals(apDB1.getAppointment_Date())) {

					System.out.println("----------------Checking postpone details-----------------");
					System.out.println("pt name from service (Postpone) = " + app.getPatient_Name());
					System.out.println("pt name from DB (Postpone) = " + apDB1.getPatient_Name()); // FIXED: used apDB1

					return true;
				}
			}
		}

		return false;
	}

	// for check the date valid or not
	@Override
	public boolean CheckDate(Appointment app, Appointment apDB, HttpSession ss) {
	    
		 List<Appointment> appList = hr.findAll();
         System.out.println(); // for space
         System.out.println("--------------date update --------------");
    
    
    for (Appointment apDB1 : appList) {
        // Find the matching appointment by ID
    	if (app.getAppointmentID() == apDB.getAppointmentID()
				&& app.getPatient_Name().equalsIgnoreCase(apDB.getPatient_Name())
				&& app.getAppointment_Date().equals(apDB.getAppointment_Date())) {
    	
    		System.out.println("date from service = "+app.getAppointment_Date());
    	    System.out.println("date from DB = "+apDB.getAppointment_Date());
        	//System.out.println("date from DB = "+apDB1.getAppointment_Date());
            // Compare new date with the existing date
            if (!app.getAppointment_Date().equals(apDB1.getAppointment_Date()) &&
                app.getAppointment_Date().after(apDB1.getAppointment_Date())) {

                // New date is different and greater than existing date
            	apDB1.setAppointment_Date(app.getAppointment_Date());
            	hr.save(apDB1);

                return true;  // Updated successfully
            }

    	} 
    }
	
    return false;
		
	   
		
	}

	/*
	 * @Override public String dosavedate(Appointment app) { hr.save(app); return
	 * "Appointment Postponed successfully"; }
	 */
	
}
