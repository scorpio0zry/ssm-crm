package com.rongyuez.boot.service;

import com.rongyuez.boot.pojo.Customer;
import com.rongyuez.boot.pojo.EditCustomer;
import com.rongyuez.boot.pojo.QueryVo;
import com.rongyuez.boot.util.Page;


public interface CustomerService {
	public Page<Customer> getCustPage(QueryVo queryVo);
	
	public EditCustomer getCustById(Long id);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustById(Long id);
}
