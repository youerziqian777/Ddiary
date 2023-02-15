package com.springTest.test.dao;

/**
 * 文章概括类
 **/
public class ArticleShowDao {
    private int cid; // 内容id
    private String specialColumnId; // 专栏id
    private String tag; // tag
    private String title; // 文章标题
    private int uid; // 用户id

    private ArticleContentDao articleContentDao; // 文章内容

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSpecialColumnId() {
        return specialColumnId;
    }

    public void setSpecialColumnId(String specialColumnId) {
        this.specialColumnId = specialColumnId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public ArticleContentDao getArticleContentDao() {
        return articleContentDao;
    }

    public void setArticleContentDao(ArticleContentDao articleContentDao) {
        this.articleContentDao = articleContentDao;
    }
}
