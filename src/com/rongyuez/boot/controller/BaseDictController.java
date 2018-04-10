package com.rongyuez.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongyuez.boot.exception.CustomException;
import com.rongyuez.boot.pojo.BaseDict;
import com.rongyuez.boot.pojo.Customer;
import com.rongyuez.boot.pojo.EditCustomer;
import com.rongyuez.boot.pojo.QueryVo;
import com.rongyuez.boot.service.BaseDictService;
import com.rongyuez.boot.service.CustomerService;
import com.rongyuez.boot.util.Page;


@Controller
@RequestMapping("/customer")
public class BaseDictController {
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@Value("${customer.source.code}")
	private String sourceCode;
	
	@Value("${customer.industry.code}")
	private String industryCode;
	
	@Value("${customer.level.code}")
	private String levelCode;
	
	//��ʾ�ͻ�bootϵͳҳ��
	@RequestMapping("/list")
	public String list(Model model,QueryVo queryVo){
		try {
			//��ѯ�ͻ���Դ
			List<BaseDict> source = baseDictService.getDictListByTypeCode(sourceCode);
			//��ѯ������ҵ
			List<BaseDict> industry = baseDictService.getDictListByTypeCode(industryCode);
			//��ѯ�ͻ�����
			List<BaseDict> level = baseDictService.getDictListByTypeCode(levelCode);
			
			model.addAttribute("fromType", source);
			model.addAttribute("industryType", industry);
			model.addAttribute("levelType", level);
			
			//��ʾ���пͻ��б�
			Page<Customer> page = customerService.getCustPage(queryVo);
			
			
			model.addAttribute("page", page);
			
			//��ѯ����Ļ���ҳ����
			model.addAttribute("custName", queryVo.getCustName());
			model.addAttribute("custSource", queryVo.getCustSource());
			model.addAttribute("custIndustry", queryVo.getCustIndustry());
			model.addAttribute("custLevel", queryVo.getCustLevel());
			
			return "customer";
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("��ʾ���ִ���");
		}
		
	}
	
	//�޸���Ϣ���ݻ���
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public EditCustomer edit(@PathVariable("id") String id){
		EditCustomer ediCustomer =  customerService.getCustById(Long.parseLong(id));
		return ediCustomer;
	}
	
	//�޸�������Ϣ
	@RequestMapping("/update")
	public String update(Customer customer){
		customerService.updateCustomer(customer);
		return "customer";
	}
	
	//ɾ��������Ϣ
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String id){
		customerService.deleteCustById(Long.parseLong(id));
		return "customer";
	}
	
	
}
