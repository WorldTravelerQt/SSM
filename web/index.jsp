<%--
  Created by IntelliJ IDEA.
  User: 血与酒
  Date: 2019/11/29
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <style>
          form{
              width: 450px;
              position: absolute;
              left: 50%;
              margin-left: -225px;
          }
      </style>
    <title>主页</title>
  </head>
  <body>
    <div class="container">

        <div class="page-header">
        </div>
        <div class="col-md-12 column">
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/user/login">
                    <div class="form-group">
                        <label for="inputUname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" name="uname" class="form-control" id="inputUname" placeholder="请输入用户名" required autocomplete="off">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">密　码</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码" required>
                        </div>
                    </div>
                    <div class="form-group" align="center">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" style="margin-right: 15%;">登录</button>
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/user/toRegistPager">注册</a>
                        </div>
                    </div>
                </form>
<%--            <form action="${pageContext.request.contextPath}/books/all" method="post">
                <button type="submit" class="btn btn-default" style="position: absolute;left: 50%;margin-left: -55px;margin-top: 50px">查看所有书籍</button>
            </form>--%>
        </div>
    </div>

  </body>
</html>
