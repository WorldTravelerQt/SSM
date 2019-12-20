<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 血与酒
  Date: 2019/11/29
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <title>图书主页</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#searchInput").on("keyup",function () {
                $("#popDiv").css("display","");
                var bookName=$(this).val();
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"http://localhost:8080/SSM_war_exploded/books/searchTips",
                    data:{bookName:bookName},
                    success:function (result) {
                        console.info(result);
                        $("#popDiv").text("");
                        for (var i=0;i<result.length;i++)
                        {
                            $("#popDiv").append($("<span></span>").text(result[i].bookName).css("display","block").addClass("popSpan"));
                            $(".popSpan")
                              .on("mouseover",function () {
                                $(this).css("background","beige").css("cursor","pointer");
                            }).on("mouseout",function () {
                                $(this).css("background","azure");
                            }).on("mousedown",function () {
                                $("#searchInput").val($(this).text());
                            });
                            console.info("popSpan"+i);
                        }
                    }
                });
            });
            $("#searchInput").on("blur",function () {
                $("#popDiv").css("display","none");
            });
        });
    </script>
    <style>
        #searchInput{
            width: 400px;
        }
        #popDiv{
            width: 400px;
            position: absolute;
            z-index: 1000;
            margin-top: -14px;
            border: 1px solid #cccccc;
            background: azure;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>图书列表</small>
                    </h1>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/toAddPager">新增图书</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/all">显示全部</a>
            </div>
            <div class="col-md-6 column">
                <form class="form-inline" action="${pageContext.request.contextPath}/books/searchByName" method="post">
                    <input class="form-control" id="searchInput" placeholder="请输入书名" name="bookName" autocomplete="off"/>
                    <input class="btn btn-primary" type="submit" value="搜索"/>
                </form>
                <div id="popDiv" style="display: none;">
                    <%-- 动态的智能提示内容显示在这 --%>
                </div>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <c:choose>
                    <c:when test="${empty books}">
                        <span class="form-control" style="color: red;text-align: center">没有找到相关书籍!</span>
                    </c:when>
                    <c:otherwise>
                        <table class="table table-hover table-striped">
                            <thead>
                            <tr>
                                <th>图书编号</th>
                                <th>图书名称</th>
                                <th>图书数量</th>
                                <th>图书详情</th>
                                <th>操　　作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${books}" var="book">
                                <tr>
                                    <td>${book.bookId}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.bookCounts}</td>
                                    <td>${book.detail}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/books/toUpdatePager?bookId=${book.bookId}">修改</a> |
                                        <a href="${pageContext.request.contextPath}/books/delete?bookId=${book.bookId}">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</body>
</html>
