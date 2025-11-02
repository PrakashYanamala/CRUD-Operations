package com.example.ACEHospital.Controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ACEHospital.Model.Appointment;
import com.example.ACEHospital.Repository.HospitalRepository;
import com.example.ACEHospital.Service.HospitalService;

@RestController
public class Controller {

	@Autowired
	HospitalService hs;

	@Autowired
	HospitalRepository hr;

	@RequestMapping("/")
	public ModelAndView FirstPage() {

		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("Welcome Page");
		return mvc;
	}
	

	@RequestMapping("/Appointment")
	public ModelAndView Appointment() {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("appdata", new Appointment());
		mvc.setViewName("Appointment Page");
		return mvc;

	}

	@RequestMapping("/appnt")
	public ModelAndView Appointmentsave(@ModelAttribute("appdata") Appointment app, HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		// mvc.addObject("appdata", new Appointment());
		// mvc.setViewName("Appointment Page");

		/*
		 * ss.setAttribute("AppID", app.getAppointmentID()); ss.setAttribute("PatName",
		 * app.getPatient_Name()); ss.setAttribute("AppID", app.getAppointment_Date());
		 */

		hs.dosave(app);
		mvc.setViewName("Appointment Success");

		return mvc;

	}

	// for cancel the appointment
	@RequestMapping("/cancel")
	public ModelAndView AppointmentCancel(@ModelAttribute("appdata") Appointment app, HttpSession ss) {

		ss.setAttribute("AppID", app.getAppointmentID());
		ss.setAttribute("PatName", app.getPatient_Name());
		ss.setAttribute("AppDT", app.getAppointment_Date());

		int ID = (int) ss.getAttribute("AppID");
		String PtName = (String) ss.getAttribute("PatName");
		Date Apdt = (Date) ss.getAttribute("AppDT");

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("appdata", new Appointment());
		mvc.setViewName("Cancel Appointment");

		return mvc;

	}

	// To check the appointment details
	@RequestMapping("/appntcan")
	public ModelAndView AppointmentDetailsCheck(@ModelAttribute("appdata") Appointment app, Appointment apDB,
			HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		// mvc.addObject("appdata", new Appointment());

		ss.setAttribute("AppID", app.getAppointmentID());
		ss.setAttribute("PatName", app.getPatient_Name());
		ss.setAttribute("AppDT", app.getAppointment_Date());

		// ss.getAttribute(name)
		int ID = (int) ss.getAttribute("AppID");
		String PtName = (String) ss.getAttribute("PatName");
		Date Apdt = (Date) ss.getAttribute("AppDT");

		app.setAppointmentID(ID);
		app.setPatient_Name(PtName);
		app.setAppointment_Date(Apdt);

		System.out.println("given Pt name = " + PtName);

		boolean checkdt = hs.CheckDetails(app, apDB);
		// mvc.setViewName("Cancel Appointment");
		if (checkdt) {

			app.setAppointmentID(ID);
			app.setPatient_Name(PtName);
			app.setAppointment_Date(Apdt);

			hs.deletedata(app, apDB);
			
			System.out.println("ID from if condition of  controller = "+app.getPatient_Name());
			
			mvc.setViewName("Continue To Cancellation"); // it's not redirecting
		} 
		else {
			mvc.setViewName("ReEnterAppointmentDetails"); // it's working
		}
		return mvc;

	}

	// for deleting data

	@RequestMapping("/continue")
	public ModelAndView APPCancel(@ModelAttribute("appdata") Appointment app, Appointment apDB, HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("appdata", new Appointment());
		
		boolean delete = hs.deletedata(app, apDB);
		
		if(delete) {
			
			mvc.setViewName("Cancel Success"); // it's not working
		}
		else {
			mvc.setViewName("ReEnterAppointmentDetails"); // it's working 
		}
		return mvc;
	
	
	}
	
	
	
	
	
	
	// for  postpone appointment (redirecting to details page)
	
	@RequestMapping("/postpone")
	public ModelAndView AppointmentPostpone(@ModelAttribute("appdata") Appointment app, HttpSession ss) {

		ss.setAttribute("AppID", app.getAppointmentID());
		ss.setAttribute("PatName", app.getPatient_Name());
		ss.setAttribute("AppDT", app.getAppointment_Date());

		int ID = (int) ss.getAttribute("AppID");
		String PtName = (String) ss.getAttribute("PatName");
		Date Apdt = (Date) ss.getAttribute("AppDT");

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("appdata", new Appointment());
		mvc.setViewName("PostponetDetailsPage");

		return mvc;

	}
	
	
	// for redirecting to service page to check details of appointment
	
	@RequestMapping("/postdetails")
	public ModelAndView AppointmentPostponeCheck(@ModelAttribute("appdata") Appointment app, Appointment apDB,
			HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		// mvc.addObject("appdata", new Appointment());

		ss.setAttribute("AppID", app.getAppointmentID());
		ss.setAttribute("PatName", app.getPatient_Name());
		ss.setAttribute("AppDT", app.getAppointment_Date());

		// ss.getAttribute(name)
		int ID = (int) ss.getAttribute("AppID");
		String PtName = (String) ss.getAttribute("PatName");
		Date Apdt = (Date) ss.getAttribute("AppDT");

		app.setAppointmentID(ID);
		app.setPatient_Name(PtName);
		app.setAppointment_Date(Apdt);

		System.out.println("given Pt name for postpone of controller(postpone) = " + PtName);

		boolean checkdt = hs.CheckPostDetails(app, apDB);
		// mvc.setViewName("Cancel Appointment");
		if (checkdt) {

			app.setAppointmentID(ID);
			app.setPatient_Name(PtName);
			app.setAppointment_Date(Apdt);
			
			hs.CheckDate(app, apDB,ss);
			
			

		//	hs.deletedata(app, apDB);
			
			System.out.println("ID from if condition of  controller (Postpone) = "+app.getPatient_Name());
			
			mvc.setViewName("Continue To Postpone"); // it's not redirecting
		} 
		else {
			mvc.setViewName("ReEnterAppointmentDetails"); // it's working
		}
		return mvc;

	}
	
	
	// enter date for postpone
	
	@RequestMapping("/dateenter")
	public ModelAndView Date(@ModelAttribute("appdata") Appointment app, Appointment apDB, HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		mvc.addObject("appdata", new Appointment());
		mvc.setViewName("Date To Postpone");
		
		
		ss.setAttribute("AppDT", app.getAppointment_Date());
// ss.getAttribute(name)
		
		Date Apdt = (Date) ss.getAttribute("AppDT");

		
		app.setAppointment_Date(Apdt);

		
		
		return mvc;

	}
	
	
	
	// check the date is valid or not
	
	@RequestMapping("/checkdate")
	public ModelAndView AppointmentPostdateCheck(@ModelAttribute("appdata") Appointment app, Appointment apDB,
			HttpSession ss) {

		ModelAndView mvc = new ModelAndView();
		 mvc.addObject("appdata", new Appointment());

		ss.setAttribute("AppID", app.getAppointmentID());
		ss.setAttribute("PatName", app.getPatient_Name());
		ss.setAttribute("AppDT", app.getAppointment_Date());

		// ss.getAttribute(name)
		int ID = (int) ss.getAttribute("AppID");
		String PtName = (String) ss.getAttribute("PatName");
		Date Apdt = (Date) ss.getAttribute("AppDT");

		app.setAppointmentID(ID);
		app.setPatient_Name(PtName);
		app.setAppointment_Date(Apdt);

		System.out.println("given Date for postpone of controller(postpone) = " + Apdt);

		boolean checkdt = hs.CheckDate (app, apDB, ss);
		// mvc.setViewName("Cancel Appointment");
		if (checkdt) {
              
			app.setAppointmentID(ID);
			app.setPatient_Name(PtName);
			 app.setAppointment_Date(Apdt);
			app.getAppointment_Date();
			app.getPatient_Name();
			app.getAppointmentID();
			 
			 mvc.setViewName("Postpone Success"); // it's not redirecting
		} 
		
		else {
			mvc.setViewName("Re-Enter Date for Postpone"); // it's working
		}
		return mvc;

	}
	
	/*
	 * @RequestMapping("/confirm") public String
	 * saveAccountdepo(@ModelAttribute("appdata") Appointment app) { //return null;
	 * 
	 * return hs.dosavedate(app);
	 * 
	 * }
	 */

		
}
