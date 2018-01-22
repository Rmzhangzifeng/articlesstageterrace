package org.maker.service.impl;


import com.alibaba.fastjson.JSONObject;
import org.maker.dao.DiscusssMapper;
import org.maker.dao.EssaythemesMapper;
import org.maker.dao.SolicitarticlessMapper;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;
import org.maker.service.SolicitArticlesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitArticlesManServiceImpl implements SolicitArticlesManService {

    @Autowired /*征文管理mapper*/
    private SolicitarticlessMapper solicitarticlessMapper;

    @Autowired /*征文话题管理mapper*/
    private EssaythemesMapper essaythemesMapper;

    @Autowired /*征文评论管理mapper*/
    private DiscusssMapper discusssMapper;

    @Override
    public JSONObject queryEssayThemeList(int page, int rows, Essaythemes essaythemes) throws Exception {
        long totalCount = essaythemesMapper.queryEssayThemeListTotal(essaythemes);
        int start = (page-1)*rows;
        List<Essaythemes> Essaythemess = essaythemesMapper.queryEssayThemeListPage(start,rows,essaythemes);
        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", Essaythemess);
        return json;

    }

    @Override
    public JSONObject querSolicitarticlessList(int page, int rows, Solicitarticless solicitarticless) {
        long totalCount = solicitarticlessMapper.querSolicitarticlessListTotal(solicitarticless);
        int start = (page-1)*rows;
        List<Solicitarticless> solicitarticlesss = solicitarticlessMapper.querSolicitarticlessListPage(start,rows,solicitarticless);
        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", solicitarticlesss);
        return json;

    }
}
