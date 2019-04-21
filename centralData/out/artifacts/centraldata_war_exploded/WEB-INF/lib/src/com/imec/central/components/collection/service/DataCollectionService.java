package com.imec.central.components.collection.service;

import com.imec.central.components.collection.pojo.ContactData;

import java.util.List;
import java.util.Map;

public interface DataCollectionService {
    /**
     * load all point data
     */
    public List<ContactData> getPoint();

    /*
    * get needed point data
    * */
    public List<ContactData> getNeededPoint(int startNum, int endNum);
    /*
    * 增加主机数据
    * */
    public void addChillerData(List<ContactData> list,int startNum,int endNum);

    /*
    * 增冷冻泵实时数据
    * */
    public  void  addFreezPumpData(List<ContactData> list,int startNum,int endNum);

    /*
    * add cooling pump real-time data
    * */
    public void addCoolPumpData(List<ContactData> list,int startNum,int endNum);

    /*
    * add cooling tower rea-time data
    * */
    public void addCoolTowerData(List<ContactData> list,int startNum,int endNum);

    /**
     * 增加水阀和开关的数据
     */
    public void addValveData(List<ContactData> list ,int startNum, int endNum);

    /**
     *增加压力点数据
     */
    public void addPressureData(List<ContactData> list,int startNum, int endNum);

    /**
     * 累计供冷时间
     * 冷冻水和冷却水流量
     * 10min平均流量和功率
     * 冷冻水冷却水出回水温度
     * 1#室外温湿度
     * 冷冻水冷却水压差
     */
    public void addOthersData(List<ContactData> list ,int startNum , int endNum);

    /**
     * 将所有的数据放到同一个表里面
     */
    public void addAllDatas();



    /**
     * collecting data from PLC
     */
    public Map dataCollection(List<ContactData> list,int startNum,int endNum);

    /**
     * converter 16 band to 10 band
     */
    public Map converter(Map<String ,String> map,int startmun);










}
