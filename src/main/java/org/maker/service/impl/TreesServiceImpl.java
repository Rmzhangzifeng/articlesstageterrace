package org.maker.service.impl;


import org.maker.dao.TreesMapper;
import org.maker.pojo.Trees;
import org.maker.service.TreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreesServiceImpl implements TreesService {
    @Autowired
    private TreesMapper treesMapper;
    @Override
    public List<Trees> queryTree(String pid) {
        List<Trees> trees = treesMapper.queryByPid(pid);
//      判断查询到数据，则循环操作
        if(trees != null && trees.size()>0){
            for (int i = 0; i < trees.size(); i++) {
//              根据当前节点id查询新的子集列表，
                List<Trees> trees2 = queryTree(trees.get(i).getId());
//              将列表set到当前树节点对象中
                trees.get(i).setNodes(trees2);
            }
        }
        return trees;
    }
}
