package com.imec.central.components.runmgr.pojo;

/**
 * Created by shinny on 2017-07-21.
 */
public class DeviceInfo {

    private Integer Id;
    private String DeviceName;
    private Integer DeviceType;
    private String Ip;
    /// <summary>
    /// 使用次数
    /// </summary>
    private Integer UsedNum;
    /// <summary>
    /// 总的使用次数
    /// </summary>
    private Integer UsedTotalNum;
    /// <summary>
    /// 使用时长
    /// </summary>
    private double UsedTime;
    /// <summary>
    /// 总的使用时长
    /// </summary>
    private double UsedTotalTime;
    private String AlarmR;
    private Integer AlarmState;
    private String RunR;
    private Integer RunState;
    /// <summary>
    /// 报警次数
    /// </summary>
    private Integer AlarmNum;
    /// <summary>
    /// 设备维护显示类型，1：显示次数，2：显示时间
    /// </summary>
    private Integer ShowType;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public Integer getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(Integer deviceType) {
        DeviceType = deviceType;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public Integer getUsedNum() {
        return UsedNum;
    }

    public void setUsedNum(Integer usedNum) {
        UsedNum = usedNum;
    }

    public Integer getUsedTotalNum() {
        return UsedTotalNum;
    }

    public void setUsedTotalNum(Integer usedTotalNum) {
        UsedTotalNum = usedTotalNum;
    }

    public double getUsedTime() {
        return UsedTime;
    }

    public void setUsedTime(double usedTime) {
        UsedTime = usedTime;
    }

    public double getUsedTotalTime() {
        return UsedTotalTime;
    }

    public void setUsedTotalTime(double usedTotalTime) {
        UsedTotalTime = usedTotalTime;
    }

    public String getAlarmR() {
        return AlarmR;
    }

    public void setAlarmR(String alarmR) {
        AlarmR = alarmR;
    }

    public Integer getAlarmState() {
        return AlarmState;
    }

    public void setAlarmState(Integer alarmState) {
        AlarmState = alarmState;
    }

    public String getRunR() {
        return RunR;
    }

    public void setRunR(String runR) {
        RunR = runR;
    }

    public Integer getRunState() {
        return RunState;
    }

    public void setRunState(Integer runState) {
        RunState = runState;
    }

    public Integer getAlarmNum() {
        return AlarmNum;
    }

    public void setAlarmNum(Integer alarmNum) {
        AlarmNum = alarmNum;
    }

    public Integer getShowType() {
        return ShowType;
    }

    public void setShowType(Integer showType) {
        ShowType = showType;
    }

    public Integer getTranSet() {
        return TranSet;
    }

    public void setTranSet(Integer tranSet) {
        TranSet = tranSet;
    }

    /// <summary>
    /// 维护设定
    /// </summary>
    private Integer TranSet;
}
