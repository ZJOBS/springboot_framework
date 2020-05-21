<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>长琴票据识别配置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <jsp:include page="/jsp/common/style.jsp"/>
    <jsp:include page="/jsp/common/js.jsp"/>
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
                                    长琴票据识别管理
                                </div>
                                <div>
                                    <div id="search" class="ibox-tools">
                                        <input placeholder="属性" id="attribute" type="text" name="attribute" class="col-xs-10 col-sm-1"/>
                                        <a id="btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-search"></i>搜索</a>
                                        <a id="btn_clear_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-search"></i>清空</a>
                                        <a id="add" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-plus"></i>添加</a>
                                    </div>

                                    <zj:tableColumn id="cqBillConfig" key="cqBillConfigId" defaultOperation="YES"
                                                    search="#search"
                                                    queryUrl="/queryCqBillConfig"
                                                    addUrl="/addCqBillConfig"
                                                    editUrl="/updateCqBillConfig"
                                                    deleteUrl="/deleteCqBillConfig"
                                                    columnTitle="编号,属性,相似值"
                                                    columnName="{'mData': 'cqBillConfigId'},{'mData': 'attribute'},{'mData': 'similarityValue'}"
                                                    formId="dialog-confirm"
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

    <div id="delete" class="hide">
        <div class="alert alert-danger bigger-110">
            确认要删除么？
        </div>
    </div>
    <div id="dialog-confirm" class="hide">
        <jsp:include page="/jsp/cqBillConfig/form.jsp"/>
    </div>
</div><!-- /.main-container -->
</body>
</html>