package com.imec.central.mvc.controllers.search;


import com.alibaba.fastjson.JSON;
import com.imec.central.components.collection.pojo.ChillerData;
import com.imec.central.components.collection.pojo.CoolingPumpData;
import com.imec.central.components.datasearch.Service.SearchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping({"/data"})
public class DataSearchController {

    @Autowired
    private SearchDataService searchDataService;


    @RequestMapping("/index6")
//    http://localhost:8080/centraldata/data/index6
    public Object showData(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@");
        return "str";
    }

    @RequestMapping("/index9")
    public  String test1(){
        return"index2";
    }
    @RequestMapping("/index8")
    public ModelAndView test4(){
        return new ModelAndView();
    }

    /**
     *解析成JSON
     */
    public static <T> String parseToJson(T object){
        return JSON.toJSONString(object);
    }

}
