package com.xiezilailai.example.servlet;

import com.xiezilailai.example.model.stuInfo;
import com.xiezilailai.example.services.stuInfoService;
import com.xiezilailai.example.services.userservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 蝎子莱莱123 on 2016/2/11.
 */
public class inputStuInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String nickName=req.getParameter("nickname");
        String realName=req.getParameter("realname");
        byte sex=Byte.parseByte(req.getParameter("sex"));
        String bornDate=req.getParameter("borndate");
        String profession=req.getParameter("profession");
        String[] subjects=req.getParameterValues("subject");
        String[] hobbies=req.getParameterValues("hobby");
        String remark=req.getParameter("remark");

        stuInfo stu=new stuInfo();
        stu.setNickname(nickName);
        stu.setRealname(realName);
        stu.setSex(sex);
        stu.setBorndate(bornDate);
        stu.setProfession(profession);

//        String subject="";
//        for(int i=0;i<subjects.length;i++){
//            subject+=subjects[i]+"&";
//        }
//        subject=subject.substring(0,subject.length()-1);
        stu.setSubject(subjects);
        stu.setHobby(hobbies);
        stu.setRemark(remark);
        if(new stuInfoService().addStu(stu)){
            resp.sendRedirect("../inputStuInfo_success.jsp");
        }else{
            resp.sendRedirect("../inputstuinfo.jsp");
        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
