package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.ValveData;

import java.util.Map;

@BaseMapper
public abstract interface ValveMapper extends EntityMapper<ValveData> {

    /**
     * add valve data
     */
    public void addValveData(Map map);

    //query data
    public Map queryValveData(int id);

}
