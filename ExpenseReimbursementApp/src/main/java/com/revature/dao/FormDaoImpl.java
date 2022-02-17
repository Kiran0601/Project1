package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.client.ClientView;
import com.revature.dbcon.ConnectionImpl;
import com.revature.model.Form;

public class FormDaoImpl implements FormDaoInit{
	ConnectionImpl ci=new ConnectionImpl();
	public Form viewPending() {
		// TODO Auto-generated method stub
		return null;
	}

	public Form viewResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	public Form viewAllPending(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Form viewAllResolved(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Form> viewUserPending() throws SQLException {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		List<Form> f=new ArrayList<Form>();
		try {
			con=ci.getCon();
			st=con.createStatement();
			
			rs=st.executeQuery("select * form forms where emp_id= " + ClientView.emp.id +";");
					while(rs.next()) {
						f.add(createFormFromRS(rs));
					}
			}
        catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			rs.close();
			st.close();
			con.close();
		}
		return f;
		
		
		
	}

	public List<Form> viewUserResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Form> viewAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Form> viewAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean createForm(Form f) throws SQLException {
		Connection con=null;
		PreparedStatement pst=null;
		String s="insert into forms values(DEFAULT,?,?,?,DEFAULT,?);";
		try {
			con=ci.getCon();
			pst=con.prepareStatement(s);
			pst.setInt(1,f.emp_id);
			pst.setString(2,f.type_of_expense);
			pst.setDouble(3,f.amount);
			pst.setString(4,f.status);
			pst.execute();
			}
		catch (SQLException e) {
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

	public Form getForm(int id) {
		Form f=null;
		String s="select * from forms where id=?;";
		try {
			PreparedStatement pst=ci.getCon().prepareStatement(s);
			pst.setLong(1,id);
			if(pst.execute()) {
				ResultSet rs=pst.getResultSet();
				if(rs.next()) {
					f=createFormFromRS(rs);
				}
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return f;
		
	}

	private Form createFormFromRS(ResultSet rs) throws SQLException {
		return new Form(rs.getInt("id"),rs.getInt("emp_id"),rs.getString("type_of_expense"),rs.getDouble("amount"),rs.getString("status"),rs.getString("result"),rs.getString("sub_date"));
	}

}
