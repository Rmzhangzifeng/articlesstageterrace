package org.maker.dao;


import org.maker.pojo.Trees;

import java.util.List;

public interface TreesMapper {
    List<Trees> queryByPid(String pid);
}