<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right">${text}</label>
    <div class="col-sm-9">
        <#list options as option>
            <label>
            <input name="${name}" type="checkbox" class="ace" value="${option.value}">
            <span class="lbl">${option.name}</span>
            </label>
        </#list>
    </div>
</div>