package Register;

import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String n = req.getParameter("fname");
		String e = req.getParameter("lname");
		String m = req.getParameter("fathername");
		String p = req.getParameter("email");
		String c = req.getParameter("pw");
		String d = req.getParameter("mob");
		String f = req.getParameter("userCountry");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "vinod");

			PreparedStatement pstmt = con.prepareStatement("insert into register values(?,?,?,?,?)");

			pstmt.setString(1, "fname");
			pstmt.setString(2, "lname");
			pstmt.setString(3, "fathername");
			pstmt.setString(4, "email");
			pstmt.setString(5, "pw");
			pstmt.setString(6, "mob");
			pstmt.setString(7, "userCountry");
			

			int count = pstmt.executeUpdate();

			if (count > 0) {

				System.out.println("Your Registered Successfully");

			}

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		}

	}

}