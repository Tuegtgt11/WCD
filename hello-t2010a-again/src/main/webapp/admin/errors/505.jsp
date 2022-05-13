<%--
  Created by IntelliJ IDEA.
  User: vuduc
  Date: 5/13/2022
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
%>
<html>
<head>
    <title><%=message%></title>
</head>
<body>
<h1><%=message%></h1>
<img src="https://cdn.tgdd.vn/hoi-dap/1370525/Thumbnail/loi-http-error-500-la-gi-cach-khac-phuc-loi-http-error-500.thumbnail2.jpg" alt="<%=message%>">
</body>
</html>
