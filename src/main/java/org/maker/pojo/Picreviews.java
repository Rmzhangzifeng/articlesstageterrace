package org.maker.pojo;

public class Picreviews {
    private Integer picreviewid;

    private String picreviewcontent;

    private Integer usernid;

    private Integer picphotosid;

    private Integer pictopicszid;

    public Integer getPicreviewid() {
        return picreviewid;
    }

    public void setPicreviewid(Integer picreviewid) {
        this.picreviewid = picreviewid;
    }

    public String getPicreviewcontent() {
        return picreviewcontent;
    }

    public void setPicreviewcontent(String picreviewcontent) {
        this.picreviewcontent = picreviewcontent == null ? null : picreviewcontent.trim();
    }

    public Integer getUsernid() {
        return usernid;
    }

    public void setUsernid(Integer usernid) {
        this.usernid = usernid;
    }

    public Integer getPicphotosid() {
        return picphotosid;
    }

    public void setPicphotosid(Integer picphotosid) {
        this.picphotosid = picphotosid;
    }

    public Integer getPictopicszid() {
        return pictopicszid;
    }

    public void setPictopicszid(Integer pictopicszid) {
        this.pictopicszid = pictopicszid;
    }
}