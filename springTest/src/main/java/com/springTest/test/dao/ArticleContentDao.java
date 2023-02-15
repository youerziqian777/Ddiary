package com.springTest.test.dao;

/**
 * 文章内容表
 **/
public class ArticleContentDao
{
    private int cid; // 内容id
    private String text; // 文章内容

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
