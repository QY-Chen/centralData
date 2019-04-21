package com.imec.central.components.runmgr.pojo;

/**
 * Created by shinny on 2017-07-21.
 */
public class BuildInfo {
    private Integer Id;
    private String BuildName;
    private String IP;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBuildName() {
        return BuildName;
    }

    public void setBuildName(String buildName) {
        BuildName = buildName;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    private String Remark;
}
