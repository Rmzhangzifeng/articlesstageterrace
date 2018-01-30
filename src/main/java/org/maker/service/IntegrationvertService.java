package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.IntegraShop;

import java.util.List;

public interface IntegrationvertService {

    JSONObject queryNowShops(int page, int rows, IntegraShop integraShop) throws Exception;

    int insertIntegrationvertShop(IntegraShop integraShop)  throws Exception;

    int deleteIntegrationvertShop(IntegraShop integraShop)  throws Exception;

    int updateShopCountValue(IntegraShop integraShop)  throws Exception;
}
