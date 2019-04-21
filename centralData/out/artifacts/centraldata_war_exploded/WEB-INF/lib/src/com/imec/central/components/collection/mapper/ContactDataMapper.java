package com.imec.central.components.collection.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.collection.pojo.AllPointList;
import com.imec.central.components.collection.pojo.ContactData;
import com.imec.central.components.collection.pojo.PointDataToJson;
import com.imec.central.components.collection.pojo.PointList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@BaseMapper
public interface ContactDataMapper {
    /**
     * 加载点位信息
     */
    public List<ContactData> loadPlcPiontinfo();

    public List<ContactData> getPoint() ;

    public List<ContactData> getNeededPoint(@Param("startNum") int startNum , @Param("endNum") int endNum);

    public List<PointDataToJson> getJsonPoint(@Param("startNum") int startNum , @Param("endNum") int endNum);

    public List<PointList> getAllJsonPoint();

    public List<AllPointList> getPointNum();


}
