package ru.company.user;

import java.util.Date;
import java.util.List;

public class IncPojo {
    String afterDate;
    String userDetails;      // UserDetail
    String sOrder;           // IncidentPojo.SortComparator
    List<Long> systemIds;
    List<String> singletonList;
    Date onDate;
    Date onDateEnd;
    String filterType;         // FilterType
    String visibleType;        // VisibleType

    public IncPojo() {
    }

    public IncPojo(String afterDate, String userDetails, String sOrder, List<Long> systemIds, List<String> singletonList, Date onDate, Date onDateEnd, String filterType, String visibleType) {
        this.afterDate = afterDate;
        this.userDetails = userDetails;
        this.sOrder = sOrder;
        this.systemIds = systemIds;
        this.singletonList = singletonList;
        this.onDate = onDate;
        this.onDateEnd = onDateEnd;
        this.filterType = filterType;
        this.visibleType = visibleType;
    }

    public String getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(String afterDate) {
        this.afterDate = afterDate;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails;
    }

    public String getsOrder() {
        return sOrder;
    }

    public void setsOrder(String sOrder) {
        this.sOrder = sOrder;
    }

    public List<Long> getSystemIds() {
        return systemIds;
    }

    public void setSystemIds(List<Long> systemIds) {
        this.systemIds = systemIds;
    }

    public List<String> getSingletonList() {
        return singletonList;
    }

    public void setSingletonList(List<String> singletonList) {
        this.singletonList = singletonList;
    }

    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    public Date getOnDateEnd() {
        return onDateEnd;
    }

    public void setOnDateEnd(Date onDateEnd) {
        this.onDateEnd = onDateEnd;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getVisibleType() {
        return visibleType;
    }

    public void setVisibleType(String visibleType) {
        this.visibleType = visibleType;
    }
}
