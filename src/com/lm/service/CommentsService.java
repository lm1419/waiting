package com.lm.service;

import com.lm.entity.Blog;
import com.lm.entity.Comments;

import java.util.HashMap;
import java.util.List;

public interface CommentsService {
    Comments addComments(Comments comments);
    List<Comments> showComments(List<Comments> list, Blog blog);
}
