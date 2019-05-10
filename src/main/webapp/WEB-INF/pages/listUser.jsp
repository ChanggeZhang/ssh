<%--
  Created by IntelliJ IDEA.
  User: Chang
  Date: 2019/5/8
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <style type="text/css">
        th,td{
            height: max-content;
            max-width: 2%;
            word-break: break-all;
            vertical-align: middle;
            text-align: center;
            padding: 3px;
            margin:0;
        }

        th{
            background-color: #d4d4d4;
        }
    </style>
</head>
<body>
   <table>
       <thead>
           <tr>
               <th>序号</th>
               <th>账号</th>
               <th>昵称</th>
               <th>姓名</th>
               <th>联系电话</th>
               <th>注册时间</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${userEntityList}" var="user" step="1" varStatus="index" begin="0">
            <tr>
                <td>${user.id }</td>
                <td>${user.account }</td>
                <td>${user.nickName }</td>
                <td>${user.userName }</td>
                <td>${user.mobileNo }</td>
                <td>${user.createTime }</td>
            </tr>
       </c:forEach>
       </tbody>
   </table>
</body>
</html>
