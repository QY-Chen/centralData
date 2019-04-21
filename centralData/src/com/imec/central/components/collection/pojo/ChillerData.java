package com.imec.central.components.collection.pojo;
//主机
import java.io.Serializable;
import java.util.Date;

public class ChillerData implements Serializable{
    private  Integer status; //远程/开机/停机状态
    private  Integer id; //主机id
    private  Integer num ; // 设备编号
    private  Integer runningStatus; //主机运行状态
    private  Integer failureIndication; //主机故障指示
    private  Integer startFail ; // 主机启动失败
    private  Integer supplyTemp ; //主机冷冻水出水温度
    private  Integer returnTemp; // 主机冷冻水回水温度
    private  Integer loadRate;
    private  Integer runningCurrent;
    private  Integer supplyCoolingTemp;
    private  Integer returnCoolingTemp;
    private  Integer evaporatePressure;
    private  Integer evaporateTemp;
    private  Integer condensingPressure;
    private  Integer condensingTemp;
    private  Integer ammeter;
    private Date time;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public Integer getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(Integer runningStatus) {
        this.runningStatus = runningStatus;
    }

    public Integer getFailureIndication() {
        return failureIndication;
    }

    public void setFailureIndication(Integer failureIndication) {
        this.failureIndication = failureIndication;
    }

    public Integer getStartFail() {
        return startFail;
    }

    public void setStartFail(Integer startFail) {
        this.startFail = startFail;
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

    public Integer getLoadRate() {
        return loadRate;
    }

    public void setLoadRate(Integer loadRate) {
        this.loadRate = loadRate;
    }

    public Integer getRunningCurrent() {
        return runningCurrent;
    }

    public void setRunningCurrent(Integer runningCurrent) {
        this.runningCurrent = runningCurrent;
    }

    public Integer getSupplyCoolingTemp() {
        return supplyCoolingTemp;
    }

    public void setSupplyCoolingTemp(Integer supplyCoolingTemp) {
        this.supplyCoolingTemp = supplyCoolingTemp;
    }

    public Integer getReturnCoolingTemp() {
        return returnCoolingTemp;
    }

    public void setReturnCoolingTemp(Integer returnCoolingTemp) {
        this.returnCoolingTemp = returnCoolingTemp;
    }

    public Integer getEvaporatePressure() {
        return evaporatePressure;
    }

    public void setEvaporatePressure(Integer evaporatePressure) {
        this.evaporatePressure = evaporatePressure;
    }

    public Integer getEvaporateTemp() {
        return evaporateTemp;
    }

    public void setEvaporateTemp(Integer evaporateTemp) {
        this.evaporateTemp = evaporateTemp;
    }

    public Integer getCondensingPressure() {
        return condensingPressure;
    }

    public void setCondensingPressure(Integer condensingPressure) {
        this.condensingPressure = condensingPressure;
    }

    public Integer getCondensingTemp() {
        return condensingTemp;
    }

    public void setCondensingTemp(Integer condensingTemp) {
        this.condensingTemp = condensingTemp;
    }

    public Integer getAmmeter() {
        return ammeter;
    }

    public void setAmmeter(Integer ammeter) {
        this.ammeter = ammeter;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
