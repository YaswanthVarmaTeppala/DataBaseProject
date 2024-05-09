package com.servlet.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/CreateProject")
public class CreateProject extends HttpServlet{
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String ProjectCode = req.getParameter("projectCode");
			String ProjectTitle = req.getParameter("projectTitle");
			String ProjectDescription = req.getParameter("projectDescription");
			String CustomerId = req.getParameter("customerId");
			String Location = req.getParameter("location");
			String ProjectValue = req.getParameter("projectValue");
			String Currency = req.getParameter("currency");
			String StartDate = req.getParameter("startDate");
			String EndDate = req.getParameter("endDate");
			String ProjectManager = req.getParameter("projectManager");
			String TotalDeliveryMilestones = req.getParameter("totalDeliveryMilestones");
			String TotalInvoiceMilestones = req.getParameter("totalInvoiceMilestones");
			String CurrentStatus = req.getParameter("currentStatus");
			String DeviationsinTimeLimit = req.getParameter("deviationsInTimeLimit");
			String DeviationsinEfforts = req.getParameter("deviationsInEfforts");
			String TotalManDays = req.getParameter("totalManDays");
			String AllottedManDays = req.getParameter("allottedManDays");
			String TotalConsumed = req.getParameter("totalConsumed");
			String CustomerName = req.getParameter("customerName");
			
			String url = "jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
			
			String insert=
				"insert into sampleproject"
				+ "(ProjectCode,ProjectTitle,ProjectDescription,CustomerId,Location,ProjectValue,"
				+ "Currency,StartDate,EndDate,ProjectManager,TotalDeliveryMilestones,TotalInvoiceMilestones,"
				+ "CurrentStatus,DeviationsinTimeLimit,DeviationsinEfforts,TotalManDays,AllottedManDays,TotalConsumed,CustomerName)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection connection =	DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert);
			
			ps.setString(1, ProjectCode);
			ps.setString(2, ProjectTitle);
			ps.setString(3, ProjectDescription);
			ps.setString(4, CustomerId);
			ps.setString(5, Location);
			ps.setString(6, ProjectValue);
			ps.setString(7, Currency);
			ps.setString(8, StartDate);
			ps.setString(9, EndDate);
			ps.setString(10, ProjectManager);
			ps.setString(11, TotalDeliveryMilestones);
			ps.setString(12, TotalInvoiceMilestones);
			ps.setString(13, CurrentStatus);
			ps.setString(14, DeviationsinTimeLimit);
			ps.setString(15, DeviationsinEfforts);
			ps.setString(16, TotalManDays);
			ps.setString(17, AllottedManDays);
			ps.setString(18, TotalConsumed);
			ps.setString(19, CustomerName);
			int result = ps.executeUpdate();
			//PrintWriter writer = resp.getWriter();
			if(result !=0 ) {
				resp.getWriter().println("Data Stored Sucess");
			}
			else {
				resp.getWriter().println(" failed Data");
			}
			} catch (ClassNotFoundException|SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.getWriter().println("Error: "+e.getMessage());
			} 	
		}
}
