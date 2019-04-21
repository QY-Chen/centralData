package com.imec.central.components.runmgr.service

import com.imec.central.api.parameters.EcParameter
import com.imec.central.components.runmgr.pojo._

/**
  * Created by shinny on 2017-07-19.
  */
trait PlcRunLogService {
  def getPlcRunlogInfo (paramEcParameter: EcParameter): java.util.List[PlcRunLog]

  def getDeviceOptLog (paramEcParameter: EcParameter): java.util.List[DeviceOptLog];

  def getDeviceAlarmLog (paramEcParameter: EcParameter): java.util.List[DeviceAlarmLog];

  def getOptLog (paramEcParameter: EcParameter): java.util.List[OptLog];

  def getBuildInfo: java.util.List[BuildInfo]

  def getDeviceInfo: java.util.List[DeviceInfo]

  def clearRunNum(deviceId: Int): Boolean

  def clearRunTime(deviceId: Int): Boolean
}
