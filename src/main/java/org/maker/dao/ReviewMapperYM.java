package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Frequencys;
import org.maker.pojo.Picthemes;

import java.util.List;

public interface ReviewMapperYM {


    long queryCount(Essaythemes essaythemes);

    List<Essaythemes> queryPage(@Param("start") int start,@Param("end") int end,@Param("essaythemes") Essaythemes essaythemes);

    long queryPicCount(Picthemes picthemes);

    List<Picthemes> queryPicPage(@Param("start")int start,@Param("end") int end,@Param("picthemes") Picthemes picthemes);

    long queryFreCount(Frequencys frequencys);

    List<Frequencys> queryFrePage(@Param("start")int start,@Param("end") int end,@Param("frequencys") Frequencys frequencys);

    int updateEssaytheme(Essaythemes essaythemes);

    int updatePicthemeYm(Picthemes picthemes);

    int updateFrequencyYm(Frequencys frequencys);

    long queryCountss(Essaythemes essaythemes);

    List<Essaythemes> queryPagess(@Param("start")int start,@Param("end") int end,@Param("essaythemes") Essaythemes essaythemes);

    long queryPicCountss(Picthemes picthemes);

    List<Picthemes> queryPicPagess(@Param("start")int start,@Param("end") int end,@Param("picthemes") Picthemes picthemes);

    long queryFreCountss(Frequencys frequencys);

    List<Frequencys> queryFrePagess(@Param("start")int start,@Param("end") int end,@Param("frequencys") Frequencys frequencys);

    int updateAllStaffFrequencyYM(@Param(value="fyids")String[] fyids);

    int updateAllStaffEssaythemeYM(@Param(value="ess")String[] ess);

    int updateStaffAllPicthemeYM(@Param(value="pss")Picthemes picthemes);
}