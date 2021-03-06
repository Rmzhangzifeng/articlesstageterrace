package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.*;
import org.maker.service.ReviewServiceYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ReviewControllerYM {

    @Autowired
    private ReviewServiceYM reviewServiceYM;

    @RequestMapping("/reviewymone")
    public String reviewym(HttpServletRequest request, Roles roles,HttpSession session){
        Users user = (Users) session.getAttribute("loginUserMsg");
        Roles roles1 = reviewServiceYM.queryRolesYM(user);
        request.setAttribute("roles2",roles1);
        return "/reym/reviewlistone";
    }
   @RequestMapping("/reviewymfour")
   public String reviewymfour(){
       return "/reym/reviewymfour";
   }
    @RequestMapping("/reviewymtow")
    public String reviewymtow(HttpSession session,HttpServletRequest request, Roles roles){
        Users user = (Users) session.getAttribute("loginUserMsg");
        Roles roles1 = reviewServiceYM.queryRolesYM(user);
        request.setAttribute("roles2",roles1);
        request.setAttribute("u",user);
        return "/reym/reviewymtow";
    }
    @RequestMapping("/reviewymfive")
    public String reviewymfive(){
        return "/reym/reviewymfive";
    }
    @RequestMapping("/reviewymthree")
    public String reviewymthree(HttpSession session,HttpServletRequest request, Roles roles){
        Users user = (Users) session.getAttribute("loginUserMsg");
        Roles roles1 = reviewServiceYM.queryRolesYM(user);
        request.setAttribute("roles2",roles1);
        return "/reym/reviewymthree";
    }
    @RequestMapping("/reviewymsix")
    public String reviewymsix(){
        return "/reym/reviewymsix";
    }
    @RequestMapping("/queryEssaytheme")
    @ResponseBody
    public Object queryEssaytheme(int page, int rows, Essaythemes essaythemes){
        if(essaythemes.getEmroles()==1 || essaythemes.getEmroles()==2){
            JSONObject json  = reviewServiceYM.queryBookPage(page,rows,essaythemes);
            return json;
        }else{
            return false;
        }
    }
   @RequestMapping("/queryEssaythemess")
   @ResponseBody
   public Object queryEssaythemess(int page, int rows, Essaythemes essaythemes){
           JSONObject json = reviewServiceYM.queryEssaythemess(page, rows, essaythemes);
           return json;
   }
    /*updateEssaytheme*/
    @RequestMapping("/updateEssaytheme")
    @ResponseBody
    public Object updateEssaytheme(Essaythemes essaythemes){
       if(essaythemes.getThemeendreview() == 1){
            essaythemes.setThemeendreview(2);
        }else if(essaythemes.getThemeendreview() == 2){
            essaythemes.setThemeendreview(3);
        }

        int mm = reviewServiceYM.updateEssaytheme(essaythemes);
        return mm;
    }
    /*updateAllStaffEssaythemeYM*/
    @RequestMapping("/updateAllStaffEssaythemeYM")
    @ResponseBody
    public Object updateAllStaffEssaythemeYM(Essaythemes essaythemes){
        if(essaythemes.getThemeendreview() == 1){
            essaythemes.setThemeendreview(2);
        }else if(essaythemes.getThemeendreview() == 2){
            essaythemes.setThemeendreview(3);
        }
        int ee = reviewServiceYM.updateAllStaffEssaythemeYM(essaythemes);
        return ee;
    }
    @RequestMapping("/queryPictheme")
    @ResponseBody
    public Object queryPictheme(int page, int rows, Picthemes picthemes){
        if(picthemes.getPicroles()==1 || picthemes.getPicroles()==2){
            JSONObject json  = reviewServiceYM.queryPictheme(page,rows,picthemes);
            return json;
        }else{
            return false;
        }

    }
    @RequestMapping("/queryPicthemess")
    @ResponseBody
    public Object queryPicthemess(int page, int rows, Picthemes picthemes){
        JSONObject json  = reviewServiceYM.queryPicthemess(page,rows,picthemes);
        return json;
    }
    @RequestMapping("/updatePicthemeYm")
    @ResponseBody
    public Object updatePicthemeYm(Picthemes picthemes){
        if(picthemes.getPicgroupreview() == 1){
            picthemes.setPicgroupreview(2);
        }else if(picthemes.getPicgroupreview() == 2){
            picthemes.setPicgroupreview(3);
        }
        System.out.println(picthemes.getPicgroupreview());
        int pp = reviewServiceYM.updatePicthemeYm(picthemes);
        return pp;
    }
    /*upStaffAllPicthemeYM*/
    @RequestMapping("/upStaffAllPicthemeYM")
    @ResponseBody
    public Object upStaffAllPicthemeYM(Picthemes picthemes){
        if(picthemes.getPicgroupreview() == 1){
            picthemes.setPicgroupreview(2);
        }else if(picthemes.getPicgroupreview() == 2){
            picthemes.setPicgroupreview(3);
        }
        int ss = reviewServiceYM.updateStaffAllPicthemeYM(picthemes);
        return ss;
    }
    @RequestMapping("/queryFrequency")
    @ResponseBody
    public Object queryFrequency(int page, int rows, Frequencys frequencys){
        if(frequencys.getFrerole()==1 || frequencys.getFrerole()==2){
            JSONObject json  = reviewServiceYM.queryFrequency(page,rows,frequencys);
            return json;
        }else{
            return false;
        }

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
        }else if(frequencys.getFrequencyreview() == 2){
            frequencys.setFrequencyreview(3);
        }
        int ff = reviewServiceYM.updateFrequencyYm(frequencys);
        return ff;
    }

    @RequestMapping("/updateAllStaffFrequencyYM")
    @ResponseBody
    public Object updateStaffAllFrequencyYM(Frequencys frequencys){
        if(frequencys.getFrequencyreview() == 1){
            frequencys.setFrequencyreview(2);
        }else if(frequencys.getFrequencyreview() == 2){
            frequencys.setFrequencyreview(3);
        }
        int dd = reviewServiceYM.updateAllStaffFrequencyYM(frequencys);
        return dd;
    }
    @RequestMapping("getMessager")
    public String getMessager(Picthemes pic,HttpServletRequest req){
        req.setAttribute("p",pic);
        return "wyb/userrole/messagerAdd";
    }

    @RequestMapping("/addMessager")
    @ResponseBody
    public Object addMessager(Messagers messagers,HttpSession session){
        Users user=(Users) session.getAttribute("loginUserMsg");
        messagers.setMessageexpeditername(user.getUsername());
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        messagers.setMessagerdate(sim.format(new Date()));
        int dd = reviewServiceYM.addMessager(messagers);
        if(dd>0){
            reviewServiceYM.updateMessager(messagers);
        }
        return dd;
    }
}
