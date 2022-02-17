package com.revature.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ersforms")
public class Form {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String id;
	public String getId() {
		return id;
	}
	public void setId(String id2) {
		this.id = id2;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id2) {
		this.emp_id = emp_id2;
	}
	public String getType_of_expense() {
		return type_of_expense;
	}
	public void setType_of_expense(String type_of_expense) {
		this.type_of_expense = type_of_expense;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount2) {
		this.amount = amount2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSub_date() {
		return sub_date;
	}
	public void setSub_date(String sub_date) {
		this.sub_date = sub_date;
	}
	@Column(name="emp_id")
	public String emp_id;
	@Column(name="type_of_expense")
	public String type_of_expense;
	@Column(name="amount")
	public String amount;
	@Column(name="status")
	public String status;
	@Column(name="result")
	public String result;
	@Column(name="sub_date")
	public String sub_date;
	public Form(String id, String emp_id, String type_of_expense, String amount, String status, String result,
			String sub_date) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.type_of_expense = type_of_expense;
		this.amount = amount;
		this.status = status;
		this.result = result;
		this.sub_date = sub_date;
	}
	public Form(String id, String emp_id, String type_of_expense, String amount, String status) {
		super();
		this.id=id;
		this.emp_id=emp_id;
		this.type_of_expense=type_of_expense;
		this.amount=amount;
		this.status=status;
		
	}
	@Override
	public String toString() {
		return "Form [id=" + id + ", emp_id=" + emp_id + ", type_of_expense=" + type_of_expense + ", amount=" + amount
				+ ", status=" + status + ", result=" + result + ", sub_date=" + sub_date + "]";
	}
	public Form() {}
	public Form(int id2, int emp_id2, String type_of_expense2, String amount2, String status2, String sub_date2) {
		// TODO Auto-generated constructor stub
	}
	public static void add(Form form) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
