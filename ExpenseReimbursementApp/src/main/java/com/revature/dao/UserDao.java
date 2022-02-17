package com.revature.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.model.*;
import com.revature.util.HibernateUtil;

public class UserDao implements UserDaoInit {
	
	private Transaction transaction;
	
	public static Session session=HibernateUtil.getSessionFactory().openSession();

	public UserDao() {
		
			SessionFactory sessionFactory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session=sessionFactory.openSession();
			transaction  = session.getTransaction();
			}
	public String insertIntoTable(User user) {
		transaction.begin();
		session.save(user);
		transaction.commit();
		return null;
	}
	public String updateTable(User user) {
		transaction.begin();
		session.update(user);
		transaction.commit();
		return null;		
	}
	
	public String deleteFromTable(User user) {
		transaction.begin();
		session.delete(user);
		transaction.commit();
		return null;	
	}
	
	public User getUserById(int id) {
		transaction.begin();
		System.out.println("In id");
		User user =	(User) session.get(User.class, id);
		transaction.commit();
		return user;
	}
	public User getUserByUsername(String username) {
		transaction.begin();
		String SQL_QUERY =" from User where username='"+username+"'";
		Query query = session.createQuery(SQL_QUERY);
		User user = (User) query.uniqueResult();
		transaction.commit();
		//session.close();
		return user;            
		
	}

	public User getUserByEmail(String email) {
		transaction.begin();
		System.out.println("email:" + email);
		Query q = session.createQuery("from ersusers where email='"+email+"'");
		User user = (User) q.uniqueResult();
		System.out.println("user:" + user);
		transaction.commit();
		return user;
	}
	public User getUserByRole(boolean role) {
		transaction.begin();
		User user = (User) session.createQuery("from ersusers where role='"+role+"'");
		transaction.commit();
		return user;	
	}

}