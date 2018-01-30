package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Frequencys;
import org.maker.pojo.Picthemes;
import org.maker.service.ReviewServiceYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewControllerYM {

    @Autowired
    private ReviewServiceYM reviewServiceYM;

    @RequestMapping("/reviewymone")
    public String reviewym(){
        return "/reym/reviewlistone";
    }
   @RequestMapping("/reviewymfour")
   public String reviewymfour(){
       return "/reym/reviewymfour";
   }
    @RequestMapping("/reviewymtow")
    public String reviewymtow(){
        return "/reym/reviewymtow";
    }
    @RequestMapping("/reviewymfive")
    public String reviewymfive(){
        return "/reym/reviewymfive";
    }
    @RequestMapping("/reviewymthree")
    public String reviewymthree(){
        return "/reym/reviewymthree";
    }
    @RequestMapping("/reviewymsix")
    public String reviewymsix(){
        return "/reym/reviewymsix";
    }
    @RequestMapping("/queryEssaytheme")
    @ResponseBody
    public Object queryEssaytheme(int page, int rows, Essaythemes essaythemes){
        JSONObject json  = reviewServiceYM.queryBookPage(page,rows,essaythemes);
        return json;
    }
   @RequestMapping("/queryEssaythemess")
   @ResponseBody
   public Object queryEssaythemess(int page, int rows, Essaythemes essaythemes){
       JSONObject json  = reviewServiceYM.queryEssaythemess(page,rows,essaythemes);
       return json;
   }
    /*updateEssaytheme*/
    @RequestMapping("/updateEssaytheme")
    @ResponseBody
    public Object updateEssaytheme(Essaythemes essaythemes){
        if(essaythemes.getThemeendreview() == 1){
            essaythemes.setThemeendreview(2);
        }
        int mm = reviewServiceYM.updateEssaytheme(essaythemes);
        return mm;
    }
    /*updateAllStaffEssaythemeYM*/
    @RequestMapping("/updateAllStaffEssaythemeYM")
    @ResponseBody
    public Object updateAllStaffEssaythemeYM(Essaythemes essaythemes){
        int ee = reviewServiceYM.updateAllStaffEssaythemeYM(essaythemes);
        return ee;
    }
    @RequestMapping("/queryPictheme")
    @ResponseBody
    public Object queryPictheme(int page, int rows, Picthemes picthemes){
        JSONObject json  = reviewServiceYM.queryPictheme(page,rows, picthemes);
        return json;
    }
    @RequestMapping("/queryPicthemess")
    @ResponseBody
    public Object queryPicthemess(int page, int rows, Picthemes picthemes){
        JSONObject json  = reviewServiceYM.queryPicthemess(page,rows, picthemes);
        return json;
    }
    @RequestMapping("/updatePicthemeYm")
    @ResponseBody
    public Object updatePicthemeYm(Picthemes picthemes){
        if(picthemes.getPicgroupreview() == 1){
            picthemes.setPicgroupreview(2);
        }
        int pp = reviewServiceYM.updatePicthemeYm(picthemes);
        return pp;
    }
    /*upStaffAllPicthemeYM*/
    @RequestMapping("/upStaffAllPicthemeYM")
    @ResponseBody
    public Object upStaffAllPicthemeYM(Picthemes picthemes){
        int ss = reviewServiceYM.updateStaffAllPicthemeYM(picthemes);
        return ss;
    }
    @RequestMapping("/queryFrequency")
    @ResponseBody
    public Object queryFrequency(int page, int rows, Frequencys frequencys){
        JSONObject json  = reviewServiceYM.queryFrequency(page,rows,frequencys);
        return json;
    }
    @RequestMapping("/queryFrequencyss")
    @ResponseBody
    public Object queryFrequencyss(int page, int rows, Frequencys frequencys){
        JSONObject json  = reviewServiceYM.queryFrequencyss(page,rows,frequencys);
        return json;
    }
    @RequestMapping("/updateFrequencyYm")
    @ResponseBody
    public Object updateFrequencyYm(Frequencys frequencys){
        if(frequencys.getFrequencyreview() == 1){
            frequencys.setFrequencyreview(2);
        }
        int ff = reviewServiceYM.updateFrequencyYm(frequencys);
        return ff;
    }

    @RequestMapping("/updateAllStaffFrequencyYM")
    @ResponseBody
    public Object updateStaffAllFrequencyYM(Frequencys frequencys){
        int dd = reviewServiceYM.updateAllStaffFrequencyYM(frequencys);
        return dd;
    }
}
