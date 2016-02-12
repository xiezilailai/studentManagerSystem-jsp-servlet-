package com.xiezilailai.example.servlet;

import com.xiezilailai.example.model.stuInfo;
import com.xiezilailai.example.services.stuInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 蝎子莱莱123 on 2016/2/11.
 */
@WebServlet(name = "modifyOneStuInfoServlet")
public class modifyOneStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));

        String nicheng=request.getParameter("nickname");
        String truename=request.getParameter("realname");
        byte xb=Byte.parseByte(request.getParameter("sex"));
        String csrq=request.getParameter("borndate");
        String zy=request.getParameter("profession");
        System.out.println(zy);
        //String kc=request.getParameter("kc");
        String kcs[]=request.getParameterValues("subject");
        String xqs[]=request.getParameterValues("hobby");
        String bz=request.getParameter("remark");
        stuInfo stu=new stuInfo();
        stu.setId(id);
        stu.setNickname(nicheng);
        stu.setRealname(truename);

        stu.setBorndate(csrq);
        if(csrq.equals(""))
            stu.setBorndate(null);
        if(kcs!=null)
            stu.setSubject(kcs);
        if(xqs!=null)
            stu.setHobby(xqs);
        stu.setRemark(bz);
        stu.setProfession(zy);
        stu.setSex(xb);
        if(new stuInfoService().updateStu(stu))
            response.sendRedirect("../modifyOneStu_success.jsp");
        else
            response.sendRedirect("../modifyOneStu.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
