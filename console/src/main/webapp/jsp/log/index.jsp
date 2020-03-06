<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <jsp:include page="/WEB-INF/common/style.jsp"/>
    <jsp:include page="/WEB-INF/common/js.jsp"/>

</head>

<body class="no-skin">

<div class="main-container ace-save-state">
    <div class="main-content">
        <div class="main-content-inner">

            <div class="page-content">
                <div class="clearfix">
                    <div class="pull-right tableTools-container"></div>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-header">
                                    日志信息管理
                                </div>
                                <div>
                                    <div id="search" class="ibox-tools">
                                        <form>
                                            <input placeholder="名称" id="name" type="text" name="name"
                                                   class="col-xs-10 col-sm-1"/>
                                            <a id="btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                                                    class="fa fa-search"></i>搜索</a>
                                            <a id="btn_clear_search" class="btn btn-primary btn-sm"
                                               href="javascript:void(0)"><i class="fa fa-search"></i>清空</a>
                                            <a id="add" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                                                    class="fa fa-plus"></i>添加</a>
                                        </form>
                                    </div>

                                    <zj:tableColumn id="log" key="logId"
                                                    search="#search"
                                                    queryUrl="/queryLog.do"
                                                    columnTitle="编号,管理员编号,模块名称,方法,响应时间,ip,执行时间,结果"
                                                    columnName="{'mData': 'logId'},{'mData': 'adminId'},{'mData': 'moduleName'},{'mData': 'method'},{'mData': 'responseDate'},{'mData': 'ip'},{'mData': 'dateTime'},{'mData': 'result'}"
                                    />
                                </div>
                            </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->
</body>
</html>
