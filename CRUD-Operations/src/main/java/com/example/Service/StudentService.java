package com.example.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.Model.Student;

public interface StudentService {

	public void doRegister(Student st);

	public boolean doLogin(Student stu);

	public Student fetchUsersData(Student st);

	public boolean doupdate(Student stu);

	public boolean Checkpass( Student stu, Student stDB, HttpSession hs);

	public boolean dodelete(Student stu);

	//public Student deletingRecord(Student stu);

	//List<Student> fetchUsersData(Student st);
}
