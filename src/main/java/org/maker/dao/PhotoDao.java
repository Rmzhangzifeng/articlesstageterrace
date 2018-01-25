package org.maker.dao;

import org.apache.ibatis.annotations.Param;
import org.maker.pojo.*;


import java.util.List;

public interface PhotoDao {
    List<EnjEdit> queryEdit(String id);
    Long queryPic(String id);
    List<Picgroup> queryPicPage(@Param("start") int start, @Param("end")int end, @Param("id") String id);

    int AddPicPhoto(Picphoto po);

    Picphoto queryPicPhotos(Picphoto po);

    int AddPicGroup(Picgroup group);

    Picgroup queryPicGoup(Picgroup group);

    int addWybPictheme(Picthemes pic);

    List<Picphoto> queryPicGroupByIds(Picgroup ids);

    int UpdateGroupById(Picgroup group);

    int deletePicGroup(Picgroup group);

    void deletePicPhoto(Picgroup group);

    void deletePicTheme(Picgroup group);

    int updatePicGroupByLike(Picgroup group);

    int addPhotoreviem(Picreview reviews);

    long queryPicReview(Picreview pic);

    List<Picgroup> queryPicReviewPage(@Param("pic")Picreview pic,@Param("start") int start,@Param("end") int end);

    void deletePcDiscuess(Picgroup group);
}
