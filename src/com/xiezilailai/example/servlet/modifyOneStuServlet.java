package com.xiezilailai.example.servlet;

import com.xiezilailai.example.model.stuInfo;
import com.xiezilailai.example.services.stuInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 蝎子莱莱123 on 2016/2/11.
 */
@WebServlet(name = "modifyOneStuServlet")
public class modifyOneStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        stuInfo stu=new stuInfoService().queryStuById(id);
        HttpSession session=request.getSession();
        session.setAttribute("stu",stu);
        response.sendRedirect("../modifyOneStu.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
