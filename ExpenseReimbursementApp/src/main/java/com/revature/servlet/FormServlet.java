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
@WebServlet(name="/FormServlet" , urlPatterns= {"/FormServlet"})
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Edit = "Edit";
  
    public FormServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		PrintWriter out = response.getWriter();
		System.out.println("Reached");
		FormServices formService = new FormServices();
		try {
			Integer id = null;
			Integer emp_id = null;
			if (request.getParameter("id") != null) {
				id = Integer.valueOf(request.getParameter("id"));
				List<Form> forms = formService.getEmpForm(id);
				out.print(forms);
			}
			if (request.getParameter("emp_id") != null) {
				emp_id= Integer.valueOf(request.getParameter("emp_id"));
				Form form = formService.getForm(emp_id);
				out.print(form);
			}
			if (id == null && emp_id == null) {
				out.print("<table border='1' cellpadding='4'width='100%'>");
				out.print("<tr><th>Id</th><th>Employee Id</th><th>Type Of Expense</th><th>Amount</th><th>Status</th>"
						+ "<th>Result</th><th>Submission Date</th><th>");
				List<Form> forms = formService.getManagerForms();
				for(Form form:forms)
				{
					String id1=form.getId();
					out.print("<tr><td>"+form.getId()+"</td><td>"
				     +form.getEmp_id()+"</td><td>"+form.getType_of_expense()
					+"</td><td>" + form.getAmount()+"</td><td>"+ form.getStatus()+"</td><td>"+form.getResult()
					+"</td><td>"+form.getSub_date()+"</td></tr>");/*<td>"
							+ "<a href=\"Form1Servlet\" name=\"Edit\" value="+ form.getId() +">"+Edit+"</a></td></tr>");
					if(Edit==false) {
					request.setAttribute("ExpenseId", form.getEmp_id());
					request.setAttribute("FormId", form.getId());
					request.setAttribute("Type_of_Expense", form.getType_of_expense());
					request.setAttribute("Amount", form.getAmount());
					request.setAttribute("Submission_date", form.getSub_date());
					request.setAttribute("Status", form.getStatus());
					request.setAttribute("ExpenseId", form.getEmp_id());
					RequestDispatcher rd=request.getRequestDispatcher("/Form1Servlet");
					rd.forward(request, response);*/
					
							
				}
				out.print("</table>");
				
				
			    //out.print(forms);
			}
		} catch (NumberFormatException e) {
			out.print("param is not an integer value");
		}
	}
	
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*setAccessControlHeaders(response);
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		Form form = om.readValue(json, Form.class);
		FormServices service = new FormServices();
		service.formInsert(form);
		PrintWriter out = response.getWriter();
		//out.print(form);*/
    
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		FormDao e=new FormDao();
		String type_of_expense=request.getParameter("type_of_expense");
		String amount=request.getParameter("amount");
		String role=request.getParameter("role");
	    String id=request.getParameter("id");
	    String emp_id=request.getParameter("emp_id");
	    String sub_date=request.getParameter("sub_date");
	    Form f=new Form();
	    f.setId(id);
	    f.setEmp_id(emp_id);
	    f.setAmount(amount);
	    f.setSub_date(sub_date);
	    f.setType_of_expense(type_of_expense);
	    
		e.insertIntoTable(f);
		RequestDispatcher d=request.getRequestDispatcher("index.jsp");
		d.forward(request, response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		Form form = om.readValue(json, Form.class);
        FormServices service = new FormServices();
		service.updateForm(form);
		PrintWriter out = response.getWriter();
		out.print(form);
	}


     private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
	}
     private void updateUser(HttpServletRequest request, HttpServletResponse response)
    		    throws  IOException {
    		        int id = Integer.parseInt(request.getParameter("Id"));
    		        int emp_id = Integer.parseInt(request.getParameter("EmployeeId"));
    		        String type_of_expense = request.getParameter("Type Of Expense");
    		        String amount= request.getParameter("Amount");
    		        String status= request.getParameter("Status");
    		        String sub_date= request.getParameter("Submission date");
    		        

    		        Form form = new Form(id,emp_id,type_of_expense,amount,status,sub_date);
    		        FormDao.updateForm(form);
    		        response.sendRedirect("list");
    		    }
	
}
	

