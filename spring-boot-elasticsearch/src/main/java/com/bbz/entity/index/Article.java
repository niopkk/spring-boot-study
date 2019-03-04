package com.bbz.entity.index;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "article", type = "article")
public class Article {

    /**
     * 自增
     */
    @Field(type = FieldType.Text)
    private String id;

    /**
     * 文章id
     */
    @Field(type = FieldType.Text)
    private String articleId;

    /**
     * 用户id
     */
    @Field(type = FieldType.Text)
    private Long userId;

    /**
     * 是否隐藏
     */
    @Field(type = FieldType.Boolean)
    private Boolean hidden;

    /**
     * 文章时间
     */
    @Field(type = FieldType.Long)
    private Long postDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }


    public Long getPostDate() {
        return postDate;
    }

    public void setPostDate(Long postDate) {
        this.postDate = postDate;
    }

}
