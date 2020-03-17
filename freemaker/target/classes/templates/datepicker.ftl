<script type="text/javascript">
    $(function () {
        $("#${id}").datetimepicker({
            //语言
            language: 'zh-CN',
            //允许方向键
            keyboardNavigation: true,
            //一周从周一开始
            weekStart: 1,
            //高亮当前日期
            todayHighlight: true,
            //日期格式
            format: '${format}',
            //自动关闭
            autoclose: true,
            pickerPosition: "bottom-right",
            //选择器组件的底部显示一个 "Today" 按钮用以选择当前日期
            <#if disabledDate?exists>
            todayBtn:${todayBtn},
            </#if>
            //不允许选中的日期，必须是YYYY-MM-DD的格式
            <#if disabledDate?exists>
            datesDisabled: '${disabledDate}',
            </#if>
            <#if startView?exists>
            startView: '${startView}',
            </#if>
            <#if minView?exists>
            minView: '${minView}',
            </#if>
            <#if maxView?exists>
            maxView: '${maxView}',
            </#if>
        });
    });
</script>
<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right">${text}</label>
    <div class="col-xs-12 col-sm-5">
        <div id="${id}" class="input-append date date-picker">
            <input size="16" type="text" name="${name}">
            <span class="add-on"><i class="icon-remove"></i></span>
            <span class="add-on"><i class="icon-calendar"></i></span>
        </div>
    </div>
</div>
