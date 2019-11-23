package com.lm.web.servlet.blogservlet;

import com.lm.entity.Blog;
import com.lm.entity.PageBean;
import com.lm.service.BlogService;
import com.lm.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAllBlogByPageServlet")
public class ShowAllBlogByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.从前台获得rows和currentPage
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        //把这两个参数传到Service层
        BlogServiceImpl bs = new BlogServiceImpl();
        PageBean<Blog> pb = bs.showAllBlogByPageService(rows,currentPage);
        System.out.println(pb);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/blogsystem/blogcenter.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
