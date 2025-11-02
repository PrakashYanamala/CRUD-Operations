package com.practice.Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practic.Utils.RegLogUtils;
import com.practice.Constants.RegLogConstants;

public class LoginServlet extends HttpServlet {

	RegLogUtils rlu = new RegLogUtils();
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			
Connection con = rlu.createconnection();
			
			PreparedStatement ps = con.prepareStatement(RegLogConstants.STUDENTDATA_SELECT);
			
			ps.setString(1, req.getParameter("Email"));
			ps.setString(2, req.getParameter("password"));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pw.print("Successfully Logged In"+"<br><br>");
				pw.print("Username = "+rs.getString(1) +"<br>");
				pw.print("Email = "+rs.getString(2) +"<br>");
				pw.print("MobNum = "+rs.getString(4) +"<br>");
				pw.print("DOB = "+rs.getString(5) +"<br>");
				
			}
			else {
				pw.print("Incorrect Email/Password "+"<br><br>");
				RequestDispatcher rd = req.getRequestDispatcher("login");
				rd.include(req, resp);
			}
			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	
}
