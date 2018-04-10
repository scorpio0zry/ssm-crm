package com.rongyuez.boot.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex) {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", ex.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
