package org.maker.service;

import org.maker.pojo.Trees;

import java.util.List;

public interface TreesService {
    List<Trees> queryTree(String pid);
}
