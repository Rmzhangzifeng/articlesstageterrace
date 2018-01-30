package org.maker.service;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Jape;
import org.maker.pojo.Japediscusss;

import javax.servlet.http.HttpSession;

public interface JapeService {

    JSONObject queryJape(String id, int page, int rows);

    Jape queryJapeById(Jape jape);

    int AddJape(Jape jape,HttpSession session);

    int updateWyb(Jape jape);

    int deleteJape(Jape jape);

    int updateJape(Jape jape);

    int addJapeDiscuss(Japediscusss dis,HttpSession session);

    JSONObject queryJapeDiscuess(Japediscusss dis, int page, int rows);

    void deleteJapeDiscuess(Jape jape);
}
