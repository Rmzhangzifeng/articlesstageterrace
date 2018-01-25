package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Discusss;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;

import java.util.List;

public interface SolicitArticlesManService {
    JSONObject queryEssayThemeList(int page, int rows, Essaythemes essaythemes) throws  Exception;

    JSONObject querSolicitarticlessList(int page, int rows, Solicitarticless solicitarticless) throws  Exception;

    int insertEssayTheme(Essaythemes essaythemes) throws  Exception;

    int deleteEssayTheme(Essaythemes essaythemes) throws  Exception;

    int updateEssayTheme(Essaythemes essaythemes) throws  Exception;

    int InsertSolicitarticless(Solicitarticless solicitarticless) throws  Exception;

    int deleteSolicitarticless(Solicitarticless solicitarticless) throws  Exception;

    int updateSolicitarticless(Solicitarticless solicitarticless) throws  Exception;

    JSONObject queryArticleDiscussList(int page, int rows, Discusss discusss) throws  Exception;

    int deleteArticleDiscuss(Discusss discusss) throws  Exception;

    int updateArticleDiscuss(Discusss discusss) throws  Exception;

    List<Essaythemes> querygambitidSelections() throws  Exception;
}
