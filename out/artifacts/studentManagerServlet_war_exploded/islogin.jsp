<%@ page import="com.xiezilailai.example.model.UserTable" %>
<%@ page import="sun.rmi.server.UnicastServerRef" %><%--
  Created by IntelliJ IDEA.
  User: 蝎子莱莱123
  Date: 2016/2/10
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserTable user=(UserTable)session.getAttribute("user");
    if(user==null){
        %>
<jsp:forward page="index.jsp"></jsp:forward>
<%
    }

%>