package org.maker.controller;


import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Discusss;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Solicitarticless;
import org.maker.pojo.Users;
import org.maker.service.SolicitArticlesManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章管理controller
 *        Andy
 */
@Controller
public class SolicitArticlesManCon {

    @Autowired
    private SolicitArticlesManService solicitArticlesManService;

    /**
     *
     * @return 跳转到征文话题管理页面
     */
    @RequestMapping("SolicitArticlesManCon/QueryEssaythemeSystem")
    public String toEssaythemeSystem(){
        return "SOlicitArt/EssaythemeSystem";
    }

    /**
     *
     * @return 跳转到征文管理页面
     */
    @RequestMapping("SolicitArticlesManCon/QuerySolicitarticlessSystem")
    public String toSolicitarticlessSystem(){
        return "SOlicitArt/SolicitarticlessSystem";
    }

    /**
     *
     * @return 跳转到征文评论管理页面
     */
    @RequestMapping("SolicitArticlesManCon/QueryArticleDiscussSystem")
    public String toArticleDiscussSystem(){
        return "SOlicitArt/ArticleDiscussSystem";
    }

    /**
     * 跳转到修改话题页面
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/toUpdateEssayThemePage")
    public String toUpdateEssayThemePage(Essaythemes essaythemes, ServletRequest request){
        request.setAttribute("upessay",essaythemes);
        return "SOlicitArt/updateEssayThemePage";
    }

    /**
     * 跳转到修改征文信息页面
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/toUpdateSolicitarticlessPage")
    public String toUpdateSolicitarticlessPage(Solicitarticless solicitarticless, ServletRequest request){
        request.setAttribute("upsolictaDate",solicitarticless);
        return "SOlicitArt/updateSolicitarticlessPage";
    }

    /**
     * 跳转到修改征文信息页面
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/toUpdateArticleDiscuss")
    public String toUpdateArticleDiscuss(Discusss discusss, ServletRequest request){
        request.setAttribute("updiscussDate",discusss);
        return "SOlicitArt/updateArticleDiscussPage";
    }

    /**
     * 查询话题分页数据
     * @param page 当前页
     * @param rows  每页条数
     * @param essaythemes 实体类对象
     * @return  当前页数据
     */
    @RequestMapping("SolicitArticlesManCon/queryEssayThemeList")
    @ResponseBody
    public Object queryEssayThemeList(int page,int rows,Essaythemes essaythemes){
        JSONObject json = new JSONObject();
        try {
            json = solicitArticlesManService.queryEssayThemeList(page,rows,essaythemes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 查询文章分页数据
     * @param page 当前页
     * @param rows  每页条数
     * @param solicitarticless 实体类对象
     * @return  当前页数据
     */
    @RequestMapping("SolicitArticlesManCon/querySolicitarticlessList")
    @ResponseBody
    public Object querSolicitarticlessList(int page, int rows, Solicitarticless solicitarticless){
        JSONObject json = new JSONObject();
        try {
            json = solicitArticlesManService.querSolicitarticlessList(page,rows,solicitarticless);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 查询征文评论分页数据
     * @param page 当前页
     * @param rows  每页条数
     * @param discusss 实体类对象
     * @return  当前页数据
     */
    @RequestMapping("SolicitArticlesManCon/queryArticleDiscussList")
    @ResponseBody
    public Object queryArticleDiscussList(int page, int rows, Discusss discusss){
        JSONObject json = new JSONObject();
        try {
            json = solicitArticlesManService.queryArticleDiscussList(page,rows,discusss);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 新增本期话题
     * @param essaythemes
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/insertEssayTheme")
    @ResponseBody
    public Object insertEssayTheme(Essaythemes essaythemes){
        int insertFalg = 0;
        try {
            insertFalg = solicitArticlesManService.insertEssayTheme(essaythemes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertFalg;
    }

    /**
     * 删除话题
     * @param essaythemes
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/deleteEssayTheme")
    @ResponseBody
    public Object deleteEssayTheme(Essaythemes essaythemes){
        int deleteFalg = 0;
        try {
            deleteFalg = solicitArticlesManService.deleteEssayTheme(essaythemes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFalg;
    }

    /**
     * 修改话题
     * @param essaythemes
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/updateEssayTheme")
    @ResponseBody
    public Object updateEssayTheme(Essaythemes essaythemes){
        int updateFalg = 0;
        try {
            updateFalg = solicitArticlesManService.updateEssayTheme(essaythemes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFalg;
    }

    /**
     * 封面图片上传
     * @param SolicitarticlessUploadFile
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping("SolicitArticlesManCon/uploadFileSolicitarticless")
    @ResponseBody
    public Object uploadFileSolicitarticless(MultipartFile SolicitarticlessUploadFile, HttpServletRequest req) throws IOException {
        String fileName=SolicitarticlessUploadFile.getOriginalFilename();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        String folderPath=req.getSession().getServletContext().getRealPath("/")
                +"upimg/";
        File file=new File(folderPath);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(SolicitarticlessUploadFile.getBytes());
        fos.flush();
        fos.close();
        return "/upimg/"+onlyFileName;
    }

    /**
     * 新增征文页面查询话题列表
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/querygambitidSelections")
    @ResponseBody
    public Object querygambitidSelections(){
        List<Essaythemes> essaythemesList  = new ArrayList<Essaythemes>();
        try {
            essaythemesList = solicitArticlesManService.querygambitidSelections();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return essaythemesList;
    }

    /**
     * 新增征文信息
     * @param solicitarticless
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/InsertSolicitarticless")
    @ResponseBody
    public Object InsertSolicitarticless(Solicitarticless solicitarticless, HttpSession session){
        int inserFlag = 0;
        try {
            Users users = (Users) session.getAttribute("loginUserMsg");
            solicitarticless.setUserqid(users.getUserid());
            inserFlag = solicitArticlesManService.InsertSolicitarticless(solicitarticless);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inserFlag;
    }

    /**
     * 删除话题
     * @param solicitarticless
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/deleteSolicitarticless")
    @ResponseBody
    public Object deleteSolicitarticless(Solicitarticless solicitarticless){
        int deleteFalg = 0;
        try {
            deleteFalg = solicitArticlesManService.deleteSolicitarticless(solicitarticless);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFalg;
    }

    /**
     * 修改征文信息
     * @param solicitarticless
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/updateSolicitarticless")
    @ResponseBody
    public Object updateSolicitarticless(Solicitarticless solicitarticless){
        int updateFalg = 0;
        try {
            updateFalg = solicitArticlesManService.updateSolicitarticless(solicitarticless);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFalg;
    }

    /**
     * 删除征文评论信息
     * @param discusss
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/deleteArticleDiscuss")
    @ResponseBody
    public Object deleteArticleDiscuss(Discusss discusss){
        int deleteFalg = 0;
        try {
            deleteFalg = solicitArticlesManService.deleteArticleDiscuss(discusss);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteFalg;
    }

    /**
     * 修改征文评论信息
     * @param discusss
     * @return
     */
    @RequestMapping("SolicitArticlesManCon/updateArticleDiscuss")
    @ResponseBody
    public Object updateArticleDiscuss(Discusss discusss){
        int updateFalg = 0;
        try {
            updateFalg = solicitArticlesManService.updateArticleDiscuss(discusss);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateFalg;
    }

}
