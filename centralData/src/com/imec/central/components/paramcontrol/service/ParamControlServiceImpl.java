package com.imec.central.components.paramcontrol.service;

import com.imec.central.components.paramcontrol.mapper.ParamControlMapper;
import com.imec.central.components.paramcontrol.pojo.ControlParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ParamControlService")
public class ParamControlServiceImpl implements ParamControlService {

    @Autowired
    private ParamControlMapper paramControlMapper;

    @Override
    public void paramControl(ControlParam controlParam){

        paramControlMapper.paramContrallor(controlParam);
    }

    @Override
    public Boolean plcController(ControlParam controlParam){ return true; }

}
