package com.lm.web.servlet.blogservlet;

import com.lm.dao.impl.BlogDaoImpl;
import com.lm.entity.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeBlogServlet")
public class ChangeBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("id",id);
        Blog blog1 = new BlogDaoImpl().selectBlogById(new Blog(id));
        request.setAttribute("blog",blog1);
        System.out.println(blog1);
        request.getRequestDispatcher("/blogsystem/changeblog.jsp").forward(request,response);
        request.removeAttribute("blog");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
