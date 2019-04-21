package com.imec.central.components.runmgr.pojo;

import java.util.Date;

/**
 * Created by shinny on 2017-07-20.
 */
public class DeviceOptLog {

    private Integer Id;//Id,主键

    private Integer DeviceId;//设备Id

    private String DeviceName;//设备名称

    private Date OptTime;//操作时间

    private String OptName;//操作名称

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(Integer deviceId) {
        DeviceId = deviceId;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public Date getOptTime() {
        return OptTime;
    }

    public void setOptTime(Date optTime) {
        OptTime = optTime;
    }

    public String getOptName() {
        return OptName;
    }

    public void setOptName(String optName) {
        OptName = optName;
    }

    public Integer getBuildId() {
        return BuildId;
    }

    public void setBuildId(Integer buildId) {
        BuildId = buildId;
    }

    private Integer BuildId;//建筑Id
}
