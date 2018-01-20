package org.maker.pojo;

public class Frequencycomments {
    private Integer frequencycommentid;

    private String frequencycontents;

    private Integer userhid;

    private Integer frequencyzid;

    public Integer getFrequencycommentid() {
        return frequencycommentid;
    }

    public void setFrequencycommentid(Integer frequencycommentid) {
        this.frequencycommentid = frequencycommentid;
    }

    public String getFrequencycontents() {
        return frequencycontents;
    }

    public void setFrequencycontents(String frequencycontents) {
        this.frequencycontents = frequencycontents == null ? null : frequencycontents.trim();
    }

    public Integer getUserhid() {
        return userhid;
    }

    public void setUserhid(Integer userhid) {
        this.userhid = userhid;
    }

    public Integer getFrequencyzid() {
        return frequencyzid;
    }

    public void setFrequencyzid(Integer frequencyzid) {
        this.frequencyzid = frequencyzid;
    }
}