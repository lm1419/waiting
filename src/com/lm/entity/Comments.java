package com.lm.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comments implements Serializable {
    private Integer id;
    private String commentText;
    private Integer authorid;
    private Integer blogId;
    private User user=new User();
    private Blog blog = new Blog();
    Timestamp createTime;

    public Comments() {
    }

    public Comments(Integer id) {
        this.id = id;
    }

    public Comments(Integer id, String commentText, User user, Blog blog, Timestamp createTime) {
        this.id = id;
        this.commentText = commentText;
        this.user = user;
        this.blog = blog;
        this.createTime = createTime;
    }
    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", commentText='" + commentText + '\'' +
                ", authorid=" + authorid +
                ", user=" + user +
                ", blog=" + blog +
                ", createTime=" + createTime +
                '}';
    }

}
