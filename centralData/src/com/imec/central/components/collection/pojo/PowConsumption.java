package com.imec.central.components.collection.pojo;
//能耗
import java.util.Date;

/**
 * 同种能耗数据
 */

public class PowConsumption {
    private  Integer id;
    private  Integer num;
    private String name;
    private Integer value;
    private Date time ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
