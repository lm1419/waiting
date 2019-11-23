package com.lm.dao;

import com.lm.entity.Blog;
import com.lm.entity.Comments;
import com.lm.entity.User;

import java.util.List;

public interface CommentsDao {
    void addComments(Comments comments);
    List<Comments> selectCommentsByBlog(Blog blog);
    void deleteComments(Comments comments);

}
