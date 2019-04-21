package com.imec.central.components.device.mapper.pojo;

import java.util.Date;

public class DeviceAlarmlog {

	private Integer Id;
	private Integer deviceId;
	private String deviceName;
	private Date alarmTime;
	private Date alarmRelTime;
	private Integer alarmNum;
	private Integer buildId;

	public void setId (Integer Id){
		this.Id = Id;
	}
	public Integer getId (){
		return this.Id;
	}
	public void setDeviceId (Integer deviceId){
		this.deviceId = deviceId;
	}
	public Integer getDeviceId (){
		return this.deviceId;
	}
	public void setDeviceName (String deviceName){
		this.deviceName = deviceName;
	}
	public String getDeviceName (){
		return this.deviceName;
	}
	public void setAlarmTime (Date alarmTime){
		this.alarmTime = alarmTime;
	}
	public Date getAlarmTime (){
		return this.alarmTime;
	}
	public void setAlarmRelTime (Date alarmRelTime){
		this.alarmRelTime = alarmRelTime;
	}
	public Date getAlarmRelTime (){
		return this.alarmRelTime;
	}
	public void setAlarmNum (Integer alarmNum){
		this.alarmNum = alarmNum;
	}
	public Integer getAlarmNum (){
		return this.alarmNum;
	}
	public void setBuildId (Integer buildId){
		this.buildId = buildId;
	}
	public Integer getBuildId (){
		return this.buildId;
	}


}
