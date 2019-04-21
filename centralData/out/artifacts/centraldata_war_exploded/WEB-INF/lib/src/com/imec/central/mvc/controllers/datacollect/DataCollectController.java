package com.imec.central.mvc.controllers.datacollect;

import com.imec.central.components.collection.pojo.ContactData;
import com.imec.central.components.collection.service.DataCollectionService;
import com.imec.central.components.collection.service.PowerCollectionService;
import com.imec.central.components.collection.service.TempCollectionService;
import com.imec.central.components.collection.service.TempCollectionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping({"/collector"})
public class DataCollectController {
    @Resource
    private DataCollectionService dataCollectionService;

    @Resource
    private TempCollectionService tempCollectionService;

    @Resource
    private PowerCollectionService powerCollectionService;


    @RequestMapping("/index0")
    public String show() {
        System.out.println("22222222222222");
        return "index";
    }

    @RequestMapping("/index1")
    public String getPoint() {
        System.out.println("开始采集数据");
       //增加冷冻主机数据
       /* List<ContactData> chilltList1 = dataCollectionService.getNeededPoint(10101,10107);
        dataCollectionService.addChillerData(chilltList1,10101,10107);
        List<ContactData> chillList2 = dataCollectionService.getNeededPoint(10201,10207);
        dataCollectionService.addChillerData(chillList2,10201,10207);
        //增加冷却泵数据
        List<ContactData> coolPum1 = dataCollectionService.getNeededPoint(30101,30110);
        dataCollectionService.addCoolPumpData(coolPum1,30101,30110);
        List<ContactData> coolPum2 = dataCollectionService.getNeededPoint(30201,30210);
        dataCollectionService.addCoolPumpData(coolPum2,30201,30210);
        //增加冷冻泵数据
        List<ContactData> freezPum1 = dataCollectionService.getNeededPoint(20101,20110);
        dataCollectionService.addFreezPumpData(freezPum1,20101,20110);
        List<ContactData> freezPum2 = dataCollectionService.getNeededPoint(20201,20210);
        dataCollectionService.addFreezPumpData(freezPum2,20201,20210);
        //增加冷却塔数据
        List<ContactData> coolTow = dataCollectionService.getNeededPoint(40101,40109);
        dataCollectionService.addCoolTowerData(coolTow,40101,40109);
*/


        //采集所有的数据
        dataCollectionService.addAllDatas();

        //采集温度数据
        //tempCollectionService.tempGatherTimer();

        //采集电表数据
       //powerCollectionService.gatherPowTimer();

        return "index";
    }

    @RequestMapping("/index2")
    public String test1(@RequestParam("id") Integer id) {

        return "index2";
    }

    @RequestMapping("/index3/{id}")
    public String test2(@PathVariable("id") Integer id) {
        return "index";
    }

    @RequestMapping("/index")
    public ModelAndView test3() {
        System.out.println("22222222222222");
        ModelAndView mv = new ModelAndView("Hello");
        mv.setViewName("index");
        mv.addObject("message", 1);
        mv.getModel().put("name", "index");
        return mv;
    }

    @RequestMapping("/index5")
    @ResponseBody
    public Object gatherPlcData(@RequestBody Object str) {
        System.out.println("1111111111111111111111111111112222222222222222");
        str = "{\"value1\":1}";
        return str;
    }


}