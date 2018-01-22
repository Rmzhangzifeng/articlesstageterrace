package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;

public interface SolicitArticlesManService {
    JSONObject queryEssayThemeList(int page, int rows, Essaythemes essaythemes) throws  Exception;

    JSONObject querSolicitarticlessList(int page, int rows, Solicitarticless solicitarticless);
}
