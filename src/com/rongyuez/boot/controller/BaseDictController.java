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
	
	//显示客户boot系统页面
	@RequestMapping("/list")
	public String list(Model model,QueryVo queryVo){
		try {
			//查询客户来源
			List<BaseDict> source = baseDictService.getDictListByTypeCode(sourceCode);
			//查询所属行业
			List<BaseDict> industry = baseDictService.getDictListByTypeCode(industryCode);
			//查询客户级别
			List<BaseDict> level = baseDictService.getDictListByTypeCode(levelCode);
			
			model.addAttribute("fromType", source);
			model.addAttribute("industryType", industry);
			model.addAttribute("levelType", level);
			
			//显示所有客户列表
			Page<Customer> page = customerService.getCustPage(queryVo);
			
			
			model.addAttribute("page", page);
			
			//查询过后的回在页面上
			model.addAttribute("custName", queryVo.getCustName());
			model.addAttribute("custSource", queryVo.getCustSource());
			model.addAttribute("custIndustry", queryVo.getCustIndustry());
			model.addAttribute("custLevel", queryVo.getCustLevel());
			
			return "customer";
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("显示出现错误");
		}
		
	}
	
	//修改信息数据回显
	@RequestMapping("/edit/{id}")
	@ResponseBody
	public EditCustomer edit(@PathVariable("id") String id){
		EditCustomer ediCustomer =  customerService.getCustById(Long.parseLong(id));
		return ediCustomer;
	}
	
	//修改数据信息
	@RequestMapping("/update")
	public String update(Customer customer){
		customerService.updateCustomer(customer);
		return "customer";
	}
	
	//删除数据信息
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String id){
		customerService.deleteCustById(Long.parseLong(id));
		return "customer";
	}
	
	
}
