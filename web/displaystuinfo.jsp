<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.xiezilailai.example.model.stuInfo" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xiezilailai.example.services.stuInfoService" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<%
    stuInfoService stuInfoService=new stuInfoService();
    List stus=(List)stuInfoService.queryAllStu();
//    List stus= (List) session.getAttribute("stus");
//    out.print(stus.size());
    Iterator iter=stus.iterator();

%>
<table>
    <tr>
        <td>id</td>
        <td>nickName</td>
        <td>realName</td>
        <td>sex</td>
        <td>bornDate</td>
        <td>profession</td>
        <td>subjects</td>
        <td>hobbies</td>
        <td>remarks</td>
    </tr>
    <%
        int i=0;
        while (iter.hasNext()){
            stuInfo student=(com.xiezilailai.example.model.stuInfo)iter.next();
    %>
    <tr <%if (i%2==0){%>bgcolor="#F0F8FF"<%}%>>
        <td><%=student.getId()%></td>
        <td><%=student.getNickname()%></td>
        <td><%=student.getRealname()%></td>
        <td>
            <%
                if (student.getSex() == 1)
                    out.print("man");
                else
                    out.print("woman");
            %>
        </td>
        <td><%=student.getBorndate()%></td>
        <td><%=student.getProfession()%></td>
        <td><%=student.getSubjects()%></td>
        <td><%=student.getHobbies()%></td>
        <td><%=student.getRemark()%></td>
    </tr>
    <%i++;
        }%>

</table>
</body>
</html>