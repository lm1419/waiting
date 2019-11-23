package com.lm.web.servlet.blogservlet;

import com.lm.dao.impl.BlogDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBlogServlet")
public class DeleteBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        new BlogDaoImpl().deleteBlogById(id);
        response.sendRedirect("/manageBlogServlet?currentPage=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
