package com.imec.central.components.paramcontrol.service;

import com.imec.central.components.paramcontrol.pojo.ControlParam;

public interface ParamControlService {
    /*
    * 将设定的数据写入数据库
    * */
    public void paramControl(ControlParam controlParam);

    /*
    * 将设定的数据写如PLC执行
    * */
    public Boolean plcController(ControlParam controlParam);
}
