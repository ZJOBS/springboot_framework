<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="i" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/jsp/common/index.jsp"></jsp:include>
    <meta charset="UTF-8">
    <title>HOME</title>
    <style type="text/css">
        #page_button {
            position: relative;
            top: 350px;
        }

        .context {
            width: 98%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<jsp:include page="/jsp/common/header/index.jsp"></jsp:include>
<div class="context">
    <div id="search" class="form-inline">
        <div class="form-group">
            <label for="name">姓名</label>
            <input id="name" name="name" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label for="type">类型</label>
            <input id="type" name="type" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label for="isActivating">是否激活</label>
            <input id="isActivating" name="isActivating" type="text" class="form-control">
        </div>
        <div class="form-group">
            <a class="btn btn-info" href="#">搜索</a>
        </div>
    </div>
    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>编号</td>
                <td>性别</td>
                <td>是否激活</td>
            </tr>
            </thead>
            <c:forEach var="admin" items="${page.results}">
                <tr>
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.name}</td>
                    <td>${admin.isActivating}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <nav>
        <div id="page_button">
            <form class="form-inline">
                <div class="form-group">
                    <c:choose>
                        <c:when test="${page.currentPage<=1}">
                            <a class="btn btn-default" disabled="disabled" href="#">上一页</a>
                        </c:when>
                        <c:when test="${page.currentPage>1}">
                            <a class="btn btn-info" href="queryUser.do?currentPage=${page.currentPage-1}">上一页</a>
                        </c:when>
                    </c:choose>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" value="${page.currentPage }"/>
                </div>
                <div class="form-group">
                    <c:choose>
                        <c:when test="${page.currentPage<page.totalPage}">
                            <a class="btn btn-info" href="queryUser.do?currentPage=${page.currentPage+1}">下一页</a>
                        </c:when>
                        <c:when test="${page.currentPage>=page.totalPage}">
                            <a class="btn btn-default" disabled="disabled" href="#">下一页</a>
                        </c:when>
                    </c:choose>
                </div>
            </form>
        </div>
    </nav>
</div>
</body>

<%--
测试freemarker 生成htnl
<i:tablecolumn id="tasklist" name="tasklist"
               columntitle="&nbsp;,产品编码,产品名称,品牌,单价,单位,库存,状态,&nbsp;"
               columnname="checkbox,productno,name,brand,listprice,unit,quantity,status,action"></i:tablecolumn>
--%>
</html>