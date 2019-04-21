package com.imec.central.mvc.controllers.admin

import com.imec.central.api.parameters.EcParameter
import com.imec.central.components.runmgr.mapper.PlcRunLogMapper
import com.imec.central.components.runmgr.service.PlcRunLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}
import org.springframework.web.servlet.ModelAndView

import scala.collection.mutable

@Controller
@RequestMapping(Array { "/index2" })
class IndexController {

  @Autowired
  var plcRunLogService:PlcRunLogService = null;

  @RequestMapping(Array { "/" })
  def index(): String = "index"


  @RequestMapping(Array {"/test"})
  @ResponseBody
  def test(): Object ={
    var map:mutable.HashMap[String, String] =new mutable.HashMap[String, String]
    map.put("aaa","1")

    val ec = new EcParameter();
    ec.setDataTable("plc_run_log_201706")
    ec.setStartDate("2017-06-16 00:00")
    ec.setEndDate("2017-06-17 19:00")
    System.out.println(11)
    return plcRunLogService.getPlcRunlogInfo(ec);//new ModelAndView("index","message","Scala!!")
  }
}
