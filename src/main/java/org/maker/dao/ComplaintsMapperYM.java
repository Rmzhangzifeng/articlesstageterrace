package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Complaints;

import java.util.List;

public interface ComplaintsMapperYM {
    long queryComCountYM(Complaints complaints);

    List<Complaints> queryComPageYM(@Param("start")int start,@Param("end") int end,@Param("complaints") Complaints complaints);

    int updateSevenYM(Complaints complaints);

    long queryComCountYMss(Complaints complaints);

    List<Complaints> queryComPageYMss(@Param("start")int start,@Param("end") int end,@Param("complaints")  Complaints complaints);

    int updateAllStaffComplaintYM(@Param(value = "mmp") String[] mmp,@Param("complainthuifu") String complainthuifu);
}