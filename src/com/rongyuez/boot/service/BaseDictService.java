package com.rongyuez.boot.service;

import java.util.List;

import com.rongyuez.boot.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> getDictListByTypeCode(String typeCode);
}
