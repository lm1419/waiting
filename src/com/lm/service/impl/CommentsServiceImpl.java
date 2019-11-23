package com.lm.service.impl;

import com.lm.dao.impl.BlogDaoImpl;
import com.lm.dao.impl.CommentsDaoImpl;
import com.lm.dao.impl.UserDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.Comments;
import com.lm.entity.User;
import com.lm.service.CommentsService;
import java.sql.Timestamp;
import java.util.List;

public class CommentsServiceImpl implements CommentsService {
    private CommentsDaoImpl cd = new CommentsDaoImpl();
    private UserDaoImpl ud = new UserDaoImpl();
    private BlogDaoImpl bd = new BlogDaoImpl();

    @Override
    public Comments addComments(Comments comments) {
        comments.setCreateTime(new Timestamp(System.currentTimeMillis()));
        new CommentsDaoImpl().addComments(comments);
        return comments;
    }

    @Override
    public List<Comments> showComments(List<Comments> list,Blog blog) {
        List<Comments> commentsList = new CommentsDaoImpl().selectCommentsByBlog(blog);
        for (Comments c:commentsList){
            c.setUser(new UserDaoImpl().selectByUserId(new User(c.getAuthorid())));
            c.setBlog(new BlogDaoImpl().selectBlogById(new Blog(c.getBlogId())));
        }
        return commentsList;
    }
}
