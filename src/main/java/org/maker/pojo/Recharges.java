package org.maker.pojo;

import java.util.Date;

public class Recharges {
    private Integer rechargeid;

    private Integer userzid;

    private Integer withdrawmoney;

    private Integer nowstatus;

    private String receiptmessage;

    private Date receipttime;

    public Integer getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(Integer rechargeid) {
        this.rechargeid = rechargeid;
    }

    public Integer getUserzid() {
        return userzid;
    }

    public void setUserzid(Integer userzid) {
        this.userzid = userzid;
    }

    public Integer getWithdrawmoney() {
        return withdrawmoney;
    }

    public void setWithdrawmoney(Integer withdrawmoney) {
        this.withdrawmoney = withdrawmoney;
    }

    public Integer getNowstatus() {
        return nowstatus;
    }

    public void setNowstatus(Integer nowstatus) {
        this.nowstatus = nowstatus;
    }

    public String getReceiptmessage() {
        return receiptmessage;
    }

    public void setReceiptmessage(String receiptmessage) {
        this.receiptmessage = receiptmessage == null ? null : receiptmessage.trim();
    }

    public Date getReceipttime() {
        return receipttime;
    }

    public void setReceipttime(Date receipttime) {
        this.receipttime = receipttime;
    }
}