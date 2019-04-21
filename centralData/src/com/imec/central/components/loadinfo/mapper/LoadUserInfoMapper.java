package com.imec.central.components.loadinfo.mapper;

import com.imec.central.api.mapper.BaseMapper;
import com.imec.central.components.loadinfo.pojo.UserInfoData;

import java.util.List;

@BaseMapper
public interface LoadUserInfoMapper {

    /**
     *获取所有用户信息
     * 使用json加载到前端
     */
    public List<UserInfoData> getAllDataForJSON();

}
