<%--
  Created by IntelliJ IDEA.
  User: 血与酒
  Date: 2019/12/1
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>用户注册</title>
</head>
<body>
    <div class="container">

        <div class="page-header"></div>
        <div class="col-md-12 column">
            <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/user/regist">
                <div class="form-group">
                    <label for="inputUname" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" name="uname" class="form-control" id="inputUname" placeholder="请输入用户名" required autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-sm-2 control-label">密　码</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码" required autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-sm-2 control-label">邮　箱</label>
                    <div class="col-sm-10">
                        <input type="email" name="email" class="form-control" id="inputEmail" placeholder="请输入邮箱" required autocomplete="off">
                    </div>
                </div>
                <div class="form-group" align="center">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" style="margin-right: 15%;">注册</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</body>
</html>
