package com.imec.central.mvc.controllers.loadinfo;


import com.imec.central.components.loadinfo.pojo.UserInfoData;
import com.imec.central.components.loadinfo.service.LoadDataService;
import com.imec.central.util.JsonConvert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping({"/userLoad"})
public class LoadUserInfoController {

    @Resource
    private LoadDataService loadDataService;

    @RequestMapping("info")
    @ResponseBody
    public Object userDataJson(){
        Map<String ,Object> userJson = new HashMap<>();
        userJson.put("code",0);                         //状态码
        userJson.put("msg","");                         //信息
        userJson.put("count",2);                        //数据数量
        List<UserInfoData> userList =loadDataService.allUser();
        userJson.put("data",userList); //用户信息
        System.out.println(JsonConvert.parseToJson(userJson));
        return JsonConvert.parseToJson(userJson);
        }


}
