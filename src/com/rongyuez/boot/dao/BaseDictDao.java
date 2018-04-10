package com.rongyuez.boot.dao;

import java.util.List;

import com.rongyuez.boot.pojo.BaseDict;

public interface BaseDictDao {
	//≤È’“BaseDict–≈œ¢
	public List<BaseDict> getDictListByTypeCode(String typeCode);
}
