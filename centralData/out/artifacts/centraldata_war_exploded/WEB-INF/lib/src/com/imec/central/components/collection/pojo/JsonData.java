package com.imec.central.components.collection.pojo;
import  java.util.Map;
public class JsonData {
    private  long time ;
    private  int status;
    private  Map<String ,MapData> dataMap;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, MapData> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, MapData> dataMap) {
        this.dataMap = dataMap;
    }
}
