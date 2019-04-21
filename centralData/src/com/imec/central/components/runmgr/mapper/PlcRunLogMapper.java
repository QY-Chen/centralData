package com.imec.central.components.runmgr.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.api.parameters.EcParameter;
import com.imec.central.components.runmgr.pojo.*;

import java.util.List;

/**
 * Created by shinny on 2017-07-18.
 */
@BaseMapper
public interface PlcRunLogMapper {
    public List<PlcRunLog> getPlcRunlogInfo(EcParameter paramEcParameter);

    public List<DeviceOptLog> getDeviceOptLog(EcParameter paramEcParameter);

    public List<DeviceAlarmLog> getDeviceAlarmLog(EcParameter paramEcParameter);

    public List<OptLog> getOptLog(EcParameter paramEcParameter);

    public List<BuildInfo> getBuildInfo();

    public List<DeviceInfo> getDeviceInfo();

    public void clearRunNum(int deviceId);

    public void clearRunTime(int deviceId);
}
