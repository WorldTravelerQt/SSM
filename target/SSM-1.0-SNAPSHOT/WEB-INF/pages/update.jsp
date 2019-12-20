<%--
  Created by IntelliJ IDEA.
  User: 血与酒
  Date: 2019/11/29
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>修改图书</title>
</head>
<body>
    <div class="container">

        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改图书</small>
                </h1>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/books/update" method="post">
            <input type="hidden" name="bookId" value="${book.bookId}">
            <div class="form-group">
                <label>图书名称</label>
                <input type="text" name="bookName" value="${book.bookName}" required/>
            </div>
            <div class="form-group">
                <label>图书数量</label>
                <input type="text" name="bookCounts" value="${book.bookCounts}" required/>
            </div>
            <div class="form-group">
                <label>图书详情</label>
                <input type="text" name="detail" value="${book.detail}" required/>
            </div>
            <button type="submit" class="btn btn-default">修改</button>
        </form>

    </div>
</body>
</html>
