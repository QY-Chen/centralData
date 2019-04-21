package com.imec.central.components.runmgr.service
import java.util

import com.imec.central.api.parameters.EcParameter
import com.imec.central.components.runmgr.mapper.PlcRunLogMapper
import com.imec.central.components.runmgr.pojo._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Created by shinny on 2017-07-19.
  */
@Service("plcRunLogService")
class PlcRunLogServiceImpl extends PlcRunLogService{
  @Autowired
  var plcRunLogMapper:PlcRunLogMapper = null

  override def getPlcRunlogInfo(paramEcParameter: EcParameter): util.List[PlcRunLog] = {
    plcRunLogMapper.getPlcRunlogInfo(paramEcParameter)
  }

  override def getDeviceOptLog(paramEcParameter: EcParameter): util.List[DeviceOptLog] = {
    plcRunLogMapper.getDeviceOptLog(paramEcParameter)
  }

  override def getDeviceAlarmLog(paramEcParameter: EcParameter): util.List[DeviceAlarmLog] = {
    plcRunLogMapper.getDeviceAlarmLog(paramEcParameter)
  }

  override def getOptLog(paramEcParameter: EcParameter): util.List[OptLog] = {
    plcRunLogMapper.getOptLog(paramEcParameter)
  }

  override def getBuildInfo: util.List[BuildInfo] = {
    plcRunLogMapper.getBuildInfo()
  }

  override def getDeviceInfo: util.List[DeviceInfo] = {
    plcRunLogMapper.getDeviceInfo()
  }

  override def clearRunNum(deviceId: Int): Boolean = {
    var flag = false
    try{
      plcRunLogMapper.clearRunNum(deviceId)
      flag =true;
    }catch {
      case e:Exception=>
        flag =false
    }
    flag
  }

  override def clearRunTime(deviceId: Int): Boolean = {
    var flag = false
    try{
      plcRunLogMapper.clearRunTime(deviceId)
      flag =true;
    }catch {
      case e:Exception=>
        flag =false
    }
    flag
  }
}
