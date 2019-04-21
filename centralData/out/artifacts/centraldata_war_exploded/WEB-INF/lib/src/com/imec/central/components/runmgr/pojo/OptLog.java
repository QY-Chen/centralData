package com.imec.central.components.runmgr.pojo;

import java.util.Date;

/**
 * Created by shinny on 2017-07-21.
 */
public class OptLog {

    private Long ID;

    private String UserID;

    private Date RecordTime;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public Date getRecordTime() {
        return RecordTime;
    }

    public void setRecordTime(Date recordTime) {
        RecordTime = recordTime;
    }

    public String getEventmsg() {
        return Eventmsg;
    }

    public void setEventmsg(String eventmsg) {
        Eventmsg = eventmsg;
    }

    private String Eventmsg;
}
