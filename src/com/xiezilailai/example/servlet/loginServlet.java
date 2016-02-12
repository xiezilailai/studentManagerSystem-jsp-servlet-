package com.xiezilailai.example.servlet;

import com.xiezilailai.example.conn;
import com.xiezilailai.example.model.UserTable;
import com.xiezilailai.example.services.userservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 蝎子莱莱123 on 2016/2/11.
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserTable user=new UserTable();
        user.setUsername(username);
        user.setPassword(password);

        try {
            if(new userservice().validUser(user)){
                HttpSession session=req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("../main.jsp");
            }else{
                resp.sendRedirect("../index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
