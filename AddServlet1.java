 package com.chetu.skill;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 //for add servlet
//@WebServlet("/AddServlet")
public class AddServlet1 extends HttpServlet {
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();

		Integer empId = Integer.parseInt(req.getParameter("empId"));
		String empName = req.getParameter("empName");
		Float empSal = Float.parseFloat(req.getParameter("empSal"));
			
		String driverClass = "com.mysql.jdbc.Driver";
		String sqlUrl = "jdbc:mysql://localhost:3306/saquibdb";
		String sqlUsername = "root";
		String sqlPassword = "Saquib@12345";
		String insertStatement = "insert into chetu values(?,?,?)";
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
			PreparedStatement pst = con.prepareStatement(insertStatement);
			pst.setInt(1,empId);
			pst.setString(2, empName);
			pst.setFloat(3, empSal);
			int x = pst.executeUpdate();
			 if(x !=0)
			out.println("<h1>Data Updated</h1>");
		} catch (ClassNotFoundException e) {
			out.println("<h1>Your Driver class is not Loaded</h1>");
		} catch (SQLException e) {
			out.println("<h1>Your class is not Connecting with SQL Server</h1>");
		}
	}	
	}


