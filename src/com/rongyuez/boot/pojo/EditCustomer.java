package com.rongyuez.boot.pojo;

public class EditCustomer extends Customer{
	private String cust_source_id;
	private String cust_industry_id;
	private String cust_level_id;
	public String getCust_source_id() {
		return cust_source_id;
	}
	public void setCust_source_id(String cust_source_id) {
		this.cust_source_id = cust_source_id;
	}
	public String getCust_industry_id() {
		return cust_industry_id;
	}
	public void setCust_industry_id(String cust_industry_id) {
		this.cust_industry_id = cust_industry_id;
	}
	public String getCust_level_id() {
		return cust_level_id;
	}
	public void setCust_level_id(String cust_level_id) {
		this.cust_level_id = cust_level_id;
	}
	
}
