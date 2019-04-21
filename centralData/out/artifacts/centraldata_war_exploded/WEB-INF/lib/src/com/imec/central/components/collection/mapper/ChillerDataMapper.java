package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.mapper.EntityMapper;
import com.imec.central.components.collection.pojo.ChillerData;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@BaseMapper
public abstract interface ChillerDataMapper extends EntityMapper<ChillerData> {
    /*
    * add chiller data
    * */

    //增加主机的实时数据
    public void addChillerData(Map map);

    //根据主机编号查询主机最新的数据
    public Map queryChillerData(int num);



}
