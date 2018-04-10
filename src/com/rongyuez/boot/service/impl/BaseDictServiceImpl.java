package com.rongyuez.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rongyuez.boot.dao.BaseDictDao;
import com.rongyuez.boot.pojo.BaseDict;
import com.rongyuez.boot.service.BaseDictService;
@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getDictListByTypeCode(String typeCode) {
		
		return baseDictDao.getDictListByTypeCode(typeCode);
	}

}
