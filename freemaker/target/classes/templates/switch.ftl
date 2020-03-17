<script type="text/javascript">
    jQuery(function ($) {
        $('input[name=${name}]').click(function () {
            var checked = this.checked;
            if (checked) {
                $(this).val(true);
                $(this).prop("checked", true);
            } else {
                $(this).val(false);
                $(this).prop("checked", false);
            }
        });
    });
</script>

<div class="form-group">
    <label class="col-sm-3 control-label no-padding-right">${text}</label>
    <div class="col-sm-9">
        <label>
            <input name="${name}" class="ace ace-switch ace-switch-4" type="checkbox">
            <span class="lbl"></span>
        </label>
    </div>
</div>


