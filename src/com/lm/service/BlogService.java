package com.lm.service;

import com.lm.entity.Blog;
import com.lm.entity.PageBean;
import com.lm.entity.User;

public interface BlogService {
    void addBlog(Blog blog);
    void changeBlog(Blog blog);
    void delBlogsByIds(String[] ids);
    PageBean<Blog> showAllBlogByPageService(String _rows,String _currentPage);
    PageBean<Blog> ShowBlogByUserPage(String _rows, String _currentPage, int userId);
}
