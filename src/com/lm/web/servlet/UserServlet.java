package com.lm.web.servlet;

import com.lm.dao.impl.UserDaoImpl;
import com.lm.entity.User;
import com.lm.service.UserService;
import com.lm.service.impl.UserServiceImpl;
import com.lm.utils.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * @author lm
 * @version V1.0
 * @Package ${PACKAGE_NAME}
 * @date 2019/11/4 16:32
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String cast = request.getParameter("cast");
        User user=new User();
        Map<String, String[]> map = request.getParameterMap();
        UserService us = new UserServiceImpl();
        UserDaoImpl ud = new UserDaoImpl();

        switch (cast){
            case "register":
                System.out.println(request.getParameter("birthday"));
                ConvertUtils.register(new MyDateConverter(), Date.class);
                try {
                    BeanUtils.populate(user, map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                try {
                    us.register(user);
                    response.getWriter().print("<script>alert('注册成功，即将跳到登录页面');window.location.href='/login.jsp'</script>");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.getWriter().print("<script>alert('注册失败！请重新注册');window.location.href='/register.jsp'</script>");
                }
                break;
            case "login":
                try {
                    BeanUtils.populate(user,map);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                String a=(String)(request.getSession().getAttribute("code"));
                String b=(String)(request.getParameter("vcode"));
                System.out.println(a);
                System.out.println(b);
                if (a.toLowerCase().equals(b.toLowerCase())){
                User loginUser = us.findUserByUsernameAndPassword(user);
                if (loginUser!=null){
                    request.getSession().setAttribute("user",loginUser);
                    response.sendRedirect("/blogsystem/menu.jsp");
                }else {
                    response.getWriter().print("<script>alert('用户名或密码错误!');window.location.href='/login.jsp'</script>");
                }}
                else {
                    response.getWriter().print("<script>alert('验证码错误!');window.location.href='/login.jsp'</script>");
                }
                break;
            case "forget":
                HttpSession session = request.getSession();
                String userName = request.getParameter("userName");
                user.setUserName(userName);
                User forget = us.forget(user);
                if (forget!= null) {
                    session.setAttribute("user", forget);
                    request.getRequestDispatcher("/forget2.jsp").forward(request, response);
                } else {
                    response.getWriter().print("<script>alert('没有此用户!');window.location.href='/forget.jsp'</script>");
                }
                break;
            case "forget2":
                User user2 = (User)request.getSession().getAttribute("user");
                System.out.println(user2);
                userName = user2.getUserName();
                String answer = request.getParameter("answer");
                String passWord = request.getParameter("passWord");
                user.setUserName(userName);
                user.setAnswer(answer);
                ud=new UserDaoImpl();
                User user1 = us.forgetAnswer(user);
                System.out.println(user1);
                if (user1 != null) {
                    user1.setPassWord(passWord);
                    ud.forget(user1);
                    response.sendRedirect("/login.jsp");
                } else {
                    response.getWriter().print("<script>alert('密保问题错误!');window.location.href='/forget.jsp'</script>");
                }
                break;
            case "ajax":
                System.out.println("abc");
                String name=request.getParameter("name");
                System.out.println("abcd");
                user = new User();
                user.setUserName(name);
                User u = ud.selectByUserName(user);
                System.out.println(u);
                if (u!=null){
                    response.getWriter().print("1");
                }else {
                    response.getWriter().print("0");
                }
                break;
            case "exit":
                request.getSession().removeAttribute("user");
                response.sendRedirect("/login.jsp");
                break;
            case "query":
                Integer id = Integer.parseInt(request.getParameter("userid"));
                User user3 = new UserDaoImpl().selectByUserId(new User(id));
                request.setAttribute("user",user3);
                request.getRequestDispatcher("/blogsystem/peoplecenter.jsp").forward(request,response);
                break;


        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
