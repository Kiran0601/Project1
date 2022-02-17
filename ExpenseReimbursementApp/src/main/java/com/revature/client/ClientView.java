package com.revature.client;
import com.revature.model.*;
import com.revature.services.*;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.*;

public class ClientView {

	public static User emp;
	public static User type;
	public static String etype;
	public static boolean logedin;
	public static boolean stop= false;
	
	public static void menu() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		System.out.println("1.Employee Login");
		System.out.println("2.Manager Login");
		System.out.println("3.Sign up");;
		System.out.println("4.Exit");
		String op=sc.nextLine();
		switch(op)
		{
		    case "1":{
			logIn();
			break;
		    }
		    case "2":{
			logIn();
			break;}
		    case "3":{
			createuser();
			break;}
		    
		    case "4":
		    {
			System.out.println("Exiting");
			sc.close();
			System.exit(0);
			break;
		    }
		    default:{
			ClientView.stop=true;
			System.err.println("Choose correct option");
			}
		    menu();
		 }
		
	}
	public static void logIn() throws SQLException
	{
		String uname; String password;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username");
		uname=sc.nextLine();
		System.out.println("Enter Password");
		password=sc.nextLine();
		EmployeeDaoInit employee=new EmployeeDaoImpl();
		if(employee.getEmployee(uname, password)!=null)
		{
			emp=employee.getEmployee(uname);
			System.out.println(emp.fname + "Welcome to Expense Reimbursement App");
			if("Manager".equals(emp.role)) {
				managerTask();
			}
			else
			{
				employeeTask();
			}
		}
		else {
			System.err.println("Check your login credentials!!! ");
			logIn();
		}
		sc.close();
		
	}
	public static void employeeTask() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the option you need to perform");
		System.out.println("1.Submit new Form");
		System.out.println("2.View Pending Forms");
		System.out.println("3.View Resolved Forms");
		System.out.println("4.Home");
		System.out.println("5.Exit");
		String opt=sc.next();
		try {
			switch(opt)
			{
			
			case "1":{
				EmployeeServiceImpl.submitForm();
				break;
			}
			case "2":{
				EmployeeServiceImpl.viewPendingForm();
				break;
			}
			case "3":{
				EmployeeServiceImpl.viewResolvedForm();
				break;}
			case "4":
			{
				logIn();
				break;
			}
			case "5":
			{
				System.out.println("Exit");
				sc.close();
				System.exit(0);
				break;
			}
			default:
			{
				ClientView.stop=true;
				System.out.println("Option is not valid ");
				break;
			}}
			employeeTask();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public static void managerTask() throws SQLException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose the option you need to perform");
		System.out.println("1.Approve Forms");
		System.out.println("2.View All Pending Forms");
		System.out.println("3.View All Resolved Forms");
		System.out.println("4.View Employees Details");
		System.out.println("5.Home");
		System.out.println("6.Exit");
		
		String opt=sc.next();
		switch(opt){
		case "1":{
			ManagerServiceImpl.reviewForm();
			break;
		}
		case "2":{
			ManagerServiceImpl.viewAllPendingForms();;
			break;
		}
		case "3":{
			ManagerServiceImpl.viewResolvedForms();
			break;}
		case "4":
		{
			ManagerServiceImpl.viewAllEmployees();
			break;
	    }
		case "5":
		{
			logIn();
			break;
		}
		case "6":
		{
			System.out.println("Exit");
			sc.close();
			System.exit(0);
			break;
		}
		default:{
			ClientView.stop=true;
			System.out.println("Option is not valid ");
			break;}
		}
		managerTask();
		
	}
	private static void createuser() throws SQLException {
		System.out.println("Sign-up");
		EmployeeServiceImpl.addEmployee();
	}
}
