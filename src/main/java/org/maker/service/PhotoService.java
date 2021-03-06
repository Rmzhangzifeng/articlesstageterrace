package org.maker.service;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PhotoService {
    List<EnjEdit> queryEdit(String id);

    JSONObject queryPic(String id, int page, int rows);

    int AddPicPhoto(Picphoto po,HttpSession session);

    Picphoto queryPicPhotos(Picphoto po);

    int AddPicGroup(Picgroup group,HttpSession session);

    Picgroup queryPicGoup(Picgroup group);

    int addWybPictheme(Picthemes pic);

    List<Picphoto> queryPicGroupByIds(Picgroup id);

    int UpdateGroupById(Picgroup group);

    int deletePicGroup(Picgroup group);

    void deletePicTheme(Picgroup group);

    void deletePicPhoto(Picgroup s);

    int updatePicGroupByLike(Picgroup group);

    int addPhotoreviem(Picreview reviews);

    JSONObject queryPicReview(Picreview pic,int page, int rows);

    void deletePcDiscuess(Picgroup group);
}
