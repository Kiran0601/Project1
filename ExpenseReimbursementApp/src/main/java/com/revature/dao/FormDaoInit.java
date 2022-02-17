package com.revature.dao;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Form;

public interface FormDaoInit {
	Form viewPending();
	Form viewResolved();
	Form viewAllPending(String name);
	Form viewAllResolved(String name);
	List<Form> viewUserPending() throws SQLException;
	List<Form> viewUserResolved();
	List<Form> viewAllPending();
	List<Form> viewAllResolved();
	boolean createForm(Form f) throws SQLException;
	Form getForm(int id);
	
	
	

}
