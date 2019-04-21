package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;

import java.util.Map;

@BaseMapper
public interface PowConsumptionMapper {
    /**
     * 空调末端能耗
     */
    public void addACTerminalPC(Map map);

    /**
     * 冷源能耗
     */
    public void addCoolingSource(Map map);

    /**
     * 末端盘管参数
     */
    public void addAcTerminal(Map map);


}
