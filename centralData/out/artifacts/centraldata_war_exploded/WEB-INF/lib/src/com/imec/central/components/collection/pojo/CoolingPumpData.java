package com.imec.central.components.collection.pojo;

import java.util.Date;

public class CoolingPumpData {
    private  Integer id; // 参数信息id
    private  Integer num ; // 设备编号
    private Date time;
    private  String status; // 手/自动
    private  String frequencyStatus ; // 公频运行状态
    private  String frequencyAlert; // 公频报警
    private  String contactorStatus; // 变频接触器状态
    private  String inverterStatus; // 变频运行状态
    private  String inverterAlert; // 变频器报警
    private  String inverterAdjust; // 变频器调节
    private  String inverterPowFeed; // 变频器功率反馈
    private  String startFailed; // 启动失败
    private  String supplyTemp ; // 出水温度
    private  String returnTemp ; // 回水温度
    private  String waterFlow; // 水流量
    private  String waterPressure; //冷却水压差
    private  String pumpPressure; // 冷却泵压差
    private  String ammeter; //冷却泵电表

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFrequencyStatus() {
        return frequencyStatus;
    }

    public void setFrequencyStatus(String frequencyStatus) {
        this.frequencyStatus = frequencyStatus;
    }

    public String getFrequencyAlert() {
        return frequencyAlert;
    }

    public void setFrequencyAlert(String frequencyAlert) {
        this.frequencyAlert = frequencyAlert;
    }

    public String getContactorStatus() {
        return contactorStatus;
    }

    public void setContactorStatus(String contactorStatus) {
        this.contactorStatus = contactorStatus;
    }

    public String getInverterStatus() {
        return inverterStatus;
    }

    public void setInverterStatus(String inverterStatus) {
        this.inverterStatus = inverterStatus;
    }

    public String getInverterAlert() {
        return inverterAlert;
    }

    public void setInverterAlert(String inverterAlert) {
        this.inverterAlert = inverterAlert;
    }

    public String getInverterAdjust() {
        return inverterAdjust;
    }

    public void setInverterAdjust(String inverterAdjust) {
        this.inverterAdjust = inverterAdjust;
    }

    public String getInverterPowFeed() {
        return inverterPowFeed;
    }

    public void setInverterPowFeed(String inverterPowFeed) {
        this.inverterPowFeed = inverterPowFeed;
    }

    public String getStartFailed() {
        return startFailed;
    }

    public void setStartFailed(String startFailed) {
        this.startFailed = startFailed;
    }

    public String getSupplyTemp() {
        return supplyTemp;
    }

    public void setSupplyTemp(String supplyTemp) {
        this.supplyTemp = supplyTemp;
    }

    public String getReturnTemp() {
        return returnTemp;
    }

    public void setReturnTemp(String returnTemp) {
        this.returnTemp = returnTemp;
    }

    public String getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(String waterFlow) {
        this.waterFlow = waterFlow;
    }

    public String getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(String waterPressure) {
        this.waterPressure = waterPressure;
    }

    public String getPumpPressure() {
        return pumpPressure;
    }

    public void setPumpPressure(String pumpPressure) {
        this.pumpPressure = pumpPressure;
    }

    public String getAmmeter() {
        return ammeter;
    }

    public void setAmmeter(String ammeter) {
        this.ammeter = ammeter;
    }
}
