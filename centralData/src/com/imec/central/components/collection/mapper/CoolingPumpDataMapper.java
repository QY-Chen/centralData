package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.CoolingPumpData;

import java.util.Map;

@BaseMapper
public abstract interface CoolingPumpDataMapper extends EntityMapper<CoolingPumpData>{

    /*
    * add cooling Pump real-time data
    * */
    public void addCoolPumpData(Map map);

    public Map queryCoolPumpById(int num);


}
