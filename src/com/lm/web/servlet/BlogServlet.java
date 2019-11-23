package com.lm.web.servlet;

import com.lm.dao.UserDao;
import com.lm.dao.impl.BlogDaoImpl;
import com.lm.dao.impl.CommentsDaoImpl;
import com.lm.dao.impl.UserDaoImpl;
import com.lm.entity.Blog;
import com.lm.entity.Comments;
import com.lm.entity.User;
import com.lm.service.BlogService;
import com.lm.service.UserService;
import com.lm.service.impl.BlogServiceImpl;
import com.lm.service.impl.CommentsServiceImpl;
import com.lm.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/blogServlet")
public class BlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String cast = request.getParameter("cast");
        User user = (User) request.getSession().getAttribute("user");
        BlogServiceImpl blogService = new BlogServiceImpl();
        switch (cast) {
            case "newblog":
                Blog blog = new Blog();
                Map<String, String[]> map = request.getParameterMap();
                try {
                    BeanUtils.populate(blog, map);
                    blog.setAuthor(user.getId());
                    blogService.addBlog(blog);
                    response.sendRedirect("/blogServlet?cast=showmyblog");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case "editblog":
                User u = (User) request.getSession().getAttribute("user");
                List<Blog> blogs = new BlogDaoImpl().selectAllBlogByUserId(u.getId());
                request.getSession().setAttribute("blogList",blogs);
                request.getRequestDispatcher("/blogsystem/editblog.jsp").forward(request,response);
                break;
            case "deleteblog":
                Integer id = Integer.parseInt(request.getParameter("id"));
                new BlogDaoImpl().deleteBlogById(id);
                response.sendRedirect("/blogServlet?cast=editblog");
                break;
            case "change":
                int id1 = Integer.parseInt(request.getParameter("id"));
                request.getSession().setAttribute("id",id1);
                Blog blog1 = new BlogDaoImpl().selectBlogById(new Blog(id1));
                request.setAttribute("blog",blog1);
                System.out.println(blog1);
                request.getRequestDispatcher("/blogsystem/changeblog.jsp").forward(request,response);
                request.removeAttribute("blog");
                break;
            case "changeblog":
                blog = new Blog();
                map = request.getParameterMap();
                try {
                    BeanUtils.populate(blog, map);
                    Integer id2 = (Integer)request.getSession().getAttribute("id");
                    blog.setBlogId(id2);
                    blog.setAuthor(user.getId());
                    BlogService bs = new BlogServiceImpl();
                    bs.changeBlog(blog);
                    response.sendRedirect("/blogServlet?cast=editblog");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                break;
            case "showmyblog":
                blogs = new BlogDaoImpl().selectAllBlogByUserId(user.getId());
                request.setAttribute("myBlogList",blogs);
                request.getRequestDispatcher("/blogsystem/reviewmyblog.jsp").forward(request,response);
                break;
            case "showallblog":
                System.out.println("OK");
                blogs = new BlogDaoImpl().selectAllBlog();
                request.setAttribute("allBlogList",blogs);
                request.getRequestDispatcher("/blogsystem/blogcenter.jsp").forward(request,response);
                break;
            case "showblogtext":
                id  = Integer.parseInt(request.getParameter("blogId"));
                blog= new Blog(id);
                Blog blog2 = new BlogDaoImpl().selectBlogById(blog);
                request.setAttribute("blogobj",blog2);
                List<Comments> list = new CommentsDaoImpl().selectCommentsByBlog(blog2);
                List<Comments> comments = new CommentsServiceImpl().showComments(list, blog2);
                System.out.println(comments);
                request.setAttribute("list",comments);
                request.getRequestDispatcher("/blogsystem/blogtext.jsp").forward(request,response);
                break;
            case "delchoosed":
                String[] blogsids = request.getParameterValues("blogsid");
                blogService.delBlogsByIds(blogsids);
                response.sendRedirect("/blogServlet?cast=editblog");
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
