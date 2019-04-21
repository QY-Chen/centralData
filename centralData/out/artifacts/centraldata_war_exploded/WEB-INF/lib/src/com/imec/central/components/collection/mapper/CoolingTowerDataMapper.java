package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.CoolingTowerData;

import java.util.Map;

@BaseMapper
public abstract interface CoolingTowerDataMapper extends EntityMapper<CoolingTowerData> {
    /*
    * add cooling tower real-time data
    * */
    public void addCoolTowerData(Map map);

    public Map queryCoolTowerById(int num);


    /**
     * 加载最新冷却塔信息
     * @param deviceNum
     */
    public Map queryCurrentCTData(int deviceNum);
}
