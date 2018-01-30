package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.IntegraShopMapper;
import org.maker.pojo.IntegraShop;
import org.maker.service.IntegrationvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationvertServiceImpl implements IntegrationvertService{

    @Autowired
    private IntegraShopMapper integraShopMapper;

    @Override
    public JSONObject queryNowShops(int page, int rows, IntegraShop integraShop) {
        long totalCount = integraShopMapper.queryNowShopsTotal(integraShop);
        int start = (page-1)*rows;
        List<IntegraShop> integraShops = integraShopMapper.queryNowShopsPage(start,rows,integraShop);
        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", integraShops);
        return json;
    }

    @Override
    public int insertIntegrationvertShop(IntegraShop integraShop) {
        return integraShopMapper.insertIntegrationvertShop(integraShop);
    }

    @Override
    public int deleteIntegrationvertShop(IntegraShop integraShop) throws Exception {
        return integraShopMapper.deleteIntegrationvertShop(integraShop);
    }

    @Override
    public int updateShopCountValue(IntegraShop integraShop) throws Exception {
        return integraShopMapper.updateShopCountValue(integraShop);
    }
}
