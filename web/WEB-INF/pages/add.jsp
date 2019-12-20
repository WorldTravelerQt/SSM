<%--
  Created by IntelliJ IDEA.
  User: 血与酒
  Date: 2019/11/29
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>添加图书</title>
</head>
<body>
    <div class="container">

        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加图书</small>
                </h1>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/books/add" method="post" autocomplete="off">
            <div class="form-group">
                <label>图书名称</label>
                <input type="text" name="bookName" placeholder="请输入图书名称" required/>
            </div>
            <div class="form-group">
                <label>图书数量</label>
                <input type="text" name="bookCounts" placeholder="请输入图书数量" required/>
            </div>
            <div class="form-group">
                <label>图书详情</label>
                <input type="text" name="detail" placeholder="请输入图书详情" required/>
            </div>
            <button class="btn btn-default" type="submit">添加</button>
        </form>

    </div>
</body>
</html>
