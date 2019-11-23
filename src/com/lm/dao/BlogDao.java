package com.lm.dao;

import com.lm.entity.Blog;
import com.lm.entity.User;

import java.util.List;

public interface BlogDao {
    void addBlog(Blog blog);
    List<Blog> selectAllBlogByUserId(int userId);
    List<Blog> selectAllBlog( );
    void deleteBlogById(Integer id);
    void changeBlog(Blog blog);
    Blog selectBlogById(Blog blog);
    int selectTotalCount();
    int selectTotalCountByUserId(int userId);
    List<Blog> selectAllBlogByPage(int start,int rows);
    List<Blog> selectAllBlogByUserIdAndPage(int UserId,int start,int rows);
}
