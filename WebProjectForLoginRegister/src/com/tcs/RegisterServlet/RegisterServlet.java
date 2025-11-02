package com.tcs.RegisterServlet;

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

import com.tcs.Costants.RegLogConstants;
import com.tcs.Utils.RegLogUtils;

import sun.font.CreatedFontTracker;

public class RegisterServlet extends HttpServlet{

	RegLogUtils rlu = new RegLogUtils();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		try {
			Connection con = rlu.createConnection();
			PreparedStatement ps = con.prepareStatement(RegLogConstants.STUDENTDATA_INSERT);
			
			ps.setString(1, req.getParameter("UserName"));
			ps.setString(2, req.getParameter("Email"));
			ps.setString(3, req.getParameter("Password"));
			ps.setString(4, req.getParameter("MobNum"));
			ps.setString(5, req.getParameter("DOB"));
			ps.execute();
			
			
			pw.print("Successfully registered, please login");
			
			RequestDispatcher rd = req.getRequestDispatcher("loginPage");
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
