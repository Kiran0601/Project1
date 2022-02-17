package com.revature.servlet;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoInit;
import com.revature.model.User;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Servlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoInit e=new UserDao();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String submit=request.getParameter("submit");
		User temp = e.getUserByUsername(username);
		if(temp!=null)
		{
			if(temp.getPassword().equals(password))
			{
			response.sendRedirect("emp.html");}
		}
		
		else {
			System.out.print(temp.getPassword());
			response.sendRedirect("index.jsp");
		}
	}

}
