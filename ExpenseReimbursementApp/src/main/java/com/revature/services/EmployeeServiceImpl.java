package com.revature.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.client.ClientView;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.EmployeeDaoInit;
import com.revature.dao.FormDaoImpl;
import com.revature.dao.FormDaoInit;
import com.revature.model.*;

public class EmployeeServiceImpl {
	static Scanner sc=new Scanner(System.in);
	static int id;
	static String type_of_expense;
	static double amount;
	static int emp_id;
	static String username;
	static String password;
	static String fname;
	static String lname;
	static String email;
	static String role;
	static String status="Pending";
	static String emp_type_of_expense="Employee";
	public static ArrayList<Form> f=new ArrayList<Form>();
	public static ArrayList<User> u=new ArrayList<User>();
	public static void submitForm() throws SQLException {
		System.out.println("Submit form details");
		System.out.println("What is the type_of_expense?");
		type_of_expense=sc.next();
		System.out.println("Enter amount");
		amount=sc.nextDouble();
		FormDaoInit f=new FormDaoImpl();
		emp_id=ClientView.emp.id;
		type_of_expense="Reimbursement for "+ type_of_expense;
		System.out.println(emp_id);
		System.out.println(type_of_expense);
		f.createForm(new Form(id,emp_id,type_of_expense,amount,status));
		Form.add(new Form(id,emp_id,type_of_expense,amount,status));
		System.out.println("Form submitted Sucessfully");
		}

	public static  void viewPendingForm() throws SQLException {
		System.out.println("Pending Forms ");
		FormDaoInit formdao=new FormDaoImpl();
		for(Form f: formdao.viewUserPending()) {
			if("Pending".equals(f.status)) {
				System.out.println(f.type_of_expense+  " " +  f.amount+ " "+ f.status + " "+ f.getSub_date());
			}
		}
		
	}
	public static void viewResolvedForm() throws SQLException {
		System.out.println("Resolved Forms ");
		FormDaoInit formdao=new FormDaoImpl();
		for(Form f: formdao.viewUserPending()) {
			if("Approved".equals(f.status)) {
				System.out.println(f.type_of_expense+  " " +  f.amount+ " "+ f.status + " "+ f.getSub_date());
			}
		}
		
	}
	public static  void addEmployee() throws SQLException {
		System.out.println("Add Employee Details");
		System.out.println("Enter First name");
		fname=sc.next();
		System.out.println("Enter Last name");
		lname=sc.next();
		System.out.println("Enter Email");
		email=sc.next();
		System.out.println("Enter Username");
		username=sc.next();
		System.out.println("Enter password");
		password=sc.next();
		System.out.println("Employee details added sucessfully");
		EmployeeDaoInit e=new EmployeeDaoImpl();
		e.createEmployee(new User(id,fname,lname,email,username,password,role));
	}
	

}
