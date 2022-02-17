package com.revature.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.revature.model.*;
import com.revature.services.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.Integer.parseInt;
//@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*setAccessControlHeaders(response);
		String json = request.getReader().readLine(); 

		ObjectMapper om = new ObjectMapper();
		try {
		User user = om.readValue(json, User.class);*/
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String submit=request.getParameter("submit");

		UserServices userService = new UserServices();
		User temp = userService.authenticateUser(user);
		PrintWriter out = response.getWriter();

		if (temp == null) {
			out.print("user doesn't match");
		} 
		else
		{
			out.print(om.writeValueAsString(temp));
		}
		
    
    private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
	}

	

}
