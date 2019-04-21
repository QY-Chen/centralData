package com.imec.central.api.mapper;

import com.imec.central.components.collection.pojo.ChillerData;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public abstract interface EntityMapper<T> {
	public abstract List<T> selectEntity(String paramString);

	public abstract List<T> selectSimpleEntity(String paramString);

	public abstract int selectEntityCount(String paramString);

	public abstract T selectSingleEntity(String paramString);

	public abstract T selectSingleSimpleEntity(String paramString);

	public abstract int addEntity(T paramT);

	public abstract int deleteEntity(T paramT);

	public abstract int updateEntity(T paramT);

	public abstract boolean checkExists(String paramString);

	public abstract int addExtProperties(HashMap<String, Object> paramHashMap);

	public abstract int deleteEntity(String paramString);

	public abstract List<T> queryData(Integer num,  Integer startTime, Integer endTime);

	public abstract List<T> queryByTime( Integer startTime,Integer endTime);

	public abstract List<T> queryByNum(Integer num);
}
