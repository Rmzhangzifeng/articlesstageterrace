package org.maker.controller;


import org.maker.pojo.DemoPojo;
import org.maker.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DemoController {


    @Autowired
    private PoiService poiService;

    @RequestMapping("/test")
    public String test(){

        List<DemoPojo> list = poiService.queryDate();
        for (DemoPojo demo:list
             ) {
            System.out.print(demo.getDemoname());
        }
        System.out.print("========进来了乐乐乐========");
        return "hello";
    }



}
