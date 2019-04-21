package com.imec.central.components.analysis.mapper;

import org.apache.ibatis.annotations.Param;
import scala.annotation.meta.param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//传入的参数只要精确到要查找的时间类型，如要查2017年8月的数据，则Date month=new Date("2017-08"),要查2017年8月1日，则Date day=new Date("2017-08-01")
public interface AnalysisMapper {

    //查询冷源设备，返回设备编号和对应的表
    public List<HashMap> resource_device();

    //查询末端设备，返回设备编号和对应的表
    public List<HashMap> terminal_device();

    //统计设备上一小时耗电量,参数为设备编号device_num,设备类型type（冷源电耗=cspc，末端电耗=actpc ）设备对应的表名table_name
    public void statistics(HashMap a);

    //统计站点上一小时的电耗，参数为station_num站点编号
    public void power_statistics(int station_num);

    public List select_ammeter();

    public List<Map> statisticByHour(@Param("begin_time") Date begin_time,@Param("end_time") Date end_time);

}
