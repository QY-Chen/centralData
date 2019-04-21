package com.imec.central.components.collection.pojo;

public class MapData {
    private  long time;
    private  int status;
    private  PointData pointData;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PointData getPointData() {
        return pointData;
    }

    public void setPointData(PointData pointData) {
        this.pointData = pointData;
    }
}
