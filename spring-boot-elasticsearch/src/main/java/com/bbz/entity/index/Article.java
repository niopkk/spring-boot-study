package com.bbz.entity.index;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Set;

@Document(indexName = "article", type = "article")
public class Article {

    /**
     * 自增
     */
    @Field(type = FieldType.Text, index = false)
    private String id;

    /**
     * 文章id
     */
    @Field(type = FieldType.Text, index = false)
    private String articleId;

    /**
     * 用户id
     */
    @Field(type = FieldType.Text, index = false)
    private String userId;

    /**
     * 是否隐藏
     */
    @Field(type = FieldType.Boolean, index = false)
    private Boolean hidden;

    /**
     * 文章时间
     */
    @Field(type = FieldType.Date, index = false)
    private Date postDate;

    /**
     * 文章标题
     */
    @Field(type = FieldType.Text, index = false)
    private String title;

    /**
     * 文章内容
     */
    @Field(type = FieldType.Text, index = false)
    private String content;

    /**
     * 浏览量
     */
    @Field(type = FieldType.Integer, index = false)
    private Integer viewCnt;

    /**
     * 文章类型
     */
    @Field(type = FieldType.Text, index = false)
    private Set<String> types;


    /**
     * 子标题
     */
    @Field(type = FieldType.Text, index = false)
    private String subtitle;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
