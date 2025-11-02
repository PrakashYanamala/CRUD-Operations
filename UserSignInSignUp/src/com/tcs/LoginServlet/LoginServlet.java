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

public class LoginServlet extends HttpServlet {

	RegLogUtils rlu = new RegLogUtils();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");

		try {
			Connection con = rlu.createConnection();

			PreparedStatement ps = con.prepareStatement(RegLogConstants.USERTABLE_SELECT);

			/*
			 * ps.setString(1, req.getParameter("email")); ps.setString(2,
			 * req.getParameter("password"));
			 */

			HttpSession hs = req.getSession();
			
			String mail = (String) hs.getAttribute("maill");
			String password = (String) hs.getAttribute("pass");
			
			ps.setString(1, mail);
			ps.setString(2, password);
			/*
			 * System.out.println("mail = "+mail);
			 * System.out.println("password = "+password);
			 */
			

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				pw.print("Successfully login" + "<br><br>");
				pw.print("UserName = " + rs.getString(1) + "<br>");
				pw.print("Email = " + rs.getString(2) + "<br>");
				pw.print("MobNum = " + rs.getString(4) + "<br>");
				pw.print("DOB = " + rs.getString(5) + "<br>");
			} else {
				pw.print("Incorrect Email/Password, please enter correct details" + "<br>");
				RequestDispatcher rd = req.getRequestDispatcher("login");
				rd.include(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
