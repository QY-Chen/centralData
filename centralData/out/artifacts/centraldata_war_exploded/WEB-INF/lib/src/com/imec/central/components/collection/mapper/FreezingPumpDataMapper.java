package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.FreezingPumpData;

import java.util.Map;

@BaseMapper
public abstract interface FreezingPumpDataMapper extends EntityMapper<FreezingPumpData> {

    public void addFreezPumpData(Map map);

    public Map queryFreezPumpById(int num);

    /**
     * 点击加载最新冷冻泵信息
     * @param deviceNum  设备编号
     */
    public Map queryCurrentFPData(int deviceNum);

}
