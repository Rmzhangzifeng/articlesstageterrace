package org.maker.dao;


import org.apache.ibatis.annotations.Param;
import org.maker.pojo.IntegraShop;

import java.util.List;

public interface IntegraShopMapper {

    long queryNowShopsTotal(IntegraShop integraShop);

    List<IntegraShop> queryNowShopsPage(@Param("start") int start,@Param("rows") int rows,@Param("integraShop") IntegraShop integraShop);

    int insertIntegrationvertShop(IntegraShop integraShop);

    int deleteIntegrationvertShop(IntegraShop integraShop);

    int updateShopCountValue(IntegraShop integraShop);
}