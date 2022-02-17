package com.revature.services;

import java.util.List;
import com.revature.dao.*;
import com.revature.model.*;

public class FormServices {
	
	private FormDao formdao;
	
	public FormServices() {
		this.formdao = new FormDao();
	}
	
	public boolean formInsert(Form f) {
		formdao.insertIntoTable(f);
		return true;
	}
	
	public List<Form> getEmpForm(Integer id) {
		return formdao.getFormByEmpId(id);
	}
	public List<Form> getEmpFormResolved(int emp_id) {
		return formdao.getFormByEmpIdandResolved(emp_id);
	}
	public List<Form> getManagerForms() {
		return formdao.getAllForms();
	}

	public Form getForm(int id) { return formdao.getFormById(id); }
	
	public void updateForm(Form form) {
		Form tempForm = (Form) formdao.getFormByEmpId(Integer.valueOf(form.getId()));
		formdao.updateTable(tempForm);}
	

}