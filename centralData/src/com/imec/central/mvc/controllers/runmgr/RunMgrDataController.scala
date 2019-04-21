package com.imec.central.mvc.controllers.runmgr

import java.text.SimpleDateFormat

import com.imec.central.api.parameters.EcParameter
import com.imec.central.components.runmgr.service.PlcRunLogService
import org.joda.time.DateTime
import org.joda.time.format.{DateTimeFormat, DateTimeFormatter}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}

/**
  * Created by shinny on 2017-07-15.
  */
@Controller
@RequestMapping(Array { "/runMgrData" })
class RunMgrDataController {
  @Autowired
  var plcRunLogService:PlcRunLogService = null;

  @RequestMapping(Array {"/getPlcRunMgrDataList"})
  @ResponseBody
  def getPlcRunMgrDataList(date:String): Object ={
    val ec = new EcParameter();
    val format:DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    val start_date = DateTime.parse(date, format)
    ec.setDataTable("plc_run_log_" + start_date.toString("yyyyMM"))
    ec.setStartDate(start_date.toString("yyyy-MM-dd HH:00"))//"2017-06-16 00:00"
    val end_date = start_date.plusHours(1)
    ec.setEndDate(end_date.toString("yyyy-MM-dd HH:00"))
    return plcRunLogService.getPlcRunlogInfo(ec);//new ModelAndView("index","message","Scala!!")
  }

  @RequestMapping(Array {"/getDeviceOptLog"})
  @ResponseBody
  def getDeviceOptLog(bulidId:Int, beginTime:String, endTime:String, pageIndex:Int,
                      pageSize:Int): Object ={
    val ec = new EcParameter();
    ec.setKey(bulidId.toString)
    ec.setStartDate(beginTime)
    ec.setEndDate(endTime)
    var nIndex = (pageIndex - 1) * pageSize;
    if (nIndex < 0) nIndex = 0;
    ec.setLimit(nIndex)
    ec.setOffset(pageSize)
    return plcRunLogService.getDeviceOptLog(ec);//new ModelAndView("index","message","Scala!!")
  }

  @RequestMapping(Array {"/getDeviceAlarmLog"})
  @ResponseBody
  def getDeviceAlarmLog(logTimeType:Int, bulidId:Int, beginTime:String, endTime:String, pageIndex:Int,
                      pageSize:Int): Object ={
    val ec = new EcParameter();
    ec.setKey(bulidId.toString)
    ec.setStartDate(beginTime)
    ec.setEndDate(endTime)
    var sTimeType = ""
    if (logTimeType == 1)
      sTimeType = "AlarmTime";
    else
      sTimeType = "AlarmRelTime";
    ec.setsWhere(sTimeType)
    var nIndex = (pageIndex - 1) * pageSize;
    if (nIndex < 0) nIndex = 0;
    ec.setLimit(nIndex)
    ec.setOffset(pageSize)
    return plcRunLogService.getDeviceAlarmLog(ec);//new ModelAndView("index","message","Scala!!")
  }

  @RequestMapping(Array {"/getOptLog"})
  @ResponseBody
  def getOptLog(beginTime:String, endTime:String, pageIndex:Int,
                      pageSize:Int): Object ={
    val ec = new EcParameter();
    ec.setStartDate(beginTime)
    ec.setEndDate(endTime)
    var nIndex = (pageIndex - 1) * pageSize;
    if (nIndex < 0) nIndex = 0;
    ec.setLimit(nIndex)
    ec.setOffset(pageSize)
    return plcRunLogService.getOptLog(ec);//new ModelAndView("index","message","Scala!!")
  }

  @RequestMapping(Array {"/getBuildInfo"})
  @ResponseBody
  def getBuildInfo(): Object ={
    plcRunLogService.getBuildInfo;
  }

  @RequestMapping(Array {"/getDeviceInfo"})
  @ResponseBody
  def getDeviceInfo(): Object ={
    plcRunLogService.getDeviceInfo;
  }

  @RequestMapping(Array {"/clearRunNum"})
  @ResponseBody
  def clearRunNum(deviceId: Int): Boolean ={
    plcRunLogService.clearRunNum(deviceId)
  }

  @RequestMapping(Array {"/clearRunTime"})
  @ResponseBody
  def clearRunTime(deviceId: Int): Boolean ={
    plcRunLogService.clearRunTime(deviceId);
  }
}
