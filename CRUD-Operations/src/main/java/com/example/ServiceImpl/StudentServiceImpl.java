package com.example.ServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Student;
import com.example.Repository.StudentRepository;
import com.example.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentRepository sr;
	
	@Override
	public void doRegister(Student st) {
		sr.save(st);
		
	}

	@Override
	public boolean doLogin(Student stu) {
		List<Student> students = sr.findAll();
		
		for(Iterator<Student> itr = students.iterator();itr.hasNext();) {
			Student stDB = itr.next();
			
			if(stu.getStMail()!=null && stu.getPassword()!=null && stDB.getStMail()!=null && stDB.getPassword()!=null) {
				
				 if (stu.getStMail().equalsIgnoreCase(stDB.getStMail())
		                    && stu.getPassword().equals(stDB.getPassword())) {
					return true;
				}
			}
			
		}
		
		return false;
		
	
	}

	//@Override
	public Student fetchUsersData(Student st) {
		List<Student> students = sr.findAll();
		
		System.out.println("Entered Email: " + st.getStMail());
	    System.out.println("Entered Password: " + st.getPassword());
	    
		Optional<Student> optionalStudent = sr.findByStMailAndPassword(st.getStMail(), st.getPassword());
		
		if (optionalStudent.isPresent()) {
	        Student stDB = optionalStudent.get();
	        
	        System.out.println("-----Students Details are---------");
	        System.out.println("Student name = " + stDB.getStName());
	        System.out.println("Student mail = " + stDB.getStMail());
	        System.out.println("Password = " + stDB.getPassword());
	        System.out.println("Student MobNum = " + stDB.getMobileNum());
	        System.out.println("Student DOB = " + stDB.getDob());

		 
		   return stDB;
		}
		 return null; // No match found
	}

	@Override
	public boolean doupdate(Student stu) {
		
    List<Student> students = sr.findAll();
		
		for(Iterator<Student> itr = students.iterator();itr.hasNext();) {
			Student stDB = itr.next();
			
			if(stu.getStMail()!=null && stu.getPassword()!=null && stDB.getStMail()!=null && stDB.getPassword()!=null) {
				
				 if (stu.getStMail().equalsIgnoreCase(stDB.getStMail())
		                    && stu.getPassword().equals(stDB.getPassword())) {
					return true;
				}
			}
			
		}
		
		return false;
		
	
	}

	@Override
	public boolean Checkpass(Student stu, Student stDB, HttpSession hs) {
		
		List<Student> students = sr.findAll();
		
		 for (Student stDB1 : students ) {
			
				 if ( stu.getStMail().equals(stDB1.getStMail()) && !stu.getPassword().equals(stDB1.getPassword())) {
			
					 if (!stu.getPassword().equals(stDB1.getPassword())) {
			              
						 stDB1.setPassword(stu.getPassword());
			                sr.save(stDB1);
			                System.out.println(" Password updated for: " + stDB1.getStMail());
			                return true; // password successfully updated
				 
			 }else {
	                
	                return false; // same password, no update
	            }
	        }
	    }

	   
	    return false;
	}

	@Override
	public boolean dodelete(Student stu) {
		
    List<Student> students = sr.findAll();
		
		for(Iterator<Student> itr = students.iterator();itr.hasNext();) {
			Student stDB = itr.next();
			
			if(stu.getStMail()!=null && stu.getPassword()!=null && stDB.getStMail()!=null && stDB.getPassword()!=null) {
				
				 if (stu.getStMail().equalsIgnoreCase(stDB.getStMail())
		                    && stu.getPassword().equals(stDB.getPassword())) {
					 
					 sr.delete(stDB);
		                
					return true;
				}
			}
			
		}
		
		return false;
		
	}

	
}
