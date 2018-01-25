package org.maker.service.impl;


import com.alibaba.fastjson.JSONObject;
import org.maker.dao.DiscusssMapper;
import org.maker.dao.EssaythemesMapper;
import org.maker.dao.SolicitarticlessMapper;
import org.maker.pojo.Discusss;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;
import org.maker.pojo.SolicitarticlessMongoContent;
import org.maker.service.SolicitArticlesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SolicitArticlesManServiceImpl implements SolicitArticlesManService {

    @Autowired /*征文管理mapper*/
    private SolicitarticlessMapper solicitarticlessMapper;

    @Autowired /*征文话题管理mapper*/
    private EssaythemesMapper essaythemesMapper;

    @Autowired /*征文评论管理mapper*/
    private DiscusssMapper discusssMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

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
        for (int i=0;i<solicitarticlesss.size();i++)
        {
            List<SolicitarticlessMongoContent> solicitarticlessMongoContent = mongoTemplate.find(new Query(Criteria.where("contentId").is(solicitarticlesss.get(i).getSolicitarticlesid())),SolicitarticlessMongoContent.class,"SolicitArt");
            if(solicitarticlessMongoContent.size()>0){
                if(!solicitarticlessMongoContent.get(0).getClessContent().equals(null) && !("").equals(solicitarticlessMongoContent.get(0).getClessContent())){
                    solicitarticlesss.get(i).setContentStr(solicitarticlessMongoContent.get(0).getClessContent());
                }
            }
        }
        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", solicitarticlesss);
        return json;

    }

    @Override
    public JSONObject queryArticleDiscussList(int page, int rows, Discusss discusss) throws Exception {
        long totalCount = discusssMapper.queryArticleDiscussListTotal(discusss);
        int start = (page-1)*rows;
        List<Discusss> discussss = discusssMapper.queryArticleDiscussListPage(start,rows,discusss);
        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", discussss);
        return json;
    }

    @Override
    public int insertEssayTheme(Essaythemes essaythemes) throws Exception {
        essaythemes.setStartTimeStr(sim.format(new Date()));
        return essaythemesMapper.insertEssayTheme(essaythemes);
    }

    @Override
    public int deleteEssayTheme(Essaythemes essaythemes) throws Exception {
        return essaythemesMapper.deleteEssayTheme(essaythemes);
    }

    @Override
    public int updateEssayTheme(Essaythemes essaythemes) throws Exception {
        return essaythemesMapper.updateEssayTheme(essaythemes);
    }

    @Override
    public int InsertSolicitarticless(Solicitarticless solicitarticless) throws Exception {
        solicitarticless.setSolicitarticlestimeStr(sim.format(new Date()));
        int maxid = solicitarticlessMapper.queryMaxId();
        solicitarticless.setSolicitarticlesid(maxid+1);
        int inserfalg = solicitarticlessMapper.InsertSolicitarticless(solicitarticless);
        if(inserfalg > 0){
            SolicitarticlessMongoContent solicitarticlessMongoContent = new SolicitarticlessMongoContent();
            solicitarticlessMongoContent.setContentId(maxid+1);
            solicitarticlessMongoContent.setClessContent(solicitarticless.getContentStr());
            mongoTemplate.insert(solicitarticlessMongoContent);
        }
        return inserfalg;
    }

    @Override
    public int deleteSolicitarticless(Solicitarticless solicitarticless) throws Exception {
        String[] tempStr = solicitarticless.getIdStr().split(",");
        for (int i=0;i<tempStr.length;i++){
            mongoTemplate.findAndRemove(new Query(Criteria.where("contentId").is(Integer.parseInt(tempStr[i]))),SolicitarticlessMongoContent.class,"SolicitArt");
        }

        return solicitarticlessMapper.deleteSolicitarticless(solicitarticless);
    }

    @Override
    public int updateSolicitarticless(Solicitarticless solicitarticless) throws Exception {
        List<SolicitarticlessMongoContent> soMongoContentList =
                mongoTemplate.find(new Query(Criteria.where("contentId").is(solicitarticless.getSolicitarticlesid())),SolicitarticlessMongoContent.class);
        if(soMongoContentList!=null && soMongoContentList.size() > 0){
            Update update = new Update();
            update.set("clessContent", solicitarticless.getContentStr());
            mongoTemplate.updateFirst(
                    new Query(Criteria.where("contentId").is(solicitarticless.getSolicitarticlesid())),
                    update, SolicitarticlessMongoContent.class);
        }else {
            SolicitarticlessMongoContent solicitarticlessMongoContent = new SolicitarticlessMongoContent();
            solicitarticlessMongoContent.setClessContent(solicitarticless.getContentStr());
            solicitarticlessMongoContent.setContentId(solicitarticless.getSolicitarticlesid());
            mongoTemplate.save(solicitarticlessMongoContent);
        }
        return solicitarticlessMapper.updateSolicitarticless(solicitarticless);
    }

    @Override
    public int deleteArticleDiscuss(Discusss discusss) throws Exception {
        return discusssMapper.deleteArticleDiscuss(discusss);
    }

    @Override
    public int updateArticleDiscuss(Discusss discusss) throws Exception {
        return discusssMapper.updateArticleDiscuss(discusss);
    }

    @Override
    public List<Essaythemes> querygambitidSelections() throws Exception {
        return essaythemesMapper.querygambitidSelections();
    }

}
