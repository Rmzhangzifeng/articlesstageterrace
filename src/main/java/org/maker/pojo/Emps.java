package org.maker.pojo;

public class Emps {
    private Integer empid;

    private String empaccount;

    private String emppass;

    private String empname;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpaccount() {
        return empaccount;
    }

    public void setEmpaccount(String empaccount) {
        this.empaccount = empaccount == null ? null : empaccount.trim();
    }

    public String getEmppass() {
        return emppass;
    }

    public void setEmppass(String emppass) {
        this.emppass = emppass == null ? null : emppass.trim();
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }
}