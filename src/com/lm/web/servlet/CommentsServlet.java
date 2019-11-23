package com.lm.web.servlet;

import com.lm.dao.impl.CommentsDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.Comments;
import com.lm.entity.User;
import com.lm.service.impl.CommentsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/commentsServlet")
public class CommentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getParameter("cast")){
            case "newcomments":
                String pinglun = request.getParameter("pinglun");
                Integer blogid = Integer.parseInt(request.getParameter("blogid"));
                User user = (User)request.getSession().getAttribute("user");
                Comments comments1 = new Comments();
                comments1.setCommentText(pinglun);
                comments1.setBlogId(blogid);
                comments1.setAuthorid(user.getId());
                System.out.println(user);
                new CommentsServiceImpl().addComments(comments1);
                response.sendRedirect("/blogServlet?blogId="+blogid+"&cast=showblogtext");
                break;
            case "delete":
                Integer bid = Integer.parseInt(request.getParameter("bid"));
                Integer id = Integer.parseInt(request.getParameter("cid"));
                Comments comments = new Comments();
                comments.setId(id);
                CommentsDaoImpl commentsDao = new CommentsDaoImpl();
                commentsDao.deleteComments(comments);
                response.sendRedirect("/blogServlet?blogId="+bid+"&cast=showblogtext");
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
