package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Jape;
import org.maker.pojo.Japediscusss;
import org.maker.pojo.Picgroup;

import java.util.List;

public interface JapeMapper {

    long queryJape(String id);

    List<Picgroup> queryJapePage(@Param("start") int start, @Param("end")int end, @Param("id")String id);

    Jape queryJapeById(Jape jape);

    int AddJape(Jape jape);

    int updateWyb(Jape jape);

    int deleteJape(Jape jape);

    int updateJape(Jape jape);

    int addJapeDiscuss(Japediscusss dis);

    long queryJapeDiscuess(Japediscusss dis);

    List<Picgroup> queryJapeDiscuessPage(@Param("start") int start, @Param("end")int end,@Param("dis")Japediscusss dis);

    void deleteJapeDiscuess(Jape jape);
}