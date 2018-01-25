package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Advertisement;

public interface Adverservice {
    JSONObject queryAdPage(int page, int rows, Advertisement a);

    int updateSpread(String ids,Integer idd);

    int delad(String ids);

    int addad(Advertisement a);

    int datecheck(Advertisement a);

    void updateadStatus();
}
