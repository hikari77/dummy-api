package com.bosco.dummyrest.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostVO {
    private Integer userId;
    private Integer id;
    private String title;

    @JsonProperty("body")
    private String content;

    public Integer getUserId() {
        return userId;
    }


    public Integer getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }

    public PostVO() {
    }

    public PostVO(Integer userId, Integer id, String title, String content) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
