<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Dict</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <jsp:include page="/jsp/common/style.jsp"/>
    <jsp:include page="/jsp/common/js.jsp"/>

    <script>
        /*是否可以变为调用数据字典生成此方法*/
        function formatActivating(data, type, full) {
            return data == 0 ? '禁用' : '启用';
        }
    </script>
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
                                    数据字段信息管理
                                </div>
                                <div>
                                    <div id="search" class="ibox-tools">
                                        <form>
                                            <input placeholder="编号" id="code" type="text" name="code" class="col-xs-10 col-sm-1"/>
                                            <input placeholder="名称" id="name" type="text" name="name" class="col-xs-10 col-sm-1"/>
                                            <a id="btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-search"></i>搜索</a>
                                            <a id="btn_clear_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-search"></i>清空</a>
                                            <a id="add" class="btn btn-primary btn-sm" href="javascript:void(0)"><i class="fa fa-plus"></i>添加</a>
                                        </form>
                                    </div>
                                    <%--dynamic-table--%>

                                    <zj:tableColumn id="dict" key="dictId" defaultOperation="YES"
                                                    search="#search"
                                                    queryUrl="/queryDict"
                                                    addUrl="/addDict"
                                                    editUrl="/updateDict"
                                                    deleteUrl="/deleteDict"
                                                    columnTitle="编号,父编号,编码,名称,值,是否启用"
                                                    columnFormat="{'aTargets': 5, 'mRender': formatActivating}"
                                                    columnName="{'mData': 'dictId'},{'mData': 'parentId'},{'mData': 'code'},{'mData': 'name'},{'mData': 'value'},{'mData': 'activating','type':'checkbox'}"
                                                    formId="dialog-confirm"
                                    />

                                    <zj:relationtable id="parentDict" queryUrl="/queryDict"
                                                      columnTitle="编号,父编号,编码,名称,值,是否启用"
                                                      columnName="{'mData': 'dictId'},{'mData': 'parentId'},{'mData': 'code'},{'mData': 'name'},{'mData': 'value'},{'mData': 'activating'}"
                                                      relation="['dictId','parentId']"
                                                      width="1000"/>
                                </div>
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
    <jsp:include page="/jsp/dict/form.jsp"/>
</div>
<!-- /.main-container -->
</body>
</html>