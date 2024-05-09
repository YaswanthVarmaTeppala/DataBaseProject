package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/DisplayRecords")
public class DisplayRecords extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String ProjectCode = req.getParameter("ProjectCode");
		out.print("<h1>Display the records</h1>");
		out.print("<table border='1'><tr><th>ProjectCode</th><th>ProjectTitle</th><th>ProjectDescription</th>"
				+ "<th>CustomerName</th><th>Location</th><th>ProjectValue</th><th>StartDate</th>"
				+ "<th>EndDate</th><th>TotalDeliveryMileStones</th><th>TotalInvoiceMileStones</th><th>CurrentStatus</th>"
				+ "<th>DeviationsinTimeLimit</th><th>DeviationsinEfforts</th><th>TotalManDays</th><th>EllottedManDays</th>"
				+ "<th>TotalConsumed</th><th>Currency</th><th>ProjectManager</th></tr>"); 
		
		String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			Statement st = connection.createStatement();
			ResultSet rs;
			if (ProjectCode != null && !ProjectCode.isEmpty()) {
			    rs = st.executeQuery("select * from sampleproject where projectCode=" + ProjectCode);
			} else {
			    rs = st.executeQuery("select * from sampleproject");
			}
			
			while(rs.next()) {
	
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(4));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(5));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(6));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(7));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(8));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(9));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(10));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(11));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(12));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(13));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(14));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getInt(15));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(16));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(17));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(18));
				out.print("</td>");
				out.print("</tr>");
			}
		}
		catch(Exception p) {
			System.out.println(p);
		}
		out.print("</table>");
	}
	
}
