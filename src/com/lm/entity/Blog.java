package com.lm.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Blog implements Serializable {
    private Integer blogId;
    private String blogTitle;
    private String blogText;
    private Timestamp createTime;
    private Timestamp changeTime;
    private Integer author;
    private String type;
    private User user;

    public Blog(Integer blogId) {
        this.blogId = blogId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog() {
    }

    public Blog(Integer blogId, String blogTitle, String blogText, Timestamp createTime, Timestamp changeTime, Integer author, String type) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogText = blogText;
        this.createTime = createTime;
        this.changeTime = changeTime;
        this.author = author;
        this.type = type;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogText='" + blogText + '\'' +
                ", createTime=" + createTime +
                ", changeTime=" + changeTime +
                ", author=" + author +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(blogId, blog.blogId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId);
    }
}
