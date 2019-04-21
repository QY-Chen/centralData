package com.imec.central.components.paramcontrol.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.paramcontrol.pojo.ControlParam;

@BaseMapper
public interface ParamControlMapper {
    /**
     * control parameter
     */
    public void paramContrallor(ControlParam controlParam);

}
