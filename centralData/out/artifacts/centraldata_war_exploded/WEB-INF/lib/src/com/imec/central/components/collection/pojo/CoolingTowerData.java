package com.imec.central.components.collection.pojo;

import javax.xml.crypto.Data;

public class CoolingTowerData {
    private  Integer id; // 数据id
    private  Integer num ; // 设备编号
    private  Integer status ; // 手自动
    private  Integer frequencyStatus; // 公频运行状态
    private  Integer frequencyAlert ; // 公频报警
    private  Integer contactorStatus ; // 变频接触器状态
    private  Integer inverterStatus; // 变频运行状态
    private  Integer inverterAlert ; // 变频器报警
    private  Integer inverterAdjust; //变频器调节
    private  Integer inverterPowFeed ; // 变频器功率反馈
    private  Integer startFailed ; // 启动失败
    private Data addTime ; // 信息更新时间
    private Integer ammeter; //冷却塔电表

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

    public Data getAddTime() {
        return addTime;
    }

    public void setAddTime(Data addTime) {
        this.addTime = addTime;
    }

    public Integer getAmmeter() {
        return ammeter;
    }

    public void setAmmeter(Integer ammeter) {
        this.ammeter = ammeter;
    }
}
