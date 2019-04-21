package com.imec.central.components.loadinfo.service;


import com.imec.central.components.collection.mapper.ChillerDataMapper;
import com.imec.central.components.collection.mapper.CoolingPumpDataMapper;
import com.imec.central.components.collection.mapper.CoolingTowerDataMapper;
import com.imec.central.components.collection.mapper.FreezingPumpDataMapper;
import com.imec.central.components.loadinfo.mapper.LoadColsSourceMapper;
import com.imec.central.components.loadinfo.mapper.LoadUserInfoMapper;
import com.imec.central.components.loadinfo.pojo.DisplayAcTerminalData;
import com.imec.central.components.loadinfo.pojo.DisplayCsData;
import com.imec.central.components.loadinfo.pojo.UserInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("loadDataService")
public class LoadDataServiceImpl implements LoadDataService {

    @Autowired
    private LoadColsSourceMapper loadColsSourceMapper;
    @Autowired
    private ChillerDataMapper chillerDataMapper;
    @Autowired
    private CoolingTowerDataMapper coolingTowerDataMapper;
    @Autowired
    private CoolingPumpDataMapper coolingPumpDataMapper;
    @Autowired
    private FreezingPumpDataMapper freezingPumpDataMapper;
    @Autowired
    private LoadUserInfoMapper loadUserInfoMapper;

    @Override
    public List<DisplayCsData> loadCsData(Integer cpNum,Integer ctNum,Integer fpNum){
        return loadColsSourceMapper.laodColdSourcedata( cpNum, ctNum, fpNum);
    }

    @Override
    public List<DisplayAcTerminalData> loadActData(){
        return loadColsSourceMapper.loadActerminalData();
    }

    @Override
    public Map queryCurrentChiData(int deviceNum){
        return chillerDataMapper.queryChillerData(deviceNum);
    }


    @Override
    public Map queryCurrentFPData(int deviceNum){
        return freezingPumpDataMapper.queryFreezPumpById(deviceNum);
    }


    @Override
    public Map queryCurrentCPData(int deviceNum){
        return coolingPumpDataMapper.queryCoolPumpById(deviceNum);
    }


    @Override
    public Map queryCurrentCTData(int deviceNum){
        return coolingTowerDataMapper.queryCoolTowerById(deviceNum);
        }

    @Override
    public List<UserInfoData> allUser(){return loadUserInfoMapper.getAllDataForJSON();}


}
