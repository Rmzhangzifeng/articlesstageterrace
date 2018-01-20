package org.maker.service.impl;


import org.maker.dao.DemoPojoMapper;
import org.maker.pojo.DemoPojo;
import org.maker.service.PoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiServiceImpl implements PoiService {

    @Autowired
    private DemoPojoMapper demoPojoMapper;


    @Override
    public List<DemoPojo> queryDate() {
        return demoPojoMapper.queryDate();
    }
}
