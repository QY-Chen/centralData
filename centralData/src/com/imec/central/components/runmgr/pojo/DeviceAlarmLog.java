package com.imec.central.components.runmgr.pojo;

import java.util.Date;

/**
 * Created by shinny on 2017-07-20.
 */
public class DeviceAlarmLog {

    private Integer Id;

    private Integer DeviceId;

    private String DeviceName;

    private Date AlarmTime;

    private Date AlarmRelTime;

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

    public Date getAlarmTime() {
        return AlarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        AlarmTime = alarmTime;
    }

    public Date getAlarmRelTime() {
        return AlarmRelTime;
    }

    public void setAlarmRelTime(Date alarmRelTime) {
        AlarmRelTime = alarmRelTime;
    }

    public Integer getAlarmNum() {
        return AlarmNum;
    }

    public void setAlarmNum(Integer alarmNum) {
        AlarmNum = alarmNum;
    }

    private Integer AlarmNum;
}
