package com.imec.central.components.collection.pojo;
//阀
import java.util.Date;

public class ValveData {
    private Integer id ;
    private Date time;
    private Integer num;
    private Integer status;
    private Integer fpStatus; // 冷冻阀开关状态
    private Integer  fpFault; //电动阀故障
    private Integer chiSwichStatus; //冷冻水流开关
    private Integer chiSwichFailure;
    private Integer cpSwichStatus; //冷却水流开关
    private Integer cpSwichFailure;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Integer getFpStatus() {
        return fpStatus;
    }

    public void setFpStatus(Integer fpStatus) {
        this.fpStatus = fpStatus;
    }

    public Integer getFpFault() {
        return fpFault;
    }

    public void setFpFault(Integer fpFault) {
        this.fpFault = fpFault;
    }

    public Integer getChiSwichStatus() {
        return chiSwichStatus;
    }

    public void setChiSwichStatus(Integer chiSwichStatus) {
        this.chiSwichStatus = chiSwichStatus;
    }

    public Integer getChiSwichFailure() {
        return chiSwichFailure;
    }

    public void setChiSwichFailure(Integer chiSwichFailure) {
        this.chiSwichFailure = chiSwichFailure;
    }

    public Integer getCpSwichStatus() {
        return cpSwichStatus;
    }

    public void setCpSwichStatus(Integer cpSwichStatus) {
        this.cpSwichStatus = cpSwichStatus;
    }

    public Integer getCpSwichFailure() {
        return cpSwichFailure;
    }

    public void setCpSwichFailure(Integer cpSwichFailure) {
        this.cpSwichFailure = cpSwichFailure;
    }
}
