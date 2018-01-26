package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.EnjEdit;
import org.maker.pojo.Jape;
import org.maker.pojo.Japediscusss;
import org.maker.service.JapeService;
import org.maker.service.PhotoService;
import org.maker.util.Up;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class WJapeController {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private JapeService japeService;

    @RequestMapping(value = "/getJape")
    public String home( HttpServletRequest req) {
        System.out.println("跳转页面");
        List<EnjEdit> trees =photoService.queryEdit("24");
        req.setAttribute("tr",trees);

        return "wyb/japeList";
    }

    @RequestMapping("/queryJapepage")
    @ResponseBody
    public JSONObject queryJape(@RequestParam(value="id")String id, @RequestParam(value="page")int page, @RequestParam(value="rows") int rows){
        if(id.equals("32")){
            id="";
        }
        JSONObject  list=japeService.queryJape(id,page,rows);
        return list;
    }

    @RequestMapping("/queryJapeDiscuess")
    @ResponseBody
    public JSONObject queryJapeDiscuess(Japediscusss dis, @RequestParam(value="page")int page, @RequestParam(value="rows") int rows){

        JSONObject  list=japeService.queryJapeDiscuess(dis,page,rows);
        return list;
    }
    @RequestMapping(value = "/getPicJape")
    public String getPicJape(Jape jape, HttpServletRequest req) {
        jape=japeService.queryJapeById(jape);
        System.out.println(jape.getUsername());
        req.setAttribute("ja",jape);
        return "wyb/japeListQuery";
    }

    @RequestMapping(value = "/getaddJape")
    public String getaddJape(String typeid,HttpServletRequest req) {
        req.setAttribute("typeid",typeid);
        return "wyb/addjape";
    }
    @RequestMapping(value = "/getDiscuess")
    public String getDiscuess(Jape jape,HttpServletRequest req) {
        req.setAttribute("ja",jape.getWybid());
        return "wyb/discuesslist";
    }
    @RequestMapping("/AddJape")
    @ResponseBody
    public Object AddJape(Jape jape,HttpSession session){
        int i=japeService.AddJape(jape,session);
        return i;
    }

    @RequestMapping("/updateWyb")
    @ResponseBody
    public Object updateWyb(Jape jape,int mark){
        if(mark==1){
            jape.setWybfist(jape.getWyblike()+1);
            jape.setWybgood(jape.getWyblikes());
        }else if(mark==2){
            jape.setWybgood(jape.getWyblike()+1);
            jape.setWybfist(jape.getWyblikes());
        }
        int i=japeService.updateWyb(jape);
        return i;
    }
     @RequestMapping("/deleteJape")
    @ResponseBody
    public Object deleteJape(Jape jape){
        int i=japeService.deleteJape(jape);
        if(i>0){
            japeService.deleteJapeDiscuess(jape);
        }
        return i;
    }
    @RequestMapping("getUpdateJape")
    public Object getUpdateJape(Jape jape,HttpServletRequest request){
        jape=japeService.queryJapeById(jape);
        request.setAttribute("j",jape);
        return "wyb/updateJape";
    }

    @RequestMapping("/updateJape")
    @ResponseBody
    public Object updateJape(Jape jape){
        int i=japeService.updateJape(jape);
        return i;
    }

    @RequestMapping("/addJapeDiscuss")
    @ResponseBody
    public Object addJapeDiscuss(Japediscusss dis,HttpSession session){

        int i=japeService.addJapeDiscuss(dis,session);
        return i;
    }
}
