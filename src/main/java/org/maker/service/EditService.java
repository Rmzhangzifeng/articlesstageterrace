package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Edits;

import java.util.List;

public interface EditService  {
    JSONObject queryedittable(int page, int rows);

    List<Edits> queryeditsybq(int s);

    int insertedits(Edits edits);
}
