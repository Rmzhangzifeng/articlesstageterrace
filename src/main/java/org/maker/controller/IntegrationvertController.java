package org.maker.controller;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.IntegraShop;
import org.maker.service.IntegrationvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  积分兑换
 */
@Controller
public class IntegrationvertController {

    @Autowired
    private IntegrationvertService integrationvertService;

    /**
     * 跳转到积分兑换页面
     * @return
     */
    @RequestMapping("Integrationvert/toIntegrationConvertPage")
    public String toIntegrationConvertPage(){

        return "Integrationvert/IntegrationConvertPage";
    }

    /**
     * 查询当前期商品展示信息
     * @return
     */
    @RequestMapping("Integrationvert/queryNowShops")
    @ResponseBody
    public Object queryNowShops(int page,int rows ,IntegraShop integraShop){
        JSONObject json = new JSONObject();
        try {
            json = integrationvertService.queryNowShops(page,rows,integraShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 补货
     * @param integraShop
     * @return
     */
    @RequestMapping("Integrationvert/insertIntegrationvertShop")
    @ResponseBody
    public Object insertIntegrationvertShop(IntegraShop integraShop){
            int insertFalg  = 0;
        try {
            insertFalg = integrationvertService.insertIntegrationvertShop(integraShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertFalg;
    }

    /**
     * 删除商品
     * @param integraShop
     * @return
     */
    @RequestMapping("Integrationvert/deleteIntegrationvertShop")
    @ResponseBody
    public Object deleteIntegrationvertShop(IntegraShop integraShop){
            int delFalg = 0;
        try {
            delFalg = integrationvertService.deleteIntegrationvertShop(integraShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  delFalg;
    }

    /**
     * 修改商品库存
     * @param integraShop
     * @return
     */
    @RequestMapping("Integrationvert/updateShopCountValue")
    @ResponseBody
    public Object updateShopCountValue(IntegraShop integraShop){
        int UpFalg = 0;
        try {
            UpFalg = integrationvertService.updateShopCountValue(integraShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UpFalg;
    }
}
