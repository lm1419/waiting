package com.lm.web.servlet.blogservlet;

import com.lm.entity.Blog;
import com.lm.entity.User;
import com.lm.service.impl.BlogServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addBlogServlet")
public class AddBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Blog blog = new Blog();
        User user = (User) request.getSession().getAttribute("user");
        Map<String, String[]> map = request.getParameterMap();
        BlogServiceImpl blogService = new BlogServiceImpl();
        try {
            BeanUtils.populate(blog, map);
            blog.setAuthor(user.getId());
            blogService.addBlog(blog);
            response.sendRedirect("/manageBlogServlet?currentPage=1&rows=5");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
