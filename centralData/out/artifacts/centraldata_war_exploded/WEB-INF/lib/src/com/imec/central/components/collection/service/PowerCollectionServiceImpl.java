package com.imec.central.components.collection.service;

import com.imec.central.components.collection.mapper.PowTempDataMapper;
import com.imec.central.components.collection.pojo.GateWay;
import com.imec.central.components.collection.pojo.Station;
import com.imec.commit.client.IClient;
import com.imec.commit.modbus.client.ModbusClientProxy;
import com.imec.commit.modbus.io.ModbusTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("PowCollectionService")
public class PowerCollectionServiceImpl implements PowerCollectionService{

    @Autowired
    private PowTempDataMapper powTempDataMapper;


    @Override
    public List<Station> getAllStation() {
        return powTempDataMapper.getAllStation();
    }

    @Override
    public void gatherPowTimer(){
        //获取网关信息
        GateWay gateWay = powTempDataMapper.getGateWay("ammeter");
        //获取站号信息
        List<Station> stations = powTempDataMapper.getAllStation();

        //创建Map储存采集到的结果
        Map<String,Integer> resData = new HashMap<>();
       /* //test Map
        resData.put("main_pow_spuuly1",12345);
        resData.put("main_pow_spuuly2",12345);
        resData.put("chiller_pow",12345);
        resData.put("win_pow",12345);
        resData.put("freeze_pow1",12345);
        resData.put("freeze_pow2",12345);
        resData.put("vrv_pow",12345);
        resData.put("pump_pow1",12345);
        resData.put("pump_pow2",12345);
        resData.put("tower_pow",12345);
        resData.put("light_pow",12345);
        resData.put("special_pow",12345);
        resData.put("coil_pow",12345);
        resData.put("wind_cabinet_pow",12345);
        resData.put("split_ac_pow",12345);
        resData.put("spare",12345);*/

        //设置定时任务
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        while (true) {
                            for (int i = 0 ; i<stations.size();i++){
                                    try {
                                       resData.put(stations.get(i).getMeterName(),TCPgather(stations.get(i).getStation(), gateWay.getIp(), gateWay.getPort()));
                                    } catch (Exception e1) {
                                        System.out.println("TCP协议数据采集失败");
                                        resData.put(stations.get(i).getMeterName(),-1);
                                        e1.printStackTrace();
                                    }
                            }

                            powTempDataMapper.savePow(resData);
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

    /**
     * @param datas 02031e5b495b325b6b015c014600c706300000fb05fffffcf6028c0255014ffe1ca66b
     */
    @Override
    public Integer parsePower(String datas) {
        //System.out.println(datas.length());
        //定义计数器
        int counter = 0;
        //取出站号，功能码，数据长度和校验码得到数据串
        String data= datas.substring(6,datas.length()-4);

        //假如需要后面的数据结果可以取消注释后面的代码
       /* Integer [] result = new Integer[data.length()/4];
        //将数据分割成定长的数据组
        String [] dataArr= new String[data.length()/4];
        for (int i= 0; i<data.length();i+=4){
            result[counter]= Integer.parseInt(data.substring(i,i+4),16);
            counter++;
        }*/
        //最终的数据结果
        return Integer.parseInt(data.substring(0,4),16);


    }

    @Override
    public Integer TCPgather(int station, String ip, int port){

        ModbusTransfer transfer = new ModbusTransfer();
        String cmd = transfer.returnCMD("03","0",15);
        String datas = transfer.returnSendDatas(station ,cmd);
        Integer [] data = transfer.getDataFromHexString(datas);
        ModbusClientProxy client = new ModbusClientProxy();
        String rspStr = null;
        try {
            client.Connect(ip,port);
            Integer[] rsp = client.SendReceive(data,35);
            client.Close();
            rspStr = transfer.IntegerToHexString(rsp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parsePower(rspStr);
    }

 /*   public static byte[] hexStringToByteArray(String s){
        int length = s.length();
        byte[] b = new byte[length/2];
        for (int i=0; i<length ;i++){
            //两位一组表示一个字节，把这样表示的16进制的字符还原成一个字节
            b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return new byte[0];
    }*/
}
