<script type="text/javascript">
    jQuery(function ($) {
        $.${id}dataTablesSettings = {
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
            "sAjaxSource": "${contextPath}${queryUrl}", //给服务器发请求的url
            "sServerMethod": "POST",
            "aoColumns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
                ${columnName}, {'sDefaultContent': ''}
                // sDefaultContent 如果这一列不需要填充数据用这个属性，值可以不写，起占位作用
//              {"sDefaultContent": '', "sClass": "action"},//sClass 表示给本列加class
            ],
            "aoColumnDefs": [
                <#if columnFormat?exists>${columnFormat}, </#if>
                {"aTargets": [${columnLength}+1], "mRender": operating}
                <#--{-->
                <#--"aTargets": [${columnlength}],-->
                <#--"mRender": operating-->
                <#--},-->
                /*{"aTargets":[0],第零个,"mRender": function(){}格式化方法}*/

            ],
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
        main.${id}dataTable = $("#${id}").dataTable($.${id}dataTablesSettings);
        $('#btn_search').click(function () {
            var oSettings = main.${id}dataTable.fnSettings();
            oSettings._iDisplayStart = 0;
            main.${id}dataTable.fnDraw(oSettings);
        });


        $('#btn_clear_search').click(function () {
            //需要先清空搜索框
            util.clearFrom('#search');
            //需要先清空搜索框
            var oSettings = main.${id}dataTable.fnSettings();
            oSettings._iDisplayStart = 0;
            main.${id}dataTable.fnDraw(oSettings);
        });


        <#if addUrl?exists>
        $("body").delegate("#add", "click", function () {
            var $add_dialog = $("#${formId}").removeClass("hide");

            $add_dialog.find('form').resetForm();

            //单文件上传
            $add_dialog.find('input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: '点击上传',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small'
            });

            $add_dialog.dialog({
                resizable: false,
                width: 500,
                title_html: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>保存",
                        "class": "btn btn-minier",
                        click: function () {
                            var This = this;
                            $add_dialog.find('form').ajaxSubmit({
                                type: "POST",
                                url: "${contextPath}${addUrl}",
                                dataType: "json",
                                type: "post",
                                success: function (data, textStatus, jqXHR) {
                                    main.${id}dataTable.fnDraw(false);
                                    $(This).dialog("close");
                                },
                                error: function (jqXHR, textStatus, errorThrown) {
                                    //alert('处理您的请求时发生意外错误,可能是请求过于频繁或登陆超时,请刷新后重试.');
                                }
                            }).resetForm();
                        }
                    }, {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>取消",
                        "class": "btn btn-minier",
                        click: function () {
                            $add_dialog.find('form').resetForm();
                            $(this).dialog("close");
                        }
                    }
                ]
            });
        });
        </#if>

        <#if deleteUrl?exists>
        $("body").delegate(".delete", "click", function () {
            var data = main.${id}dataTable.api().row($(this).parents("tr")).data();
            //$('#${id}').dataTable().api().row($(this).parents("tr")).data();
            var ${key} =
            data.${key};
            $("#delete").removeClass("hide").dialog({
                resizable: false,
                width: 500,
                modal: true,
                title_html: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>删除",
                        "class": "btn btn-minier",
                        click: function () {
                            var This = this;
                            $.ajax({
                                type: "POST",
                                url: "${contextPath}${deleteUrl}",
                                data: {"${key}": ${key}},
                                dataType: "json",
                                type: "post",
                                success: function (data, textStatus, jqXHR) {
                                    main.${id}dataTable.fnDraw(false);
                                    $(This).dialog("close");
                                },
                                error: function (jqXHR, textStatus, errorThrown) {
                                    //alert('处理您的请求时发生意外错误,可能是请求过于频繁或登陆超时,请刷新后重试.');
                                }
                            });
                            //搜索就是设置参数，然后销毁datatable重新再建一个
                        }
                    }, {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>取消",
                        "class": "btn btn-minier",
                        click: function () {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
        });
        </#if>


        <#if editUrl?exists>
        $("body").delegate(".update", "click", function () {
            //获取当前选择的参数,填入updata的数据中
            var data = $('#${id}').dataTable().api().row($(this).parents("tr")).data();
            var $update_dialog = $("#${formId}").removeClass("hide");

            $update_dialog.dialog({
                resizable: false,
                width: 500,
                modal: true,
                title_html: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>保存",
                        "class": "btn btn-minier",
                        click: function () {
                            var This = this;
                            $update_dialog.find('form').ajaxSubmit({
                                type: "POST",
                                url: "${contextPath}${editUrl}",
                                dataType: "json",
                                type: "post",
                                success: function (data, textStatus, jqXHR) {
                                    main.${id}dataTable.fnDraw(false);
                                    $(This).dialog("close");
                                },
                                error: function (jqXHR, textStatus, errorThrown) {
                                    //alert('处理您的请求时发生意外错误,可能是请求过于频繁或登陆超时,请刷新后重试.');
                                }
                            }).resetForm();
                        }
                    }, {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>取消",
                        "class": "btn btn-minier",
                        click: function () {
                            $update_dialog.find('form').resetForm();
                            $(this).dialog("close");
                        }
                    }
                ]
            });

            //单文件上传
            $update_dialog.find('input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: '点击上传',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small'
            });
            util.setFormInputByJquery($update_dialog, data);

            //checkBox启动功能,当数据为1时，checked为switch按钮显示ON状态
            var columnNames = [${columnName}];
            for (var i = 0; i < columnNames.length; i++) {
                //包含类别的时候
                if ('type' in columnNames[i]) {
                    if (data[columnNames[i].mData] == true) {
                        $update_dialog.find('input[name=' + columnNames[i].mData + ']').val(true);
                        $update_dialog.find('input[name=' + columnNames[i].mData + ']').prop("checked", true);
                    } else if (data[columnNames[i].mData] == false) {
                        $update_dialog.find('input[name=' + columnNames[i].mData + ']').val(false);
                        $update_dialog.find('input[name=' + columnNames[i].mData + ']').prop("checked", false);
                    }
                }
            }

            //redio
        });
        </#if>

    });

    /*
    * 生成操作列*/
    function operating(data, type, full) {
        var result = "<div class='hidden-sm hidden-xs action-buttons'>";
        <#if defaultOperation?exists>
        result += "<a class='green update' href='#'> <i class='ace-icon fa fa-pencil bigger-130'></i> </a> <a class='red delete' href='#'> <i class='ace-icon fa fa-trash-o bigger-130'></i> </a>";
        </#if>
        <#if customOperation?exists>
        var customOperation = ${customOperation};
        result += customOperation;
        </#if>
        result += "</div>"
        return result;
    };
</script>


<table id="${id}" class="table table-striped table-bordered table-hover">
    <thead>
    <tr>
        <#list columnTitle as ct>
            <th>${ct}</th>
        </#list>
        <th>操作</th>
    </thead>
    <tbody>
    </tbody>
</table>
