package com.imec.central.components.datasearch.mapper;

import com.imec.central.api.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

@BaseMapper
public interface DataSearchMapper {
    /**
     * 能耗数据查询
     */
    @Select("select * from ? where num=#{num}")
    public Object energyDataSearch(int num);

}
