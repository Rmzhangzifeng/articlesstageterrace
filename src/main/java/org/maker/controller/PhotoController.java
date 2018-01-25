package org.maker.controller;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.*;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class PhotoController {

        @Autowired
        private PhotoService photoService;

        @RequestMapping("/getPhoto")
        public String getPhoto(String id, HttpServletRequest req){
            List<EnjEdit> trees =photoService.queryEdit("25");
            req.setAttribute("edit",trees);
            return "wyb/getphotos";
        }
    @RequestMapping("/getqueryPicreview")
    public String getqueryPicreview(Picgroup pic,HttpServletRequest req){
        req.setAttribute("pic",pic.getPicorganizeid());
        return "wyb/picreviewlist";
    }
        @RequestMapping("/getPicPhoto")
        public String getPicPhoto(){
            return "wyb/getPicphotos";
        }

        @RequestMapping("/getPicPhotos")
        public String getPicPhotos(){
        return "wyb/getPicphoto";
    }

    @RequestMapping("/getPicPhotoById")
    public String getPicPhotoById(Picgroup id,HttpServletRequest req){
            List<Picphoto> list=photoService.queryPicGroupByIds(id);
            req.setAttribute("list",list);
            req.setAttribute("id",id.getPicorganizeid());
            return "wyb/getPicPhotoById";
    }

    @RequestMapping("/getPhotoQueryById")
    public String getPhotoQueryById(Picgroup id,HttpServletRequest req){
        Picgroup id1=photoService.queryPicGoup(id);
        List<Picphoto> list=photoService.queryPicGroupByIds(id1);
        req.setAttribute("group",id1);
        req.setAttribute("photo",list);
        return "wyb/getPhotoQueryById";
    }
        @RequestMapping("/queryPic")
        @ResponseBody
        public JSONObject queryPic(@RequestParam(value="id")String id, @RequestParam(value="page")int page, @RequestParam(value="rows") int rows){
            JSONObject  list=photoService.queryPic(id,page,rows);
            return list;
        }
    @RequestMapping(value="uploadPhotoFile")
    @ResponseBody
    public String  uploadPhotoFile(MultipartFile artImg, HttpServletRequest req) throws IOException {
        String upImag1 = Up.upImag1(artImg, req);
        return upImag1;
    }

    @RequestMapping("/AddPicPhoto")
    @ResponseBody
    public Object AddPicPhoto(Picphoto po){
        int i=photoService.AddPicPhoto(po);
        Picphoto pp=new Picphoto();
        if(i>0){
            pp=photoService.queryPicPhotos(po);
        }
        return pp.getPicphotoid();
    }

    @RequestMapping("/AddPicGroup")
    @ResponseBody
    public Object AddPicGroup(Picgroup group, HttpServletRequest req){

        int i=photoService.AddPicGroup(group);
        Picgroup group1=new Picgroup();

        if(i>0){
            group1=photoService.queryPicGoup(group);
            Pictheme pic=new Pictheme();
            System.out.println(group1.getPicorganizeid());
            pic.setPicgroupid(group1.getPicorganizeid());
            pic.setPictypeid(group.getTypeid());
            pic.setPicgrouptitle(group.getPicgrouptitle());
            int j=photoService.addWybPictheme(pic);
        }
        return i;
    }

    @RequestMapping("/UpdateGroupById")
    @ResponseBody
    public Object UpdateGroupById(Picgroup group){
        int i=photoService.UpdateGroupById(group);
        return i;
    }

    @RequestMapping("/deletePicGroup")
    @ResponseBody
    public Object deletePicGroup(Picgroup group){
              photoService.deletePicTheme(group);
        int i=photoService.deletePicGroup(group);
        if(i>0){
            System.out.println(group.getPicid());
            photoService.deletePicPhoto(group);
            photoService.deletePcDiscuess(group);
        }
        return i;
    }

    @RequestMapping("/updatePicGroupByLike")
    @ResponseBody
    public Object updatePicGroupByLike(Picgroup group){
        group.setPiclike(group.getPiclike()+1);
        int i=photoService.updatePicGroupByLike(group);
        return i;
    }

    @RequestMapping("/addPhotoreviem")
    @ResponseBody
    public Object addPhotoreviem(Picreview reviews){
        reviews.setUsernid(1);
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        reviews.setPictime(sim.format(new Date()));
        int i=photoService.addPhotoreviem(reviews);
        return i;
    }

    @RequestMapping("/queryPicReview")
    @ResponseBody
    public JSONObject queryPicReview(Picreview pic,@RequestParam(value="page")int page, @RequestParam(value="rows") int rows){
        JSONObject list=photoService.queryPicReview(pic,page,rows);
        return list;
    }
}
