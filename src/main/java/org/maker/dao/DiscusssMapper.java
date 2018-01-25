package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Discusss;

import java.util.List;

public interface DiscusssMapper {
    long queryArticleDiscussListTotal(Discusss discusss);

    List<Discusss> queryArticleDiscussListPage(@Param("start") int start,@Param("rows") int rows,@Param("discusss") Discusss discusss);

    int deleteArticleDiscuss(Discusss discusss);

    int updateArticleDiscuss(Discusss discusss);
}