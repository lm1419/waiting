package com.lm.dao.impl;

import com.lm.dao.BlogDao;
import com.lm.entity.Blog;
import com.lm.entity.User;
import com.lm.utils.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Properties;
import java.util.Queue;

public class BlogDaoImpl implements BlogDao {
    JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    String sql = "";

    @Override
    public void addBlog(Blog blog) {
        String sql = "INSERT INTO blog VALUES(?,?,?,?,?,?,?)";
        try {
            template.update(sql, blog.getBlogId(), blog.getBlogTitle(), blog.getBlogText(), blog.getCreateTime(), blog.getChangeTime(), blog.getAuthor(), blog.getType());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /*
        查询某个user的所有博客
     */
    @Override
    public List<Blog> selectAllBlogByUserId(int id) {
        String sql = "SELECT * FROM blog,user WHERE blog.author=user.id AND blog.author=? ORDER BY blog.createTime DESC";
        List<Blog> blogList = template.query(sql, new BeanPropertyRowMapper<>(Blog.class), id);
        return blogList;

    }

    @Override
    public List<Blog> selectAllBlog() {
        sql = "SELECT * FROM blog ORDER BY blog.createTime DESC";
        List<Blog> blogList = template.query(sql, new BeanPropertyRowMapper<>(Blog.class));
        for (Blog b : blogList) {
            Integer author = b.getAuthor();
            sql = "SELECT * FROM user WHERE id=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), author);
            b.setUser(user);
        }
        return blogList;
    }

    @Override
    public void deleteBlogById(Integer id) {
        sql = "DELETE FROM blog WHERE blogId=?";
        template.update(sql,id);
    }

    @Override
    public void changeBlog(Blog blog) {
        System.out.println(blog.getBlogId());
        sql = "UPDATE blog SET blogTitle=?,blogText=?,changeTime=?,type=? WHERE blogId=?";
        try {
            template.update(sql, blog.getBlogTitle(), blog.getBlogText(), blog.getChangeTime(), blog.getType(), blog.getBlogId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Blog selectBlogById(Blog blog) {
        sql = "SELECT * FROM blog WHERE blogId=?";
        Blog resultBlog = template.queryForObject(sql, new BeanPropertyRowMapper<>(Blog.class), blog.getBlogId());
        Integer author = resultBlog.getAuthor();
        sql = "SELECT * FROM user WHERE id=?";
        User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), author);
        resultBlog.setUser(user1);
        return resultBlog;
    }

    @Override
    public int selectTotalCount() {
        sql = "SELECT COUNT(*) FROM blog";
        return template.queryForObject(sql, Integer.class);

    }

    @Override
    public int selectTotalCountByUserId(int userId) {
        sql = "SELECT COUNT(*) FROM blog WHERE author = ? ";
        return template.queryForObject(sql,Integer.class,userId);
    }

    @Override
    public List<Blog> selectAllBlogByPage(int start, int rows) {
        sql = "SELECT * FROM blog ORDER BY createTime DESC LIMIT ?,?";
        return template.query(sql,new BeanPropertyRowMapper<>(Blog.class),start,rows);
    }

    @Override
    public List<Blog> selectAllBlogByUserIdAndPage(int userId,int start, int rows) {
        sql = "SELECT * FROM blog WHERE author = ? ORDER BY createTime DESC LIMIT ?,?";
        return template.query(sql,new BeanPropertyRowMapper<>(Blog.class),userId,start,rows);
    }
}
