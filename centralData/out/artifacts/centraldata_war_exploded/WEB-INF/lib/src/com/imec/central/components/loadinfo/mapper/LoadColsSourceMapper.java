package com.imec.central.components.loadinfo.mapper;


import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.loadinfo.pojo.DisplayAcTerminalData;
import com.imec.central.components.loadinfo.pojo.DisplayCsData;

import java.util.List;

@BaseMapper
public interface LoadColsSourceMapper {

    /**
     * load all the displayed data for the cold_source page
     * Latest data
     * chiller
     * freezing_pump
     * cooling_pump
     * cooling_tower
     */
    public List<DisplayCsData> laodColdSourcedata(Integer cpNum,Integer ctNum,Integer fpNum);

    /**
     *  load all the displayed data for the xxxx page
     */
    public List<DisplayAcTerminalData> loadActerminalData();

}
