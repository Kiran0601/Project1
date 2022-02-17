package com.revature.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.revature.dao.FormDao;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoInit;
import com.revature.model.*;
import com.revature.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(name="/Form1Servlet" , urlPatterns= {"/Form1Servlet"})
public class Form1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Form1Servlet() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("Updated Sucessfully");
		
	
	}

     private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
	}
	
}
	

