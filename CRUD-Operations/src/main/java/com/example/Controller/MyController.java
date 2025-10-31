package com.example.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.Student;
import com.example.Repository.StudentRepository;
import com.example.Service.StudentService;


@RestController
public class MyController {

	
	@Autowired
	StudentService ss;
	
	@Autowired
	StudentRepository sr;
	
	@RequestMapping("/")
	public ModelAndView goToHomePage() {
		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("WelcomePage");//this is the jsp file name
		return mvc;
	}
	
	/*
	 * @RequestMapping("/logreg") public ModelAndView goToLoginRegister() {
	 * ModelAndView mvc = new ModelAndView(); mvc.addObject("studentData", new
	 * Student()); mvc.setViewName("LoginRegister");//this is the jsp file name
	 * return mvc; }
	 */
	
	
	@RequestMapping("/register")
	public ModelAndView Register() {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("studentsData", new Student());
		mvc.setViewName("RegisterPage");//this is the jsp file name
		return mvc;
	}
	
	@RequestMapping("/registerdd")
	public ModelAndView doRegister(@ModelAttribute("studentsData") Student stu) {
		ModelAndView mvc = new ModelAndView();
		System.out.println(stu.toString());
		ss.doRegister(stu);
		mvc.setViewName("GotoLogin");//this is the jsp file name
		return mvc;
	}
	
	@RequestMapping("/login")
	public ModelAndView Login() {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("studentsData", new Student());
		mvc.setViewName("LoginPage");//this is the jsp file name
		return mvc;
	}
	
	@RequestMapping("/logindd")
	public ModelAndView doLogin(@ModelAttribute("studentsData") Student stu, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
	  // System.out.println(stu.toString());
	   
	   hs.setAttribute("mail", stu.getStMail());
		hs.setAttribute("pass", stu.getPassword());

		String Mail =  (String) hs.getAttribute("mail");
		String Pass =  (String) hs.getAttribute("pass");

		stu.setStMail(Mail);
		stu.setPassword(Pass);
		
		boolean userExists = ss.doLogin(stu);
		if(userExists) {
			stu.setStMail(Mail);
			stu.setPassword(Pass);
			
			mvc.setViewName("SuccessForLogin");
		}
		else {
			mvc.setViewName("ErrorForLogin");
		}
		
		
		return mvc;
	}
	
	// Fetching the student  details
	@RequestMapping("/usersdata")
	public ModelAndView fetchUsersData(Student stu, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		
		String Mail =  (String) hs.getAttribute("mail");
		String Pass =  (String) hs.getAttribute("pass");

		stu.setStMail(Mail);
		stu.setPassword(Pass);
		
		
		Student students = ss.fetchUsersData(stu);
		if (students!=null) {
			List<Student> studentList = new ArrayList<>();
	        studentList.add(students);

	        mvc.addObject("studentsData", studentList); // JSTL can iterate this
	        mvc.setViewName("Users");
		}
			else {
			System.out.println("No matching user found.");
		} 

		return mvc;
	}
	
	// Update a record 
	@RequestMapping("/update")
	public ModelAndView Update(@ModelAttribute("studentsData") Student stu, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("studentsData", new Student());
		mvc.setViewName("UpdatePage");//this is the jsp file name
		return mvc;
	}
	
	  // logic code for update 
	@RequestMapping("/updatedd")
	public ModelAndView Updatedd(@ModelAttribute("studentsData") Student stu, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("studentsData", new Student());
		
		hs.setAttribute("mail", stu.getStMail());
		hs.setAttribute("pass", stu.getPassword());

		String Mail =  (String) hs.getAttribute("mail");
		String Pass =  (String) hs.getAttribute("pass");

		stu.setStMail(Mail);
		stu.setPassword(Pass);
		
		boolean userExists = ss.doupdate(stu);
		if(userExists) {
			stu.setStMail(Mail);
			stu.setPassword(Pass);
			
			mvc.setViewName("SuccessPageForUpdate");
			hs.setAttribute("pass", stu.getPassword());
			// ss.getAttribute(name)
					
				  String newpass = (String) hs.getAttribute("pass");
				
					stu.setPassword(newpass);
		}
		else {
			mvc.setViewName("ErrorPageForUpdate");
		}
	
		return mvc;
		
		
	}
	  // save the update new password
	@RequestMapping("/passup")
	public ModelAndView updatepassword(@ModelAttribute("studentsData") Student stu, Student stDB, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
		
		 // Get email from session or directly from form
	    String mail = (String) hs.getAttribute("mail");
	    if (mail != null) {
	        stu.setStMail(mail);
	    }

	    // Get new password from form
	    String newPassword = stu.getPassword();

	    if (newPassword == null || newPassword.trim().isEmpty()) {
	        mvc.setViewName("Re-Enter Password");
	        mvc.addObject("message", "Password cannot be empty!");
	        return mvc;
	    }

	    // Call service to update password
	    boolean isUpdated = ss.Checkpass(stu, null, hs);

	    if (isUpdated) {
	        mvc.setViewName("Password Updated"); // JSP page for update page
	       
	    } else {
	        mvc.setViewName("Re-Enter Password"); // JSP for new password 
	       
	    }

	    return mvc;
	}
	
	
	
	
	
	
	// delete record 
	@RequestMapping("/delete")
	public ModelAndView Delete() {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("studentsData", new Student());
		mvc.setViewName("DeletePage");//this is the jsp file name
		return mvc;
	}
	
	
	// 
	@RequestMapping("/deletedd")
	public ModelAndView DeleteRecord(@ModelAttribute("studentsData") Student stu, HttpSession hs) {
		ModelAndView mvc = new ModelAndView();
	  // System.out.println(stu.toString());
	   
	   hs.setAttribute("mail", stu.getStMail());
		hs.setAttribute("pass", stu.getPassword());

		String Mail =  (String) hs.getAttribute("mail");
		String Pass =  (String) hs.getAttribute("pass");

		stu.setStMail(Mail);
		stu.setPassword(Pass);
		
		boolean isdelete = ss.dodelete(stu);
		if(isdelete) {
			stu.setStMail(Mail);
			stu.setPassword(Pass);
			
			mvc.setViewName("Successpage for delete");
		}
		else {
			mvc.setViewName("Errorpage for delete");
		}
		
		
		return mvc;
	}
	
	
	
	@RequestMapping("/confirm")
	public ModelAndView Deletesuccess() {
		ModelAndView mvc = new ModelAndView();
		//mvc.addObject("studentsData", new Student());
		mvc.setViewName("Delete Success");//this is the jsp file name
		return mvc;
	}

}
