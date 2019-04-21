package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.PressureData;

import java.util.Map;

@BaseMapper
public abstract interface PressurePointMapper extends EntityMapper<PressureData>{

    //添加阀和开关的数据
    public void addPressureData(Map map);

    //查询数据
    public Map qureyPressureData();

}
