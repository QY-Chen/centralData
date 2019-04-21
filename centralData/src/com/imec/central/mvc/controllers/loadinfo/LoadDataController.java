package com.imec.central.mvc.controllers.loadinfo;

 import com.alibaba.fastjson.JSON;
 import com.imec.central.components.loadinfo.pojo.DisplayAcTerminalData;
 import com.imec.central.components.loadinfo.pojo.DisplayCsData;
 import com.imec.central.components.loadinfo.service.LoadDataService;
 import com.imec.central.util.JsonConvert;
 import org.apache.poi.hmef.attribute.MAPIAttribute;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.*;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

@Controller
@RequestMapping({"/loadData"})
public class LoadDataController {
    @Resource
    private LoadDataService loadDataService;


    /**
     *load the cold source data to the web page
     * return json-string
     */
    @RequestMapping("/loadColeSource")
    @ResponseBody
    public Object loadColdSource(Integer cpNum,Integer ctNum,Integer fpNum){
        List<DisplayCsData> list = loadDataService.loadCsData( cpNum, ctNum, fpNum);
        return list;
    }
    @RequestMapping("/loadAcTerminal")
    @ResponseBody
    public Object loadAcTerminal(){
        List<DisplayAcTerminalData> actlist = loadDataService.loadActData();
        return actlist ;
    }
    @RequestMapping("/chiller")
    @ResponseBody
    public Object getChillerData(@RequestParam("deviceNum") int  deviceNum){
        System.out.println("11111111111"+deviceNum);
        Map chillerMap = loadDataService.queryCurrentChiData(deviceNum);
        String  rtnStr = JsonConvert.parseToJson(chillerMap);
        return rtnStr;
    }
    @RequestMapping("/coolPump")
    @ResponseBody
    public Object getCPData(@RequestParam("deviceNum") int deviceNum){
        return JsonConvert.parseToJson(loadDataService.queryCurrentCPData(deviceNum));
    }
    @RequestMapping(value = "coolTown",
                    method = RequestMethod.POST)
    @ResponseBody
    public Object getCTData(@RequestParam("deviceNum") int deviceNum){
        return JsonConvert.parseToJson(loadDataService.queryCurrentCTData(deviceNum));
        }
    @RequestMapping("freezPump")
    @ResponseBody
    public Object getFPData(@RequestParam("deviceNum") int deviceNum){

        return JsonConvert.parseToJson(loadDataService.queryCurrentFPData(deviceNum));
    }


}
