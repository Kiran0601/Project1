package com.revature.dao;

import java.util.List;
import java.sql.*;

import com.revature.dbcon.ConnectionImpl;
import com.revature.model.User;

public class EmployeeDaoImpl implements EmployeeDaoInit {
	ConnectionImpl ci=new ConnectionImpl();

	public User getEmployee(String username) throws SQLException {
		ResultSet rs=null;
		PreparedStatement pst=null;
		User u=null;
		try 
		{
			pst=ci.getCon().prepareStatement("select * form employees where username=?;");
			pst.setString(1, username);
			if(pst.execute())
			{
				rs=pst.getResultSet();
				if(rs.next()) {
					u=createUserFromRS(rs);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*finally
		{
			rs.close();
			pst.close();
		}*/
		return u;
		
	}

	private User createUserFromRS(ResultSet rs) throws SQLException {
		
		return new User
				(
				rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),
				rs.getString("username"),rs.getString("password"), null
				
				);
	}

	public User viewEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User viewEmployee(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getEmployee(String username, String password) throws SQLException {
		ResultSet rs=null;
		PreparedStatement pst=null;
		User u=null;
		try 
		{
			pst=ci.getCon().prepareStatement("select * form employees where username=? and password=?;");
			pst.setString(1, username);
			pst.setString(2, password);
			if(pst.execute())
			{
				rs=pst.getResultSet();
				if(rs.next()) {
					u=createUserFromRS(rs);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			pst.close();
		}
		return u;
	}

	public List<User> viewEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createEmployee(User u) throws SQLException {
		Connection con=null;
		PreparedStatement pst=null;
		String s="insert into employees values(DEFAULT,?,?,?,?,?);";
		try {
			con=ci.getCon();
			pst=con.prepareStatement(s);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getUsername());
			pst.setString(5, u.getPassword());
			pst.execute();
			}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			con.close();
			pst.close();
		}
		return true;
		
	}

}
