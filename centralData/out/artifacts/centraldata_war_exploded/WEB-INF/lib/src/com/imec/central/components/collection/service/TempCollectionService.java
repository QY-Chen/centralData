package com.imec.central.components.collection.service;

import scala.tools.cmd.gen.AnyVals;

import java.io.IOException;

public interface TempCollectionService {

    /**
     * 空调数据读取
     */
    public Integer tempGather(String EUI, String ip, Integer port) throws IOException;

    /**
     * 数据解析存储
     * @param rspStr
     */
    public Integer parse(String rspStr);

    /**
     * 设置定时任务
     */
    public void tempGatherTimer();


}
