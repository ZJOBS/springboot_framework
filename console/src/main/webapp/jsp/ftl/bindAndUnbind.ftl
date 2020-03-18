<script type="text/javascript">
    jQuery(function ($) {
        //左边部分
        $.${id}LeftDataTablesSettings = {
            "select": {
                "style": 'multi',
                "selector": 'td:first-child'
            },
            "sScrollY": "390px",
            "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
            "aLengthMenu": [[10, 15, 20], [10, 15, 20]],
            "iDisplayLength": 10,//每页显示10条数据
            "bAutoWidth": true,//宽度是否自动
            "bLengthChange": true,
            "bFilter": false,
            "oLanguage": {
                "sProcessing": "正在加载数据...",
                "sLengthMenu": "显示_MENU_条 ",
                "sZeroRecords": "没有您要搜索的内容",
                "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(全部记录数 _MAX_  条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": " 上一页 ",
                    "sNext": " 下一页 ",
                    "sLast": " 尾页 "
                }
            },
            "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
            "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。
            "sAjaxSource": "${contextPath}${leftQueryUrl}", //给服务器发请求的url
            "sServerMethod": "POST",
            "aoColumns": [${columnName}],
            "aoColumnDefs": [<#if columnFormat?exists>${columnFormat}</#if>],
            "fnServerParams": function (aoData) {
                aoData._rand = Math.random();
                <#if search?exists>
                var dataSer = util.getFrom("${search}");
                for (var key in dataSer) {
                    aoData.push(
                        {"name": key, "value": dataSer[key]}
                        //添加所有搜索参数
                    );
                }
                </#if>
            },
            "fnDrawCallback": function () {

            }
        };
        var ${id}LeftDataTable;

        //右边部分
        $.${id}RightDataTablesSettings = {
            "select": {
                "style": 'multi',
                "selector": 'td:first-child'
            },
            "sScrollY": "390px",
            "sPaginationType": "full_numbers", //分页风格，full_number会把所有页码显示出来（大概是，自己尝试）
            "aLengthMenu": [[10, 15, 20], [10, 15, 20]],
            "iDisplayLength": 10,//每页显示10条数据
            "bAutoWidth": true,//宽度是否自动
            "bLengthChange": true,
            "bFilter": false,
            "oLanguage": {
                "sProcessing": "正在加载数据...",
                "sLengthMenu": "显示_MENU_条 ",
                "sZeroRecords": "没有您要搜索的内容",
                "sInfo": "从_START_ 到 _END_ 条记录——总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(全部记录数 _MAX_  条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": " 上一页 ",
                    "sNext": " 下一页 ",
                    "sLast": " 尾页 "
                }
            },
            "bProcessing": true, //开启读取服务器数据时显示正在加载中……特别是大数据量的时候，开启此功能比较好
            "bServerSide": true, //开启服务器模式，使用服务器端处理配置datatable。注意：sAjaxSource参数也必须被给予为了给datatable源代码来获取所需的数据对于每个画。 这个翻译有点别扭。开启此模式后，你对datatables的每个操作 每页显示多少条记录、下一页、上一页、排序（表头）、搜索，这些都会传给服务器相应的值。
            "sAjaxSource": "${contextPath}${rightQueryUrl}", //给服务器发请求的url
            "sServerMethod": "POST",
            "aoColumns": [${columnName}],
            "aoColumnDefs": [<#if columnFormat?exists>${columnFormat}</#if>],
            "fnServerParams": function (aoData) {
                aoData._rand = Math.random();
                <#if search?exists>
                var dataSer = util.getFrom("${search}");
                for (var key in dataSer) {
                    aoData.push(
                        {"name": key, "value": dataSer[key]}
                        //添加所有搜索参数
                    );
                }
                </#if>
            },
            "fnDrawCallback": function () {

            }
        };
        var ${id}RightDataTable;

        //绑定属性，主表ID
        var ${keyName}Bind;
        $("#${sourceTableId}").delegate("${awakenPosition}", "click", function () {
            $(this).toggleClass('selected');
            var dataApi = main.${sourceTableId}dataTable.api();
            var data = dataApi.row($(this).parents("tr")).data();
            ${keyName}Bind = data["${keyName}"];

            //左边
            //设置参数
            $.${id}LeftDataTablesSettings.fnServerParams = function (aoData) {
                aoData._rand = Math.random();
                //search方法获取值
                aoData.push(
                    {"name": "${keyName}", "value": ${keyName}Bind}
                );
            };
            if (!${id}LeftDataTable) {
                ${id}LeftDataTable = $('#${id}LeftTable').dataTable($.${id}LeftDataTablesSettings);
            } else {
                ${id}LeftDataTable.api().ajax.reload();
            }

            //右边
            $.${id}RightDataTablesSettings.fnServerParams = function (aoData) {
                aoData._rand = Math.random();
                //search方法获取值
                aoData.push(
                    {"name": "${keyName}", "value": ${keyName}Bind}
                );
            };
            if (!${id}RightDataTable) {
                ${id}RightDataTable = $('#${id}RightTable').dataTable($.${id}RightDataTablesSettings);
            } else {
                ${id}RightDataTable.api().ajax.reload();
            }

            $('#${id}').dialog({
                resizable: false,
                width: 1400,
                modal: true,
                title_html: true,
            });

            $('#${id}LeftTable').show();
            $('#${id}RightTable').show();
        });

        //添加
        $('#${id}RightMove').click(function () {
            var $selectDomList = $('#${id}RightTable').find(".selected");
            var ids = [];
            if ($selectDomList.length == 0) {
                return;
            }
            $selectDomList.each(function () {
                var ${relationName} =
                ${id}RightDataTable.api().row(this).data()['${relationName}'];
                ids.push(${relationName});
            });

            $.ajax({
                url: "${contextPath}${addUrl}",
                type: 'post',
                data: {${relationName}s: ids.join(","),
            ${keyName}:${keyName}Bind
        },
            success: function (result) {
                ${id}LeftDataTable.api().ajax.reload();
                ${id}RightDataTable.api().ajax.reload();
            }
        })
            ;
        });


        //删除
        $('#${id}LeftMove').click(function () {
            var $selectDomList = $('#${id}LeftTable').find(".selected");
            var ids = [];
            if ($selectDomList.length == 0) {
                return;
            }
            $selectDomList.each(function () {
                var ${relationName} =
                ${id}LeftDataTable.api().row(this).data()['${relationName}'];
                ids.push(${relationName});
            });
            $.ajax({
                url: "${contextPath}${deleteUrl}",
                type: 'post',
                data: {${relationName}s: ids.join(","),
            ${keyName}:${keyName}Bind
        },
            success: function (result) {
                ${id}LeftDataTable.api().ajax.reload();
                ${id}RightDataTable.api().ajax.reload();
            }
        })
            ;

        });


        $('#btn_clear_search').click(function () {
            //需要先清空搜索框
            util.clearFrom('#search');
            //需要先清空搜索框
            var oSettings = dataTable.fnSettings();
            oSettings._iDisplayStart = 0;
            dataTable.fnDraw(oSettings);
        });
    });
</script>


<div id="${id}" class="bootstrap-duallistbox-container row moveonselect" style="display: none">
    <#--左侧start-->
    <div class="box1 col-md-6">
        <span class="info-container">
            <span class="info">绑定</span>
        </span>
        <div id="${id}LeftSearch" class="ibox-tools">
            <input placeholder="名称" id="name" type="text" name="name" class="col-xs-10 col-sm-1"/>
            <a id="${id}Left_btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                        class="fa fa-search"></i>搜索</a>
            <a id="${id}Left_btn_clear_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                        class="fa fa-search"></i>清空</a>
            <button id="${id}LeftMove" type="button" class="btn move btn-white btn-bold btn-info" title="Move selected">
                <i class="fa fa-arrow-right"></i>
            </button>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div>
                    <table id="${id}LeftTable" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <#list columnTitle as ct>
                                <th>${ct}</th>
                            </#list>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <#--左侧end-->
    <#--右侧start-->
    <div class="box2 col-md-6">
        <span class="info-container">
            <span class="info">未绑定</span>
        </span>
        <div id="${id}RightSearch" class="ibox-tools">
            <input placeholder="名称" id="name" type="text" name="name" class="col-xs-10 col-sm-1"/>
            <a id="${id}Right_btn_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                        class="fa fa-search"></i>搜索</a>
            <a id="${id}Right_btn_clear_search" class="btn btn-primary btn-sm" href="javascript:void(0)"><i
                        class="fa fa-search"></i>清空</a>
            <button id="${id}RightMove" type="button" class="btn remove btn-white btn-bold btn-info"
                    title="Remove selected">
                <i class="fa fa-arrow-left"></i>
            </button>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div>
                    <table id="${id}RightTable" class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <#list columnTitle as ct>
                                <th>${ct}</th>
                            </#list>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <#--左侧end-->
</div>


