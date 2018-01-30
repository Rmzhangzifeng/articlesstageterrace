package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.AdvertisementMapper;
import org.maker.pojo.Advertisement;
import org.maker.service.Adverservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdverserviceImpl implements Adverservice {

    @Autowired
    private AdvertisementMapper advertisementMapper;


    @Override
    public JSONObject queryAdPage(int page, int rows, Advertisement a) {
        //总条数
        long total = advertisementMapper.queryadtotal(a);
        //开始位置
        int start=(page-1)*rows;
        //具体数据
        List<Advertisement> row=advertisementMapper.queryList(start,rows,a);
        //装入数据
        JSONObject json =new JSONObject();
        json.put("total",total);
        json.put("rows",row);
        return json;
    }

    @Override
    public int updateSpread(String ids,Integer idd) {
        return advertisementMapper.updateSpread(ids,idd);
    }

    @Override
    public int delad(String ids) {
        return advertisementMapper.delad(ids);
    }

    @Override
    public int addad(Advertisement a) {
        return advertisementMapper.addad(a);
    }

    @Override
    public int datecheck(Advertisement a) {
        return advertisementMapper.datecheck(a);
    }

    @Override
    public void updateadStatus() {
        advertisementMapper.up1();
        advertisementMapper.up2();
        advertisementMapper.up3();
    }
}
