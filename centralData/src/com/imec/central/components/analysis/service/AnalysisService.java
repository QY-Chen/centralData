package com.imec.central.components.analysis.service;

import com.imec.central.components.analysis.mapper.AnalysisMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class AnalysisService {

    @Autowired
    private AnalysisMapper analysisMapper;

    //每个钟更新一次统计电量的表
    public void task(){
        List<Integer> a=analysisMapper.select_ammeter();
        for(Integer i : a){
            analysisMapper.power_statistics(i.intValue());
        }
    }
}
