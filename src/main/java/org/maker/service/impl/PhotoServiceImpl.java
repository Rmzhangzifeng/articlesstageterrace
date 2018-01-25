package org.maker.service.impl;


import com.alibaba.fastjson.JSONObject;
import org.maker.dao.PhotoDao;
import org.maker.pojo.*;
import org.maker.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao photoDao;
    @Override
    public List<EnjEdit> queryEdit(String id) {
        return photoDao.queryEdit(id);
    }

    @Override
    public JSONObject queryPic(String id, int page, int rows) {
        long count;
        List<Picgroup> list;
        int start=(page-1)*rows;
        int end=start+rows;
        if(id!=null){
            count=photoDao.queryPic(id);
            list=photoDao.queryPicPage(start,end,id);
        }else{
            count=photoDao.queryPic("");
            list=photoDao.queryPicPage(start,end,"");
        }
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public int AddPicPhoto(Picphoto po) {
        po.setPicuplodtime(new Date());
        po.setPicuplodperson("123");
        return photoDao.AddPicPhoto(po);
    }

    @Override
    public Picphoto queryPicPhotos(Picphoto po) {
        return photoDao.queryPicPhotos(po);
    }

    @Override
    public int AddPicGroup(Picgroup group) {
        if(group.getPicid().indexOf(",")==-1){
            group.setPiccover(Integer.parseInt(group.getPicid()));
        }else{
            String  cove=group.getPicid().substring(0,group.getPicid().indexOf(","));
            int c=Integer.parseInt(cove);
            group.setPiccover(c);
        }
        group.setPiclike(0);
        return photoDao.AddPicGroup(group);
    }

    @Override
    public Picgroup queryPicGoup(Picgroup group) {
        return photoDao.queryPicGoup(group);
    }

    @Override
    public int addWybPictheme(Pictheme pic) {
        return photoDao.addWybPictheme(pic);
    }

    @Override
    public List<Picphoto> queryPicGroupByIds(Picgroup ids) {
        return photoDao.queryPicGroupByIds(ids);
    }

    @Override
    public int UpdateGroupById(Picgroup group) {
        return photoDao.UpdateGroupById(group);
    }

    @Override
    public int deletePicGroup(Picgroup group) {
        return  photoDao.deletePicGroup(group);
    }

    @Override
    public void deletePicPhoto(Picgroup group) {
        photoDao.deletePicPhoto(group);
    }

    @Override
    public void deletePicTheme(Picgroup group) {
        photoDao.deletePicTheme(group);
    }

    @Override
    public int updatePicGroupByLike(Picgroup group) {
        return photoDao.updatePicGroupByLike(group);
    }

    @Override
    public int addPhotoreviem(Picreview reviews) {
        return photoDao.addPhotoreviem(reviews);
    }

    @Override
    public JSONObject queryPicReview(Picreview pic,int page, int rows) {
        long count;
        List<Picgroup> list;
        int start=(page-1)*rows;
        int end=start+rows;
            count=photoDao.queryPicReview(pic);
            list=photoDao.queryPicReviewPage(pic,start,end);
        JSONObject json=new JSONObject();
        json.put("total", count);
        json.put("rows", list);
        return json;
    }

    @Override
    public void deletePcDiscuess(Picgroup group) {
        photoDao.deletePcDiscuess(group);
    }
}
