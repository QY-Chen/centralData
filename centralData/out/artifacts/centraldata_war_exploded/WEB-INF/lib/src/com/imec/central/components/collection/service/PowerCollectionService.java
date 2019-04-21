package com.imec.central.components.collection.service;

import com.imec.central.components.collection.pojo.Station;

import java.io.IOException;
import java.util.List;

public interface PowerCollectionService {

    /**
     * 获取电表站号和名称信息
     */
    public List<Station> getAllStation();
    /**
     * 设置定时数据采集
     */
     public void gatherPowTimer();
    /**
     * 数据解析打包
     */
    public Integer parsePower(String datas);

    /**
     * Tcp协议数据采集
     */
    public Integer TCPgather(int station,String ip,int port);


}
