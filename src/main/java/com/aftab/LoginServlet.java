package com.aftab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Aftab341@#007");
			String name = request.getParameter("textName");
			String password = request.getParameter("textpwd");
			
			PreparedStatement pst = con.prepareStatement("SELET * FROM login WHERE username=? AND password=?");
			pst.setString(1, name);
			pst.setString(2, password);
			
		   ResultSet rs= pst.executeQuery();
		   
		   if(rs.next()) 
		   {
			   response.sendRedirect("success.jsp");
		   }
		   else 
		   {
			   response.sendRedirect("error.jsp");
		   }
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
		
	}

}
