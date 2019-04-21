package com.imec.central.components.datasearch.Service;

import com.imec.central.components.collection.mapper.ChillerDataMapper;
import com.imec.central.components.collection.mapper.CoolingPumpDataMapper;
import com.imec.central.components.collection.pojo.ChillerData;
import com.imec.central.components.collection.pojo.CoolingPumpData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service("SearchDataService")
public class SearchDataServiceImpl implements SearchDataService {

    @Autowired
    private CoolingPumpDataMapper coolingPumpDataMapper;
    @Autowired
    private ChillerDataMapper chillerDataMapper;

    @Override
    public List energyDataSearch(Integer num, int startTime, int endTime){
        List<ChillerData> list = chillerDataMapper.queryByNum(num);
      return list;
  }

    @Override
    public Object logAndTxtSearch(Data startTime,Data endTime){
        return "text";
    }
}
