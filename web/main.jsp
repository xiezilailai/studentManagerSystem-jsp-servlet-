<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<jsp:include page="islogin.jsp"></jsp:include>
main
<a href="inputstuinfo.jsp">录入学生信息</a><br>
<a href="student/queryallstu?osid=query">查看学生信息</a><br>
<a href="student/queryallstu?osid=modify">修改学生信息</a><br>
<a href="student/queryallstu?osid=delete">删除学生信息</a><br>
<a href="user/exitServlet" target="_top">退出</a><br>
</body>
</html>