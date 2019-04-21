package com.imec.central.components.device.mapper;

import java.util.List;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.device.mapper.pojo.DeviceAlarmlog;

@BaseMapper
public interface DeviceAlarmlogMapper {

	public List<DeviceAlarmlog> loadAllAlarmLogByDeviceId(DeviceAlarmlog device_alarmlog);
	public List<DeviceAlarmlog> loadAllAlarmLogByDeviceIds(List<Integer> deviceIds);

	public DeviceAlarmlog loadAlarmLogById(DeviceAlarmlog device_alarmlog);

	/**
	 * 加载正在报警的记录
     */
	public List<DeviceAlarmlog> loadAlarmingLogByDeviceId(DeviceAlarmlog device_alarmlog);
	public List<DeviceAlarmlog> loadAlarmingLogByDeviceIds(List<Integer> deviceIds);

	/**
	 * 加载报警历史记录
     */

	public List<DeviceAlarmlog> loadAlarmLogHistoryByDeviceId(DeviceAlarmlog device_alarmlog);
	public List<DeviceAlarmlog> loadAlarmLogHistoryByDeviceIds(List<Integer> deviceIds);


}
