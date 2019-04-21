package com.imec.central.components.loadinfo.service;

import com.imec.central.components.loadinfo.pojo.DisplayAcTerminalData;
import com.imec.central.components.loadinfo.pojo.DisplayCsData;
import com.imec.central.components.loadinfo.pojo.UserInfoData;

import java.util.List;
import java.util.Map;


public interface LoadDataService {

    /**
     *load all the displayed data for the cold source
     */
    public List<DisplayCsData> loadCsData(Integer cpNum,Integer ctNum,Integer fpNum);

    /**
     * load all the display data for the Air_condition Terminal
     */
    public List<DisplayAcTerminalData> loadActData();

    /**
     * 点击加载最新主机信息
     * @param deviceNum  设备编号
     */
    public Map queryCurrentChiData(int deviceNum);

    /**
     * 点击加载最新冷冻泵信息
     * @param deviceNum  设备编号
     */
    public Map queryCurrentFPData(int deviceNum);

    /**
     * 加载最新冷却泵信息
     * @param deviceNum
     */
    public Map queryCurrentCPData(int deviceNum);

    /**
     * 加载最新冷却塔信息
     * @param deviceNum
     */
    public Map queryCurrentCTData(int deviceNum);

    /**
     * 加载所有的用户信息
     */
    public List<UserInfoData> allUser();


}
