package com.lm.web.servlet.blogservlet;

import com.lm.entity.Blog;
import com.lm.entity.User;
import com.lm.service.BlogService;
import com.lm.service.impl.BlogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doChangeBlogServlet")
public class DoChangeBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Blog blog = new Blog();
        User user = (User) request.getSession().getAttribute("user");
        try {
            BeanUtils.populate(blog, request.getParameterMap());
            blog.setBlogId((Integer)request.getSession().getAttribute("id"));
            blog.setAuthor(user.getId());
            BlogService bs = new BlogServiceImpl();
            bs.changeBlog(blog);
            response.sendRedirect("/manageBlogServlet?currentPage=1&rows=5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
