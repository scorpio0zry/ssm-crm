package com.rongyuez.boot.dao;

import java.util.List;

import com.rongyuez.boot.pojo.BaseDict;

public interface BaseDictDao {
	//����BaseDict��Ϣ
	public List<BaseDict> getDictListByTypeCode(String typeCode);
}
