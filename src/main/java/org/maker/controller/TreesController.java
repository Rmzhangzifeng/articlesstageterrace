package org.maker.controller;


import org.maker.pojo.Trees;
import org.maker.service.TreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@EnableAutoConfiguration
public class TreesController {



    @Autowired
    private TreesService userService;

    @RequestMapping(value = "/homes")
    public String home() {
        System.out.println("跳转页面");
        return "../index";
    }
    @RequestMapping("/queryTree")
    @ResponseBody
    public List queryTree(){
        List<Trees> trees =userService.queryTree("0");
        return trees;

    }
}
