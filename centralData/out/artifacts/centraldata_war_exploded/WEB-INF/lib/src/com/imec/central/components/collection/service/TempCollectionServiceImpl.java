package com.imec.central.components.collection.service;

import com.imec.central.components.collection.mapper.PowTempDataMapper;
import com.imec.central.components.collection.pojo.GateWay;
import com.imec.commit.client.IClient;
import com.imec.commit.modbus.client.ModbusClientProxy;
import com.imec.commit.modbus.io.ModbusTransfer;
import com.imec.commit.util.CRC16;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//@Service("TempCollectionService")
@Service
public class TempCollectionServiceImpl implements TempCollectionService {

    @Autowired
    private PowTempDataMapper powTempDataMapper;

    @Override
    public Integer tempGather(String EUI, String ip, Integer port) throws IOException {

        ModbusTransfer tran = new ModbusTransfer();
        String cmd = tran.returnCMD("04", "0", 03);//03  40 //04  30
        //System.out.println(cmd);
        String datas = tran.returnSendDatas(01, cmd, EUI, "");//000D6F000A97337E
        //System.out.println(datas);

        Integer[] data = tran.getDataFromHexString(datas);// "FD1108000D6F00056464730A06000000014971"
        IClient client = new ModbusClientProxy(10 * 1000);
        client.Connect(ip, 9094);//192.168.10.188
        Integer[] rsp = client.SendReceive(data, 11);// 85 //65

        String strrsp = tran.IntegerToHexString(rsp);
        client.Close();

        return parse(strrsp);
    }

    @Override
    public Integer parse(String rspStr){
        //数据长度
        int length = rspStr.length();
        //计数器
        int counter = 0;
        //获取数据字符串
        String data = rspStr.substring(6,length-4);
        //解析成十进制数据
        Integer [] realData = new Integer[data.length()/4];
        for (int i= 0; i<data.length();i+=4){
            realData[counter]= Integer.parseInt(data.substring(i,i+4),16);
            if (realData[counter]!=0){ return realData[counter];}
            counter++;
        }

        return -1;
    }

    @Override
    public void tempGatherTimer(){
        //获取温度协调器的IP和端口
        //参数是温度或者电耗 和楼层
        //没有楼层的数据库统一存0
        //先获取三楼的IP和端口
        System.out.println("start111111111111");
       GateWay gateWay = powTempDataMapper.getGateWay("thirdFloorTemp");
       //获取3楼的EUI
        List euiList = powTempDataMapper.getEUI(3);
        //System.out.println(euiList);
        //创建一个Map，key=EUI ,value= Ip
        Map<String,String > allEUi = new HashMap<String,String>();
        for (int i = 0; i<euiList.size();i++ ){
            allEUi.put(""+euiList.get(i)+"",gateWay.getIp());
        }

        // 获取4楼的IP端口和EUI
        GateWay gateWay1 = powTempDataMapper.getGateWay("fourthFloorTemp");
        List list = powTempDataMapper.getEUI(4);
        for (int i=0;i<list.size(); i++){

            allEUi.put(""+list.get(i)+"",gateWay1.getIp());
        }

        //创建一个包含所有数据的Map KEY为EUI的后三位，value为对应的温度值
        Map result = new HashMap();
      /*  //test Map
        result.put("659",1234);
        result.put("1A0",1234);
        result.put("631",1234);
        result.put("2FA",1234);
        result.put("47F",1234);
        result.put("655",1234);
        result.put("63E",1234);
        result.put("94B",1234);
        result.put("5C1",1234);
        result.put("5F3",1234);
        result.put("3E4",1234);
        result.put("629",1234);
        result.put("657",1234);
        result.put("660",1234);
        result.put("3F4",1234);
        result.put("3AF",1234);
        result.put("647",1234);
        result.put("6B2",1234);
        result.put("2F9",1234);
        result.put("6D0",1234);
        result.put("99C",1234);
        result.put("55F",1234);
        result.put("685",1234);
        result.put("17C",1234);
        result.put("6CA",1234);
        result.put("579",1234);
        result.put("652",1234);
        result.put("98F",1234);
        result.put("66B",1234);*/

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                synchronized (this){
                    while(true){
                        //组装resultMap
                        for (Map.Entry<String,String> entry : allEUi.entrySet()){
                            //两个协调器的port是一样的
                            //取EUI的后三位作为map的key
                            //需要去出空格
                           /* System.out.println(entry.getKey().trim().length());
                            System.out.println(entry.getKey().trim().substring(entry.getKey().trim().length()-3));
                            result.put(entry.getKey().trim().substring(entry.getKey().trim().length()-3),1234);*/
                            try {
                                result.put(entry.getKey().trim().substring(entry.getKey().trim().length()-3),tempGather(entry.getKey(),entry.getValue(),gateWay.getPort()));

                            } catch (IOException e) {
                                result.put(entry.getKey().trim().substring(entry.getKey().trim().length()-3),-1);
                                System.out.println("数据地址不在线或者数据传输失败");

                            }
                        }
                        powTempDataMapper.saveTemp(result);
                        TimeUnit.MINUTES.sleep(3);
                    }
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
