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
            "aoColumns": [${columnName}],
            "aoColumnDefs": [<#if columnFormat?exists>${columnFormat}</#if>],
            "fnServerParams": function (aoData) {
                aoData._rand = Math.random();
            },
            "fnDrawCallback": function () {
            }
        };
        $('#btn_search').click(function () {
            //这里重新设置参数
            $.${id}dataTablesSettings.fnServerParams = function (aoData) {
                aoData._rand = Math.random();
                //search方法获取值
                aoData.push(
                    {"name": "name", "value": $('#name').val()}
                );
            };
            //搜索就是设置参数，然后销毁datatable重新再建一个
            ${id}DataTable = $("#${id}").dataTable($.${id}dataTablesSettings);
            ${id}DataTable.fnClearTable(); //清空一下table
            ${id}DataTable.fnDestroy(); //还原初始化了的datatable
            //搜索后跳转到第一页
            ${id}DataTable.fnPageChange(0);
        });


        var ${id}DataTable;
        var ${id}relation = ${relation};
        $("body").delegate("input[name=" + ${id}relation[1] + "]", "click", function () {
            if (!${id}DataTable) {
                ${id}DataTable = $("#${id}").dataTable($.${id}dataTablesSettings);
            } else {
                ${id}DataTable.api().ajax.reload();
            }

            /*显示*/
            $('#${id}').show();

            $('#${id}_wrapper').dialog({
                resizable: false,
                width: ${width},
                modal: true,
                title_html: true,
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>取消",
                        "class": "btn btn-minier",
                        click: function () {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
            <#--$('#${id}_wrapper').dialog("moveToTop");-->
        });

        $('#${id}').delegate('tr', "dblclick", function () {
            $(this).toggleClass('selected');
            var data = ${id}DataTable.api();
            $("input[name=" + ${id}relation[1] + "]").val(data.row(this).data()[${id}relation[0]]);
            $('#${id}_wrapper').dialog("close");
        });

    });

</script>


<table id="${id}" class="table table-striped table-bordered table-hover" style="display: none">
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

