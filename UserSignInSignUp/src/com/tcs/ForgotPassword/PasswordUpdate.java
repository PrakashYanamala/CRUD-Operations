package com.tcs.ForgotPassword;

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

public class PasswordUpdate extends HttpServlet {

	RegLogUtils rlu = new RegLogUtils();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");

		try {
			Connection con = rlu.createConnection();

			PreparedStatement ps = con.prepareStatement(RegLogConstants.USERTABLE_SELECT1);

			// ps.setString(1, req.getParameter("Password"));

			/*
			 * System.out.println("Name = "+req.getParameter("Name"));
			 * System.out.println("Email = "+req.getParameter("Email"));
			 */
			HttpSession hs = req.getSession();
			String uname = (String) hs.getAttribute("name");
			String umail = (String) hs.getAttribute("email");

			ps.setString(1, uname);
			ps.setString(2, umail);

			System.out.println("name = " + uname);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String s1 = req.getParameter("Password");
				String oldpass = rs.getString("PASSWORD");

				/*
				 * System.out.println("old pass = "+paw); System.out.println("new pass = "+s1);
				 */

				if (!s1.equals("null") && !s1.equals(oldpass)) {

					String NewPassword = s1;

					PreparedStatement ps1 = con.prepareStatement(RegLogConstants.USERTABLE_UPDATE);

					ps1.setString(1, NewPassword);

					ps1.setString(2, uname);
					ps1.setString(3, umail);

					ps1.executeUpdate(); // Execute the update query

					pw.print("<h5>" + "The Password has successfully updated" + "<h5>" + "<br>");

					RequestDispatcher rd = req.getRequestDispatcher("login");
					rd.include(req, resp);

				}

				else {

					pw.print("Invalid password, or please enter a strong password");
					RequestDispatcher rd = req.getRequestDispatcher("enternew");
					rd.include(req, resp);

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
