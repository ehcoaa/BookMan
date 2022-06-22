package com.gzfs.controller;

import com.gzfs.entity.Admin;
import com.gzfs.entity.Book;
import com.gzfs.entity.Borrow;
import com.gzfs.entity.Reader;
import com.gzfs.service.BookService;
import com.gzfs.service.LoginService;
import com.gzfs.service.impl.BookServiceImpl;
import com.gzfs.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
     private LoginService loginService  =new LoginServiceImpl();
     private BookService bookService = new BookServiceImpl();
    /**
     * 接收login.jsp传过来的的post请求，处理登陆逻辑
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        Object object = loginService.Login(username,password,type);
        if (object==null)
        {
            resp.sendRedirect("login.jsp");
        }
        else{
            HttpSession session = req.getSession();
            switch (type)
            {
                //读者登陆
                case "reader":
                    Reader reader = (Reader) object;
                    session.setAttribute("reader",reader);
                    resp.sendRedirect("book?page=1");
                    break;
                //管理员登陆
                case "admin":
                    Admin admin = (Admin) object;
                    session.setAttribute("admin",admin);
                    resp.sendRedirect("admin?method=findAllBorrow&page=1");
                    break;
            }
        }
    }
}
