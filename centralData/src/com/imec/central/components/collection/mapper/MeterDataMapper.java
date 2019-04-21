package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.collection.pojo.MeterData;

import java.util.List;
import java.util.Map;

@BaseMapper
public interface MeterDataMapper {

    //增加电表实时数据
    public void addMeterData(Map map);
}
