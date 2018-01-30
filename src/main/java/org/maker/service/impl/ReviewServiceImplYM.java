package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.ReviewMapperYM;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Frequencys;
import org.maker.pojo.Picthemes;
import org.maker.service.ReviewServiceYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplYM implements ReviewServiceYM {

    @Autowired
    private ReviewMapperYM reviewMapperYM;


    @Override
    public JSONObject queryBookPage(int page, int rows, Essaythemes essaythemes) {
        long total = reviewMapperYM.queryCount(essaythemes);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Essaythemes> essaythem;
        essaythem = reviewMapperYM.queryPage(start,end,essaythemes);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", essaythem);
        return json;
    }

    @Override
    public JSONObject queryPictheme(int page, int rows, Picthemes picthemes) {
        long total = reviewMapperYM.queryPicCount(picthemes);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Picthemes> picthe;
        picthe = reviewMapperYM.queryPicPage(start,end, picthemes);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", picthe);
        return json;
    }

    @Override
    public JSONObject queryFrequency(int page, int rows, Frequencys frequencys) {
        long total = reviewMapperYM.queryFreCount(frequencys);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Frequencys> frequen;
        frequen = reviewMapperYM.queryFrePage(start,end,frequencys);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", frequen);
        return json;
    }

    @Override
    public int updateEssaytheme(Essaythemes essaythemes) {
        return reviewMapperYM.updateEssaytheme(essaythemes);
    }

    @Override
    public int updatePicthemeYm(Picthemes picthemes) {
        return reviewMapperYM.updatePicthemeYm(picthemes);
    }

    @Override
    public int updateFrequencyYm(Frequencys frequencys) {
        return reviewMapperYM.updateFrequencyYm(frequencys);
    }

    @Override
    public JSONObject queryEssaythemess(int page, int rows, Essaythemes essaythemes) {
        long total = reviewMapperYM.queryCountss(essaythemes);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Essaythemes> essaythem;
        essaythem = reviewMapperYM.queryPagess(start,end,essaythemes);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", essaythem);
        return json;
    }

    @Override
    public JSONObject queryPicthemess(int page, int rows, Picthemes picthemes) {
        long total = reviewMapperYM.queryPicCountss(picthemes);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Picthemes> picthe;
        picthe = reviewMapperYM.queryPicPagess(start,end, picthemes);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", picthe);
        return json;
    }

    @Override
    public JSONObject queryFrequencyss(int page, int rows, Frequencys frequencys) {
        long total = reviewMapperYM.queryFreCountss(frequencys);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Frequencys> frequen;
        frequen = reviewMapperYM.queryFrePagess(start,end,frequencys);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", frequen);
        return json;
    }

    @Override
    public int updateAllStaffFrequencyYM(Frequencys frequencys) {
        return reviewMapperYM.updateAllStaffFrequencyYM(frequencys.getFrequencyids().split(","));
    }

    @Override
    public int updateAllStaffEssaythemeYM(Essaythemes essaythemes) {
        return reviewMapperYM.updateAllStaffEssaythemeYM(essaythemes.getArticletopicids().split(","));
    }

    @Override
    public int updateStaffAllPicthemeYM(Picthemes picthemes) {
        return reviewMapperYM.updateStaffAllPicthemeYM(picthemes);
    }
}
