package com.imec.central.components.datasearch.Service;

import javax.xml.crypto.Data;
import java.util.List;


public abstract interface SearchDataService {
    /**
     * 能耗数据查询
     */
    public abstract List energyDataSearch(Integer num, int startTime, int endTime);

    /**
     * 日志和文档查询
     */
    public Object logAndTxtSearch(Data startTime,Data endTime);





}
