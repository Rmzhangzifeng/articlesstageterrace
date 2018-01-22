package org.maker.controller;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;
import org.maker.service.SolicitArticlesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文章管理controller
 *        Andy
 */
@Controller
public class SolicitArticlesManCon {

    @Autowired
    private SolicitArticlesManService solicitArticlesManService;

    /**
     *
     * @return 征文话题管理页面
     */
    @RequestMapping("/QueryEssaythemeSystem")
    public String toEssaythemeSystem(){
        return "SOlicitArt/EssaythemeSystem";
    }

    /**
     *
     * @return 征文管理页面
     */
    @RequestMapping("/QuerySolicitarticlessSystem")
    public String toSolicitarticlessSystem(){
        return "SOlicitArt/SolicitarticlessSystem";
    }

    /**
     * 查询话题分页数据
     * @param page 当前页
     * @param rows  每页条数
     * @param essaythemes 实体类对象
     * @return  当前页数据
     */
    @RequestMapping("/queryEssayThemeList")
    @ResponseBody
    public Object queryEssayThemeList(int page,int rows,Essaythemes essaythemes){
        JSONObject json = new JSONObject();
        try {
            json = solicitArticlesManService.queryEssayThemeList(page,rows,essaythemes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 查询文章分页数据
     * @param page 当前页
     * @param rows  每页条数
     * @param solicitarticless 实体类对象
     * @return  当前页数据
     */
    @RequestMapping("/querSolicitarticlessList")
    @ResponseBody
    public Object querSolicitarticlessList(int page, int rows, Solicitarticless solicitarticless){
        JSONObject json = new JSONObject();
        try {
            json = solicitArticlesManService.querSolicitarticlessList(page,rows,solicitarticless);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


}
