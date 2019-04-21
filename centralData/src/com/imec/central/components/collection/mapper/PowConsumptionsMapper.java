package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;

import java.util.Map;

@BaseMapper
public interface PowConsumptionsMapper {

    /**
     * 空调照明能耗
     */
    public void addLightSocketPC(Map map);

    /**
     * 动力和特殊能耗
     */
    public void addOthersPC(Map map);


}
