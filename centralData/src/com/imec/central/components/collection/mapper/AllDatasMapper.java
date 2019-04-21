package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.AllDatas;

import java.util.Map;

@BaseMapper
public interface AllDatasMapper extends EntityMapper<AllDatas> {

    public void AddAllDatas(Map map);

    public Map queryAllDatas();
}
