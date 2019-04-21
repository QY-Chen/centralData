package com.imec.central.components.collection.pojo;

import javax.xml.crypto.Data;

public class FreezingPumpData {
    private  Integer id; // 参数信息id
    private  Integer num ; // 设备编号
    private  Integer status; // 手/自动
    private  Integer frequencyStatus ; // 公频运行状态
    private  Integer frequencyAlert; // 公频报警
    private  Integer contactorStatus; // 变频接触器状态
    private  Integer inverterStatus; // 变频运行状态
    private  Integer inverterAlert; // 变频器报警
    private  Integer inverterAdjust; // 变频器调节
    private  Integer inverterPowFeed; // 变频器功率反馈
    private  Integer startFailed; // 启动失败
    private  Integer supplyTemp ; // 出水温度
    private  Integer returnTemp ; // 回水温度
    private  Integer waterFlow; // 水流量
    private  Integer waterPressure;
    private  Integer pumpPressure;
    private  Integer ammeter;
    private  Data addTime; // 信息更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer mun) {
        this.num = mun;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFrequencyStatus() {
        return frequencyStatus;
    }

    public void setFrequencyStatus(Integer frequencyStatus) {
        this.frequencyStatus = frequencyStatus;
    }

    public Integer getFrequencyAlert() {
        return frequencyAlert;
    }

    public void setFrequencyAlert(Integer frequencyAlert) {
        this.frequencyAlert = frequencyAlert;
    }

    public Integer getContactorStatus() {
        return contactorStatus;
    }

    public void setContactorStatus(Integer contactorStatus) {
        this.contactorStatus = contactorStatus;
    }

    public Integer getInverterStatus() {
        return inverterStatus;
    }

    public void setInverterStatus(Integer inverterStatus) {
        this.inverterStatus = inverterStatus;
    }

    public Integer getInverterAlert() {
        return inverterAlert;
    }

    public void setInverterAlert(Integer inverterAlert) {
        this.inverterAlert = inverterAlert;
    }

    public Integer getInverterAdjust() {
        return inverterAdjust;
    }

    public void setInverterAdjust(Integer inverterAdjust) {
        this.inverterAdjust = inverterAdjust;
    }

    public Integer getInverterPowFeed() {
        return inverterPowFeed;
    }

    public void setInverterPowFeed(Integer inverterPowFeed) {
        this.inverterPowFeed = inverterPowFeed;
    }

    public Integer getStartFailed() {
        return startFailed;
    }

    public void setStartFailed(Integer startFailed) {
        this.startFailed = startFailed;
    }

    public Integer getSupplyTemp() {
        return supplyTemp;
    }

    public void setSupplyTemp(Integer supplyTemp) {
        this.supplyTemp = supplyTemp;
    }

    public Integer getReturnTemp() {
        return returnTemp;
    }

    public void setReturnTemp(Integer returnTemp) {
        this.returnTemp = returnTemp;
    }

    public Integer getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(Integer waterFlow) {
        this.waterFlow = waterFlow;
    }

    public Integer getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(Integer waterPressure) {
        this.waterPressure = waterPressure;
    }

    public Integer getPumpPressure() {
        return pumpPressure;
    }

    public void setPumpPressure(Integer pumpPressure) {
        this.pumpPressure = pumpPressure;
    }

    public Integer getAmmeter() {
        return ammeter;
    }

    public void setAmmeter(Integer ammeter) {
        this.ammeter = ammeter;
    }

    public Data getAddTime() {
        return addTime;
    }

    public void setAddTime(Data addTime) {
        this.addTime = addTime;
    }
}
