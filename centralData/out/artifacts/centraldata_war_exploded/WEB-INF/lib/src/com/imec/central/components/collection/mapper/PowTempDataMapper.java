package com.imec.central.components.collection.mapper;


import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.collection.pojo.GateWay;
import com.imec.central.components.collection.pojo.MeterData;
import com.imec.central.components.collection.pojo.Station;
import com.imec.central.components.collection.pojo.TempData;

import java.util.List;
import java.util.Map;

@BaseMapper
public interface PowTempDataMapper {

   /**
    * 获取电表的IP和port
    * @param type 网关名称 /电表/冷源/温度
    */
   public GateWay getGateWay(String type);

   /**
    * 获取所有的电表站号
    */
   public List<Station> getAllStation();

   /**
    * 获取温度点地址EUI
    * @param  floor
    */
   public List getEUI(int floor);

   /**
    * 储存点表信息
    */
   public void savePow(Map map);

   /**
    * 储存温度信息
    */
   public void saveTemp(Map map);

   /**
    * 查询温度信息
    */
   public Map queryTempData();
}
