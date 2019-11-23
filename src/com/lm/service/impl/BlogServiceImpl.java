package com.lm.service.impl;

import com.lm.dao.BlogDao;
import com.lm.dao.impl.BlogDaoImpl;
import com.lm.dao.impl.UserDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.PageBean;
import com.lm.entity.User;
import com.lm.service.BlogService;

import javax.crypto.interfaces.PBEKey;
import java.sql.Timestamp;
import java.util.List;

public class BlogServiceImpl implements BlogService {

    BlogDao blogDao = new BlogDaoImpl();

    @Override
    public void addBlog(Blog blog) {
        blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
        blog.setChangeTime(new Timestamp(System.currentTimeMillis()));
        blogDao.addBlog(blog);
    }

    @Override
    public void changeBlog(Blog blog) {
        blog.setChangeTime(new Timestamp(System.currentTimeMillis()));
        blogDao.changeBlog(blog);

    }

    @Override
    public void delBlogsByIds(String[] ids) {
        for (String id : ids) {
            blogDao.deleteBlogById(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<Blog> showAllBlogByPageService(String _rows, String _currentPage) {
        PageBean<Blog> blogPageBean = new PageBean<>();
        int rows = Integer.parseInt(_rows);
        blogPageBean.setRows(rows);
        int currentPage = Integer.parseInt(_currentPage);
        blogPageBean.setCurrentPage(currentPage);

        List<Blog> blogs = new BlogDaoImpl().selectAllBlogByPage((currentPage - 1) * rows, rows);
        for (Blog blog:blogs){
            blog.setUser(new UserDaoImpl().selectByUserId(new User(blog.getAuthor())));
        }
        blogPageBean.setList(blogs);
        int totalCount = new BlogDaoImpl().selectTotalCount();
        blogPageBean.setTotalCount(new BlogDaoImpl().selectTotalCount());
        int totalPage = (totalCount) % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        blogPageBean.setTotalPage(totalPage);
        return blogPageBean;
    }

    @Override
    public PageBean<Blog> ShowBlogByUserPage(String _rows, String _currentPage, int userId) {
        PageBean<Blog> pb = new PageBean<>();
        int rows = Integer.parseInt(_rows);
        int currentPage = Integer.parseInt(_currentPage);
        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        List<Blog> blogs = blogDao.selectAllBlogByUserIdAndPage(userId, (currentPage - 1) * rows, rows);
        for (Blog blog:blogs){
            blog.setUser(new UserDaoImpl().selectByUserId(new User(blog.getAuthor())));
        }
        pb.setList(blogs);
        int totalCount = blogDao.selectTotalCountByUserId(userId);
        pb.setTotalCount(totalCount);
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
