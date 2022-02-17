package com.revature.dao;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.User;

public interface EmployeeDaoInit {
	User getEmployee(String username) throws SQLException;
	User viewEmployee(int id);
	User viewEmployee(String name);
	User getEmployee(String username,String password) throws SQLException;
	List<User> viewEmployees();
	boolean createEmployee(User u) throws SQLException;
	

}
