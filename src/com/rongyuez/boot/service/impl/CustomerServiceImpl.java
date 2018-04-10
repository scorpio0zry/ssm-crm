package com.rongyuez.boot.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rongyuez.boot.dao.CustomerDao;
import com.rongyuez.boot.pojo.Customer;
import com.rongyuez.boot.pojo.EditCustomer;
import com.rongyuez.boot.pojo.QueryVo;
import com.rongyuez.boot.service.CustomerService;
import com.rongyuez.boot.util.Page;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	//�ͻ���Ϣ��ҳ
	@Override
	public Page<Customer> getCustPage(QueryVo queryVo) {
		Page<Customer> page = new Page<Customer>();
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		List<Customer> customers = customerDao.getCustList(queryVo);
		Integer count = customerDao.getCustListCount(queryVo);
		page.setRows(customers);
		page.setTotal(count);
		page.setPage(queryVo.getPage());
		page.setSize(queryVo.getSize());
		return page;
	}
	
	//����Id��ѯ�˿���Ϣ
	@Override
	public EditCustomer getCustById(Long id) {
		return customerDao.getCustById(id);
	}
	
	//�������ݹ˿���Ϣ
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}
	
	//������Ϣɾ���ͻ���Ϣ
	@Override
	public void deleteCustById(Long id) {
		customerDao.deleteCustById(id);
	}
	
	
	
}
