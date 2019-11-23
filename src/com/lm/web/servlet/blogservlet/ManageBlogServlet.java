package com.lm.web.servlet.blogservlet;

import com.lm.dao.impl.BlogDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.PageBean;
import com.lm.entity.User;
import com.lm.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/manageBlogServlet")
public class ManageBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getSession().getAttribute("user");
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        PageBean<Blog> pb = new BlogServiceImpl().ShowBlogByUserPage(rows, currentPage, user.getId());
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/blogsystem/editblog.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
