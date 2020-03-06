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
    <script>
        // /*是否可以变为调用数据字典生成此方法*/
        // function formatState(data, type, full) {
        // return data == 0 ? '禁用' : '启用';
        // };
        function formatActivating(data, type, full) {
            return data == 0 ? '未激活' : '激活';
        };
        function formatLeaf(data, type, full) {
            return data == 0 ? '父' : '子';
        };
    </script>
</head>

<body class="no-skin">

<div class="main-container ace-save-state">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <zj:tableColumn id="menutest" key="menuId" defaultOperation="YES"
                                search="#search"
                                queryUrl="/queryMenu.do"
                                addUrl="/addMenu.do"
                                editUrl="/updateMenu.do"
                                deleteUrl="/deleteMenu.do"
                                columnTitle="编号,父编号,名称,地址,图片,是否启用,是否子节点"
                                columnName="{'mData': 'menuId'},{'mData': 'parentId'},{'mData': 'name'},{'mData': 'url'},{'mData': 'image'},{'mData': 'activating','type':'checkbox'},{'mData': 'leaf','type':'checkbox'}"
                                columnFormat="{'aTargets': 5, 'mRender': formatActivating},{'aTargets': 6, 'mRender': formatLeaf}"
                                formId="dialog-confirm"
                />

            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->


</body>
</html>
