package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.ComplaintsMapperYM;
import org.maker.pojo.Complaints;
import org.maker.service.ComplaintServiceYM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImplYM implements ComplaintServiceYM{
    @Autowired
    private ComplaintsMapperYM complaintsMapperYM;

    @Override
    public JSONObject queryComplaint(int page, int rows, Complaints complaints) {
       long total = complaintsMapperYM.queryComCountYM(complaints);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Complaints> complai;
        complai = complaintsMapperYM.queryComPageYM(start,end,complaints);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", complai);
        return json;
    }

    @Override
    public int updateSevenYM(Complaints complaints) {
        return complaintsMapperYM.updateSevenYM(complaints);
    }

    @Override
    public JSONObject queryComplaintss(int page, int rows, Complaints complaints) {
        long total = complaintsMapperYM.queryComCountYMss(complaints);
//		当前页数据
        int start = (page-1)*rows;
        int end = start+rows;
        List<Complaints> complai;
        complai = complaintsMapperYM.queryComPageYMss(start,end,complaints);
        JSONObject json = new JSONObject();
        json.put("total", total);
        json.put("rows", complai);
        return json;
    }

    @Override
    public int updateAllStaffComplaintYM(Complaints complaints) {
        return complaintsMapperYM.updateAllStaffComplaintYM(complaints.getComplaintids().split(","),complaints.getComplainthuifu());
    }
}
