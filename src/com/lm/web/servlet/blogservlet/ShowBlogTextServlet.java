package com.lm.web.servlet.blogservlet;

import com.lm.dao.impl.BlogDaoImpl;
import com.lm.dao.impl.CommentsDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.Comments;
import com.lm.service.impl.CommentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showBlogTextServlet")
public class ShowBlogTextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Blog blog2 = new BlogDaoImpl().selectBlogById(new Blog(Integer.parseInt(request.getParameter("blogId"))));
        request.setAttribute("blogobj",blog2);
        List<Comments> list = new CommentsDaoImpl().selectCommentsByBlog(blog2);
        List<Comments> comments = new CommentsServiceImpl().showComments(list, blog2);
        System.out.println(comments);
        request.setAttribute("list",comments);
        request.getRequestDispatcher("/blogsystem/blogtext.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
