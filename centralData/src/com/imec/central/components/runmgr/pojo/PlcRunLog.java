package com.imec.central.components.runmgr.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shinny on 2017-07-18.
 */
public class PlcRunLog implements Serializable {

    private Integer Id;//主键

    private Integer configId;//plc点位配置Id

    private String configName;//plc点位配置名称

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    private double data;//实时记录的数据

    private Date readTime;//实时记录的时间
}
