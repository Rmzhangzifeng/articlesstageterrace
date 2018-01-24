package org.maker.controller;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Advertisement;
import org.maker.service.Adverservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文章管理controller
 * Andy
 */
@Controller
public class ArticleSpread {

  @Autowired
  private Adverservice adverservice;
    /**
     * @return 推广管理页面
     */
    @RequestMapping("/querySpread")
    public String toSolicitarticlessSystem() {
        return "Spread/SpreadPage";
    }

    @RequestMapping("/updateSpread")
    @ResponseBody
    public Object  updateSpread(String ids,Integer idd) {
        int json=adverservice.updateSpread(ids,idd);
        return json;
    }

    /**
     * 广告页面
     *
     * @return
     */
    @RequestMapping("/queryAd")
    public String queryAd() {
        return "Spread/ad";
    }

    /**
     * 广告数据查询
     *
     * @return
     */
    @RequestMapping("/queryAdPage")
    @ResponseBody
    public Object  queryAdPage(int page,int rows,Advertisement a) {
        JSONObject json=adverservice.queryAdPage(page,rows,a);
        return json;
    }

    /**
     * 广告新增
     * @return
     */
    @RequestMapping("/toaddadver")
    public String toaddadver() {
        return "Spread/adadver";
    }

    /**
     * 广告删除
     * @param ids
     * @return
     */
    @RequestMapping("/delad")
    @ResponseBody
    public Object  delad(String ids) {
        int json=adverservice.delad(ids);
        return json;
    }

    /**
     * 广告新增
     * @param a
     * @return
     */
    @RequestMapping("/addad")
    @ResponseBody
    public Object  addad(Advertisement a) {
        int json=adverservice.addad(a);
        return json;
    }
    @RequestMapping("/datecheck")
    @ResponseBody
    public Object  datecheck(Advertisement a) {
         int json=adverservice.datecheck(a);
        return json;
    }

    /**
     * 上传
     * @param artImg
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("/upadloadImg")
    @ResponseBody
    public String upImag1(MultipartFile artImg, HttpServletRequest req) throws IOException{
        String fileName=artImg.getOriginalFilename();
        SimpleDateFormat  sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        String folderPath=req.getSession().getServletContext().getRealPath("/")
                +"upimg/";
        File file=new File(folderPath);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
     /*   System.out.println(folderPath+onlyFileName);*/
        fos.write(artImg.getBytes());
        fos.flush();
        fos.close();
        return "/upimg/"+onlyFileName;
    }

}
