package org.maker.dao;



import org.apache.ibatis.annotations.Param;
import org.maker.pojo.Solicitarticless;

import java.util.List;

public interface SolicitarticlessMapper {


    long querSolicitarticlessListTotal(Solicitarticless solicitarticless);

    List<Solicitarticless> querSolicitarticlessListPage(@Param("start") int start,@Param("rows") int rows,@Param("solicitarticless") Solicitarticless solicitarticless);

    int InsertSolicitarticless(Solicitarticless solicitarticless);

    int queryMaxId();

    int deleteSolicitarticless(Solicitarticless solicitarticless);

    int updateSolicitarticless(Solicitarticless solicitarticless);
}