package com.imec.central.components.collection.service;

import com.alibaba.fastjson.JSON;
import com.imec.central.components.collection.mapper.*;
import com.imec.central.components.collection.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.reflect.runtime.SynchronizedSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("DataCollectionService")
public class DataCollectionServiceImpl implements DataCollectionService {
    @Autowired
    private ContactDataMapper contactDataMapper;
    @Autowired
    private CoolingPumpDataMapper coolingPumpDataMapper;
    @Autowired
    private ChillerDataMapper chillerDataMapper;
    @Autowired
    private FreezingPumpDataMapper freezingPumpDataMapper;
    @Autowired
    private CoolingTowerDataMapper coolingTowerDataMapper;
    @Autowired
    private ValveMapper valveMapper;
    @Autowired
    private PressurePointMapper pressurePointMapper;
    @Autowired
    private OthersDataMapper othersDataMapper;
    @Autowired
    private  AllDatasMapper allDatasMapper;

    @Override
    public List<ContactData> getPoint(){

        return contactDataMapper.getPoint();
    }
    @Override
    public List<ContactData> getNeededPoint(int startNum,int endNum){

      return contactDataMapper.getNeededPoint(startNum, endNum) ;
    }

    @Override
    public void addChillerData(List<ContactData> list,int startNum,int endNum){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (true) {
                            chillerDataMapper.addChillerData(dataCollection(list, startNum, endNum));
                            // Set the time interval
                            TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

   @Override
    public void addFreezPumpData(List<ContactData> list,int startNum,int endNum){
       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
              synchronized (this) {
                  try {
                      while (true) {
                          freezingPumpDataMapper.addFreezPumpData(dataCollection(list, startNum, endNum));
                          // Set the time interval
                          TimeUnit.MINUTES.sleep(3);

                      }
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
               }
       });
       thread.start();
   }

    @Override
    public void addCoolPumpData(List<ContactData> list,int startNum,int endNum){
    Thread thread= new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    while (true) {
                        coolingPumpDataMapper.addCoolPumpData(dataCollection(list, startNum, endNum));
                        // set the time interval
                        TimeUnit.MINUTES.sleep(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    thread.start();
    }

    @Override
    public void addCoolTowerData(List<ContactData> list,int startNum,int endNum){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (true){
                            coolingTowerDataMapper.addCoolTowerData(dataCollection(list,startNum,endNum));
                            //set the time interval
                            TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
    }

    @Override
    public void addValveData(List<ContactData>list ,int startNum ,int endNum){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try{
                        while (true){
                           valveMapper.addValveData(dataCollection(list,startNum,endNum));
                           TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public void addPressureData(List<ContactData> list ,int startNum,int endNum){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (true){
                            pressurePointMapper.addPressureData(dataCollection(list,startNum,endNum));
                            TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

    }

    @Override
    public void addOthersData(List<ContactData> list ,int startNum , int endNum){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (true){
                            othersDataMapper.addOthersData(dataCollection(list,startNum,endNum));
                            TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    @Override
    public void addAllDatas(){
        //获取PLC的点位信息
        List<PointList> pointDataToJsons = contactDataMapper.getAllJsonPoint();

        //拼接表头
        List<AllPointList> numInfo =contactDataMapper.getPointNum();

        //构造读取实体数据的key
        //有两个特殊的点19380 和19420
        List key = new ArrayList();
        for (int j =0 ;j< numInfo.size();j++){

            //R 点
            if (numInfo.get(j).getPoint().length()<5){
                key.add(numInfo.get(j).getPoint());
                continue;
            }else if(numInfo.get(j).getPoint().equals("19380") || numInfo.get(j).getPoint().equals("19420") ){
                //除去两个特殊点
                key.add(numInfo.get(j).getPoint());
                continue;
            }

            //DT点
            key.add(numInfo.get(j).getPoint().substring(2));

        }

        /*for (int index=0;index<key.size();index++){
            System.out.println("------------"+numInfo.get(index).getPoint()+"--"+numInfo.get(index).getPoint().length()+"--"+key.get(index)+"-------");
        }*/

        String pointList =parseToJson(pointDataToJsons);
        //System.out.println(pointList);
        //定时采集PLC数据
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (true){
                            JsonData jsonData= null;
                            try {

                                jsonData = getJsonResult(pointList);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            Map<String ,String> result = new HashMap<>();
                            for (int i= 0; i<pointDataToJsons.size();i++){
                                try {
                                    //result.put(numInfo.get(i).getNum(),                                                      //点位
                                    //        jsonData.getDataMap().get(numInfo.get(i).getPoint()).getPointData().getValue());   //数据*/
                                    result.put(numInfo.get(i).getNum(),                                                      //点位
                                            jsonData.getDataMap().get(key.get(i)).getPointData().getValue());   //数据*/
                                }catch (NullPointerException e){
                                    System.out.println("服务器数据采集异常！，需要重新启动服务器采集模块！！！！");
                                }
                            }
                            //数据解析
                            //1007 代表所有数据
                            Map finallResult = converter(result,1007);

                            allDatasMapper.AddAllDatas(finallResult);

                            TimeUnit.MINUTES.sleep(3);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        }

    @Override
    public Map dataCollection(List<ContactData> list,int startNum,int endNum){
        //获取PLC的点位信息
        List<PointDataToJson> pointDataToJsons = contactDataMapper.getJsonPoint(startNum, endNum);
        //将返回的点位信息的LIST解析成JSO
        String pointList =parseToJson(pointDataToJsons);
        //System.out.println(pointList);
        //采集PLC数据
        JsonData jsonData= null;
        try {

            jsonData = getJsonResult(pointList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        List columnList = new ArrayList();
        for (int i= 0; i<list.size();i++){

            columnList.add(list.get(i).getName());

        }
        //进行数据 拼装
        Map<String,String> map = new HashMap<>();

        for (int i =0; i<list.size();i++){
            try {
                map.put(columnList.get(i).toString(), jsonData.getDataMap().get(list.get(i).getDeviceNum()).getPointData().getValue().toString());
            // System.out.println(list.get(i).getDeviceNum());
            //System.out.println("!!!!!!!!"+jsonData.getDataMap().get(list.get(i).getDeviceNum()).getPointData().getValue());
            //System.out.println("1111111111111111111111");
            }catch (NullPointerException e){
                System.out.println("数据库DT点或者R点位配置不正确");
                e.printStackTrace();
            }

        }

        return converter(map,startNum);
    }

    /**
     * R点只有两种状态0/1
     * 此外的为需要解析的16进制数
     */
    @Override
    public  Map converter(Map<String,String > map,int startnum){
        Map<String ,Object > finalResult = new HashMap<>();
        for(Map.Entry<String ,String> entry:map.entrySet()){
            //如果诗句为0或者1 则为开关机数据，不需要解析
            if (entry.getValue().equals("0") || entry.getValue().equals("1") ){

                finalResult.put(entry.getKey(),entry.getValue());
                System.out.println(entry.getValue()+"%%%%%%%%%%%%%%%%"+entry.getKey());
                continue;
            }
            //解析设备运行状态数据
            System.out.println(entry.getValue()+"##################"+entry.getKey());

            finalResult.put(entry.getKey(),Integer.parseInt(hAndLBitConvert(entry.getValue()),16));

        }
        //添加设备编号
        if (startnum == 10101){
            finalResult.put("deviceNum",101);
        }else if (startnum == 10201){
            finalResult.put("deviceNum",102);
        }else if (startnum==20101){
            finalResult.put("deviceNum",201);
        }else if (startnum == 20201){
            finalResult.put("deviceNum",201);
        }else if (startnum == 30101){
            finalResult.put("deviceNum",301);
        }else if(startnum == 30201){
            finalResult.put("deviceNum",302);
        }else if (startnum==40101){
            finalResult.put("deviceNum",401);
        }else if (startnum==50101){
           finalResult.put("deviceNum",501);
        }else if (startnum==50201){
        finalResult.put("deviceNum",502);
        //点位信息中没有，暂时补0 后续待定
        finalResult.put("coolFlowSwitch",0);
        finalResult.put("coolSwitchFail",0);
        }else if (startnum==60101){
        finalResult.put("deviceNum",601);
        }
        return finalResult;
    }

    public JsonData getJsonResult(String pointList){

        String resultJson = sendPost("http://10.5.0.73:8080/plcweb/plcController/realtimeRead",
                "{\"station\":{\"type\":null,\"code\":\"192.168.10.34-9094-01\"},"  +
                        "\"pointList\":"+pointList+"," +
                        "\"sectionList\":[]," +
                        "\"time\":1490785856," +
                        "\"agent\":null,\"" +
                        "requestType\":2}");
        //将读取回来的JSON数据解析成实体类

        JsonData jsonData = JSON.parseObject(resultJson, JsonData.class);

        return jsonData;
    }


    public  static String sendPost(String url,String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
    *解析成JSON
     * */
    public static <T> String parseToJson(T object){
        return JSON.toJSONString(object);
    }


    /**
     * 转换高低位
     */
     public String hAndLBitConvert(String oriString){
        try {

            //System.out.println(oriString+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            String high = oriString.substring(2,oriString.length());
            String low = oriString.substring(0,2);
            return high+low;
        }catch (IndexOutOfBoundsException e){
            System.out.println("数据源为空");
        }
        return "";
     }



}
