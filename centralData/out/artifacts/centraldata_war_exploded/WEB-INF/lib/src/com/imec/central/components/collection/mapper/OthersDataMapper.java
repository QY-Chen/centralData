package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.OthersData;

import java.util.Map;

@BaseMapper
public abstract interface OthersDataMapper extends EntityMapper<OthersData> {

    //新增数据
    public void addOthersData(Map map);

    //查询最新数据
    public Map queryOthersData(String deviceType);
}
