package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Essaythemes;

import java.util.List;

public interface EssaythemesMapper {

    long queryEssayThemeListTotal(Essaythemes essaythemes);

    List<Essaythemes> queryEssayThemeListPage(@Param("start") int start, @Param("rows") int rows, @Param("essaythemes") Essaythemes essaythemes);
}