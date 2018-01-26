package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.xs.models.XSDFACM;
import org.maker.dao.JapeMapper;
import org.maker.pojo.Jape;
import org.maker.pojo.Japediscusss;
import org.maker.pojo.Picgroup;
import org.maker.pojo.Users;
import org.maker.service.JapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class JapeServiceImpl implements JapeService {

    @Autowired
    private JapeMapper japeMapper;
    @Override
    public JSONObject queryJape(String id, int page, int rows) {
        long count;
        List<Picgroup> list;
        int start=(page-1)*rows;
        int end=start+rows;
        if(id!=null){
            count=japeMapper.queryJape(id);
            list=japeMapper.queryJapePage(start,end,id);
        }else{
            count=japeMapper.queryJape("");
            list=japeMapper.queryJapePage(start,end,"");
        }
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public Jape queryJapeById(Jape jape) {
        return japeMapper.queryJapeById(jape);
    }

    @Override
    public int AddJape(Jape jape,HttpSession session) {
        Users user=(Users) session.getAttribute("loginUserMsg");
        jape.setWybjapeid(user.getUserid());
        jape.setWybfist(0);
        jape.setWybgood(0);
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        jape.setWybdate(sim.format(new Date()));
        return japeMapper.AddJape(jape);
    }

    @Override
    public int updateWyb(Jape jape) {
        return japeMapper.updateWyb(jape);
    }

    @Override
    public int deleteJape(Jape jape) {
        return japeMapper.deleteJape(jape);
    }

    @Override
    public int updateJape(Jape jape) {
        return japeMapper.updateJape(jape);
    }

    @Override
    public int addJapeDiscuss(Japediscusss dis, HttpSession session) {
        Users user=(Users) session.getAttribute("loginUserMsg");
        dis.setUsergid(user.getUserid());
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");

        dis.setJapedate(sim.format(new Date()));

        return japeMapper.addJapeDiscuss(dis);
    }

    @Override
    public JSONObject queryJapeDiscuess(Japediscusss dis, int page, int rows) {
        long count;
        List<Picgroup> list;
        int start=(page-1)*rows;
        int end=start+rows;
            count=japeMapper.queryJapeDiscuess(dis);
            list=japeMapper.queryJapeDiscuessPage(start,end,dis);
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void deleteJapeDiscuess(Jape jape) {
        japeMapper.deleteJapeDiscuess(jape);
    }
}
