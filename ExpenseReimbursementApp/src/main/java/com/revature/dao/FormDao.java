package com.revature.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.model.*;
import com.revature.util.HibernateUtil;

public class FormDao {
		
		private Transaction transaction;
		public static Session session=HibernateUtil.getSessionFactory().openSession();
		public FormDao() {
			SessionFactory sessionFactory =new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session=sessionFactory.openSession();
			transaction  = session.getTransaction();
		}

		public void insertIntoTable(Form form) {
			UserDao.session.beginTransaction();
			UserDao.session.save(form);
			UserDao.session.getTransaction().commit();
		}

		public String updateTable(Form form) {
			UserDao.session.beginTransaction();
			UserDao.session.update(form);
			UserDao.session.getTransaction().commit();
			return null;
		}

		public String deleteFromTable(Form form) {
			UserDao.session.beginTransaction();
			UserDao.session.delete(form);
			UserDao.session.getTransaction().commit(); 
			return null;
		}

		public Form getFormByStatus(Form status) {
			UserDao.session.beginTransaction();		
			Form form = (Form) UserDao.session.createQuery("from ersforms where status='"+status+"'");
			UserDao.session.getTransaction().commit();	
			return form;
		}	
		public Form getFormByType(Form type_of_expense) {
			UserDao.session.beginTransaction();		
			Form form = (Form) UserDao.session.createQuery("from ersform where type='"+type_of_expense+"'");
			UserDao.session.getTransaction().commit();	
			return form;
		}
		public List<Form> getFormByEmpId(Integer id){
			UserDao.session.beginTransaction();
			List<Form> form = (List<Form>)UserDao.session.createQuery("from Form f where f.id = '"+id+"' and f.status='Pending'").list();
			UserDao.session.getTransaction().commit();
			return form;
		}public List<Form> getFormByEmpId1(String id){
			UserDao.session.beginTransaction();
			List<Form> form = (List<Form>)UserDao.session.createQuery("from Form f where f.id = '"+id+"' and f.status='Pending'").list();
			UserDao.session.getTransaction().commit();
			return form;
		}
		
		public List<Form> getFormByEmpIdandResolved(int emp_id){
			UserDao.session.beginTransaction();
			List<Form> form = (List<Form>)UserDao.session.createQuery("from Form f where f.emp_id = '"+emp_id+"' and f.status='Resolved'").list();
			UserDao.session.getTransaction().commit();
			return form;
		}
		
		// this method is selecting all forms from the reimbursement table by the employee id	
		public List<Form>getAllForms(){
			UserDao.session.beginTransaction();
			List<Form> form = (List<Form>)UserDao.session.createQuery("from Form").list();
			UserDao.session.getTransaction().commit();
			return form;
		 }

		public Form getFormById(int id) {
			UserDao.session.beginTransaction();
			Form form =	(Form) UserDao.session.get(Form.class, id);
			UserDao.session.getTransaction().commit();
			return form;
		}
		public static void updateForm(Form form) {
	        Transaction transaction = null;
	        try  {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(form);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
		
		 public List < Form > getAllUser() {

		        Transaction transaction = null;
		        List < Form > listOfForm = null;
		        try  {
		            // start a transaction
		            transaction = session.beginTransaction();
		            // get an user object

		            listOfForm = session.createQuery("from Form").getResultList();

		            // commit transaction
		            transaction.commit();
		        } catch (Exception e) {
		            if (transaction != null) {
		                transaction.rollback();
		            }
		            e.printStackTrace();
		        }
		        return listOfForm;
		    }
		
	}

