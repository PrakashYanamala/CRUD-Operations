package com.tcs.LoginServlet;

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
import javax.servlet.http.HttpSession;

import com.tcs.Costants.RegLogConstants;
import com.tcs.Utils.RegLogUtils;

public class CheckDetails extends HttpServlet{

RegLogUtils rlu = new RegLogUtils();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		
		try {
			Connection con = rlu.createConnection();
			
			PreparedStatement ps = con.prepareStatement(RegLogConstants.USERTABLE_SELECT);
			
			ps.setString(1, req.getParameter("Email"));
			ps.setString(2, req.getParameter("Password"));
			
			/*
			 * System.out.println("Name = "+req.getParameter("Name"));
			 * System.out.println("Email = "+req.getParameter("Email"));
			 */
			
			HttpSession hs = req.getSession();
			hs.setAttribute("maill", req.getParameter("Email"));
			hs.setAttribute("pass", req.getParameter("Password"));
			//hs.setAttribute("pass", req.getParameter("Password"));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("loginpage");
				rd.include(req, resp);
				
			}
			else {
				pw.print("Incorrect Email/Password, please enter correct details"+"<br>");
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
