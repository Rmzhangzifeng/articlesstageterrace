package org.maker.pojo;

import java.util.Date;

public class IntegraShop {
    private Integer shopid;

    private String shopname;

    private String shopimg;

    private Integer needintegra;

    private Date startdate;

    private Date enddate;

    private Integer shopcount;

    //
    private String idStr;

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Integer getShopcount() {
        return shopcount;
    }

    public void setShopcount(Integer shopcount) {
        this.shopcount = shopcount;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getStartdate() {

        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getShopimg() {
        return shopimg;
    }

    public void setShopimg(String shopimg) {
        this.shopimg = shopimg == null ? null : shopimg.trim();
    }

    public Integer getNeedintegra() {
        return needintegra;
    }

    public void setNeedintegra(Integer needintegra) {
        this.needintegra = needintegra;
    }
}