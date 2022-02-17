package com.revature.services;

import java.sql.SQLException;

import com.revature.dao.FormDaoImpl;
import com.revature.dao.FormDaoInit;
import com.revature.model.Form;

public class ManagerServiceImpl {
	public static void reviewForm() {
		System.out.println("Reimbursements to be reviewed");
		
	}

	public static void viewAllPendingForms() throws SQLException {
		System.out.println("Pending Forms ");
		FormDaoInit formdao=new FormDaoImpl();
		for(Form f: formdao.viewUserPending()) {
			if("Pending".equals(f.status)) {
				System.out.println(f.type_of_expense+  " " +  f.amount+ " "+ f.status + " "+ f.getSub_date());
			}
		}
		
	}

	public static void viewResolvedForms() throws SQLException {
		System.out.println("Resolved Forms ");
		FormDaoInit formdao=new FormDaoImpl();
		for(Form f: formdao.viewUserPending()) {
			if("Approved".equals(f.status)) {
				System.out.println(f.type_of_expense+  " " +  f.amount+ " "+ f.status + " "+ f.getSub_date());
			}
		}
		
	}

	public static void viewAllEmployees() {
		System.out.println("All Employee names");
		
	}
	
	

}
