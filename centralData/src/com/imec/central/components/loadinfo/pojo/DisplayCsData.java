package com.imec.central.components.loadinfo.pojo;

import java.io.Serializable;

public class DisplayCsData implements Serializable{

   // 远程/手动/自动状态
    private Integer ctStasus;
    private Integer chiStatus;
    private Integer fpStatus;
    private Integer cpStatus;
    //出水/回水温度
    private Integer ctSupplyTemp;
    private Integer ctReturnTemp;
    private Integer fpSupplyTemp;
    private Integer fpReturnTemp;
    private Integer cpSupplyTemp;
    private Integer cpReturnTemp;

    //制冷主机
    private Integer chiCurrent;//主机电流
    private Integer chiTempSet;//主机温度设定值
    private Integer chiLoadRate;//主机负荷率
    private Integer chiRunTime;//主机累计运行时间
    private Integer chiSupplyTemp;//主机冷冻出水温度
    private Integer chiReturnTemp;//主机冷冻回水温度
    private Integer chiSupplyCoolTemp;//主机冷却出水温度
    private Integer chiReturnCoolTemp;//主机冷却回水温度
    private Integer chiEvaporatingTemp;//蒸发温度
    private Integer chiEvaporatingPress;//蒸发压力
    private Integer chiCondensingTemp;//冷凝温度
    private Integer chiCondensingPress;//冷凝压力
    private Integer chiOilTemp;//油温
    private Integer chiOilPress;//油压

    //
}
