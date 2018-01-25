package org.maker.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SolicitArt")
public class SolicitarticlessMongoContent {
    @Id
    private String id;

    private int contentId;

    private String clessContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getClessContent() {
        return clessContent;
    }

    public void setClessContent(String clessContent) {
        this.clessContent = clessContent;
    }
}
