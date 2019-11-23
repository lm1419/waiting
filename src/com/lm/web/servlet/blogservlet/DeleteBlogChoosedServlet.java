package com.lm.web.servlet.blogservlet;

import com.lm.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteBlogChoosedServlet")
public class DeleteBlogChoosedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        System.out.println(rows+currentPage);
        String[] blogsids = request.getParameterValues("blogsid");
        new BlogServiceImpl().delBlogsByIds(blogsids);
        response.sendRedirect("/manageBlogServlet?currentPage="+currentPage+"&rows="+rows);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
