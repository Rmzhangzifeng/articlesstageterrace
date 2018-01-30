package org.maker.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.maker.dao.EditsMapper;
import org.maker.pojo.Edits;
import org.maker.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EditServiceImpl implements EditService {
@Autowired
private EditsMapper editsMapper;
    @Override
    public JSONObject queryedittable(int page, int rows) {
        long totalCount = editsMapper.queryTotal();
//		当前页数据————————oracle分页   关键字 rownum    两个参数：起始位置、结束位置
//		起始位置 =（当前页-1）*每页条数
        int start = (page-1)*rows;
//		结束位置 = 起始位置+每页条数
        int end = start + rows;
//		查询当前页数据
        List<Edits> students = editsMapper.queryStudentPage(start,end);

        JSONObject json = new JSONObject();
        json.put("total", totalCount);
        json.put("rows", students);
        return json;
    }

    @Override
    public List<Edits> queryeditsybq(int s) {
        List<Edits> edits = editsMapper.queryByPidybq(s);
//      判断查询到数据，则循环操作
        if(edits != null && edits.size()>0){
            for (int i = 0; i < edits.size(); i++) {
//              根据当前节点id查询新的子集列表，
                List<Edits> edits1 = queryeditsybq(edits.get(i).getId());
//              将列表set到当前树节点对象中
                edits.get(i).setNodes(edits1);
            }
        }
        return edits;
    }

    @Override
    public int insertedits(Edits edits) {

        return editsMapper.insertedits(edits);
    }


}
