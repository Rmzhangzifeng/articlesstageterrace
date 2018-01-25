package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Advertisement;

import java.util.List;

/**
 *
 */
public interface AdvertisementMapper {

    long queryadtotal(Advertisement a);

    List<Advertisement> queryList(@Param("st") int start, @Param("rw") int rows, @Param("a") Advertisement a);

    int updateSpread(@Param("ids") String ids,@Param("idd") Integer idd);

    int delad(@Param("ids") String  ids);

    int addad(Advertisement a);

    int datecheck(Advertisement a);


    void up1();

    void up2();
}