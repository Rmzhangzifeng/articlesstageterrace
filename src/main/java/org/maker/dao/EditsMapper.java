package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Edits;

import java.util.List;

public interface EditsMapper {
    long queryTotal();

    List<Edits> queryStudentPage(@Param("start") int start,@Param("end") int end);


    List<Edits> queryByPidybq(@Param("s") int s);

    int insertedits(@Param("edits") Edits edits);
}