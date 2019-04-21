package com.imec.central.components.runmgr.pojo;

import java.io.Serializable;

/**
 * Created by shinny on 2017-07-18.
 */
public class PlcRunLogConfig implements Serializable {

    private Integer Id;

    private String Name;

    private String Addr;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public double getTranVal() {
        return TranVal;
    }

    public void setTranVal(double tranVal) {
        TranVal = tranVal;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    private double TranVal;

    private String Ip;
}
