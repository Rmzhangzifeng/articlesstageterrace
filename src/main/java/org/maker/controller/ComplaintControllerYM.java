package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Complaints;
import org.maker.service.ComplaintServiceYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ComplaintControllerYM {
   /* /*/
   @Autowired
   private ComplaintServiceYM complaintServiceYM;

    @RequestMapping("/complaintseven")
    public String reviewym(){
        return "/cpym/complaintseven";
    }
   /* complaintnine*/
   @RequestMapping("/complaintnine")
   public String complaintnine(){
       return "/cpym/complaintnine";
   }
   @RequestMapping("/queryComplaint")
   @ResponseBody
   public Object queryComplaint(int page, int rows, Complaints complaints){
       JSONObject json  = complaintServiceYM.queryComplaint(page,rows,complaints);
       return json;
   }
    /*toaddformYM*/
    @RequestMapping("/toaddformYM")
    public Object toaddformYM(){
        return "/cpym/toaddcomplainteight";
    }
   /* updateSevenYM*/
   @RequestMapping("/updateSevenYM")
   @ResponseBody
   public Object updateSevenYM(Complaints complaints){
        int yy = complaintServiceYM.updateSevenYM(complaints);
       return yy;
   }
  /*  queryComplaintss*/
  @RequestMapping("/queryComplaintss")
  @ResponseBody
  public Object queryComplaintss(int page, int rows, Complaints complaints){
      JSONObject json  = complaintServiceYM.queryComplaintss(page,rows,complaints);
      return json;
  }
   /* updateAllStaffComplaintYM*/
   @RequestMapping("/updateAllStaffComplaintYM")
   @ResponseBody
   public Object updateAllStaffComplaintYM(Complaints complaints){
       int ii = complaintServiceYM.updateAllStaffComplaintYM(complaints);
       return ii;
   }

}
