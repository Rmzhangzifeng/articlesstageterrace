package org.maker.pojo;

import java.util.Date;

public class Solicitarticless {
    private Integer solicitarticlesid;

    private String solicitarticlestitle;

    private Integer userqid;

    private Date solicitarticlestime;

    private Integer gambitid;

    private String solicitarticlescover;

    public Integer getSolicitarticlesid() {
        return solicitarticlesid;
    }

    public void setSolicitarticlesid(Integer solicitarticlesid) {
        this.solicitarticlesid = solicitarticlesid;
    }

    public String getSolicitarticlestitle() {
        return solicitarticlestitle;
    }

    public void setSolicitarticlestitle(String solicitarticlestitle) {
        this.solicitarticlestitle = solicitarticlestitle == null ? null : solicitarticlestitle.trim();
    }

    public Integer getUserqid() {
        return userqid;
    }

    public void setUserqid(Integer userqid) {
        this.userqid = userqid;
    }

    public Date getSolicitarticlestime() {
        return solicitarticlestime;
    }

    public void setSolicitarticlestime(Date solicitarticlestime) {
        this.solicitarticlestime = solicitarticlestime;
    }

    public Integer getGambitid() {
        return gambitid;
    }

    public void setGambitid(Integer gambitid) {
        this.gambitid = gambitid;
    }

    public String getSolicitarticlescover() {
        return solicitarticlescover;
    }

    public void setSolicitarticlescover(String solicitarticlescover) {
        this.solicitarticlescover = solicitarticlescover == null ? null : solicitarticlescover.trim();
    }
}