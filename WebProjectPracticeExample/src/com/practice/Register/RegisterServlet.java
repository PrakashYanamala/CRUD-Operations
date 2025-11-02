package com.practice.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practic.Utils.RegLogUtils;
import com.practice.Constants.RegLogConstants;

public class RegisterServlet extends HttpServlet{
	RegLogUtils rlu = new RegLogUtils();

	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			Connection con = rlu.createconnection();
			
			PreparedStatement ps = con.prepareStatement(RegLogConstants.STUDENTDATA_INSERT);
			
			ps.setString(1, req.getParameter("StudentName"));
			ps.setString(2, req.getParameter("Email"));
			ps.setString(3, req.getParameter("password"));
			ps.setString(4, req.getParameter("MobileNum"));
			ps.setString(5, req.getParameter("DOB"));
			
			ps.execute();
			
			
			pw.print("Successfully Registered. Please Login here");
			
			//Thread.sleep(3000);
			
			RequestDispatcher rd = req.getRequestDispatcher("login");
			rd.include(req, resp);
			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
