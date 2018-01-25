package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Edits;
import org.maker.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EditController {
    @Autowired
    private EditService editService;
    @RequestMapping("/toeditshow")
    public String toeditshow(){
        return "edit/show";
    }
    @RequestMapping("/queryedittable")
    @ResponseBody
    public Object queryedittable(int page,int rows){
        JSONObject json=editService.queryedittable(page,rows);
        return json;
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "edit/add";
    }
    @RequestMapping("/editshow")
    public String editshow(){
        return "edit/editshow";
    }
    @RequestMapping("/queryeditsybq")
    @ResponseBody
    public List queryeditsybq(){
        List<Edits> edit =editService.queryeditsybq(0);
        return edit;
    }
    @RequestMapping("/insertedits")
    @ResponseBody
    public int insertedits(Edits edits){
        int a=0;
        a=editService.insertedits(edits);
        return a;
    }
}
