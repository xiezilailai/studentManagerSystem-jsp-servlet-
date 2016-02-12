package com.xiezilailai.example.servlet;

import com.xiezilailai.example.services.stuInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by 蝎子莱莱123 on 2016/2/12.
 */
@WebServlet(name = "queryAllStuServlet")
public class queryAllStuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String osid=request.getParameter("osid");
        if(osid.equals("query")){
            response.sendRedirect("../displaystuinfo.jsp");
        }else if(osid.equals("modify")){
            response.sendRedirect("../modifystuinfo.jsp");
        }else{
            response.sendRedirect("../deletestuinfo.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
