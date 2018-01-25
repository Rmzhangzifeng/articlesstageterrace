package org.maker.service;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.Essaythemes;
import org.maker.pojo.Frequencys;
import org.maker.pojo.Picthemes;

public interface ReviewServiceYM {

    JSONObject queryBookPage(int page, int rows, Essaythemes essaythemes);

    JSONObject queryPictheme(int page, int rows, Picthemes picthemes);

    JSONObject queryFrequency(int page, int rows, Frequencys frequencys);

    int updateEssaytheme(Essaythemes essaythemes);

    int updatePicthemeYm(Picthemes picthemes);

    int updateFrequencyYm(Frequencys frequencys);

    JSONObject queryEssaythemess(int page, int rows, Essaythemes essaythemes);

    JSONObject queryPicthemess(int page, int rows, Picthemes picthemes);

    JSONObject queryFrequencyss(int page, int rows, Frequencys frequencys);

    int updateAllStaffFrequencyYM(Frequencys frequencys);

    int updateAllStaffEssaythemeYM(Essaythemes essaythemes);

    int updateStaffAllPicthemeYM(Picthemes picthemes);
}