package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Complaints;

public interface ComplaintServiceYM {
    JSONObject queryComplaint(int page, int rows, Complaints complaints);

    int updateSevenYM(Complaints complaints);

    JSONObject queryComplaintss(int page, int rows, Complaints complaints);

    int updateAllStaffComplaintYM(Complaints complaints);
}
