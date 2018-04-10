package com.rongyuez.boot.dao;

import java.util.List;

import com.rongyuez.boot.pojo.Customer;
import com.rongyuez.boot.pojo.EditCustomer;
import com.rongyuez.boot.pojo.QueryVo;

public interface CustomerDao {
	public List<Customer> getCustList(QueryVo queryVo);
	public Integer getCustListCount(QueryVo queryVo);
	public EditCustomer getCustById(Long id);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustById(Long id);
}
