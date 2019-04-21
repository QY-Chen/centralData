package com.imec.central.api.parameters;

import java.util.Date;

/**
 * Created by shinny on 2017-07-18.
 */
public class EcParameter {
    private String infoTable;
    private String dataTable;
    private String dateSize;
    private String childDateSize;
    private String date;
    private String key;
    private String sWhere;
    private String sJoin;
    private String eId;
    private Boolean usePeriod = Boolean.valueOf(false);
    private Date fromDate;
    private Date toDate;
    private Integer limit;
    private Integer offset = Integer.valueOf(0);
    private Boolean desc = Boolean.valueOf(true);
    private String orderBy;//用于用哪个字段来排序
    private String startDate;
    private String endDate;
    private String parentId;
    private String parentField;
    private Integer year ;
    private Integer month ;
    private Integer day ;
    private String timeType ;
    private Double value;

    public String getInfoTable() {
        return infoTable;
    }

    public void setInfoTable(String infoTable) {
        this.infoTable = infoTable;
    }

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable;
    }

    public String getDateSize() {
        return dateSize;
    }

    public void setDateSize(String dateSize) {
        this.dateSize = dateSize;
    }

    public String getChildDateSize() {
        return childDateSize;
    }

    public void setChildDateSize(String childDateSize) {
        this.childDateSize = childDateSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getsWhere() {
        return sWhere;
    }

    public void setsWhere(String sWhere) {
        this.sWhere = sWhere;
    }

    public String getsJoin() {
        return sJoin;
    }

    public void setsJoin(String sJoin) {
        this.sJoin = sJoin;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public Boolean getUsePeriod() {
        return usePeriod;
    }

    public void setUsePeriod(Boolean usePeriod) {
        this.usePeriod = usePeriod;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentField() {
        return parentField;
    }

    public void setParentField(String parentField) {
        this.parentField = parentField;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    private Integer buildId;
}
