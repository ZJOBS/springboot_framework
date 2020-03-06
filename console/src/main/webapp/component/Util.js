/**
 * Created by jiezhang on 2017/7/13.
 */
/**
 * 公共工具类
 * @constructor
 */
function Util() {
}

Util.prototype = {
    /**
     * 填入form表单中的数据
     * @param id 标签属性
     * @param data 填入表单的数据，表单的name作为key，填入的值作为value
     */
    setFormInput: function (id, data) {
        var $inputs = $(id + " input," + id + " textarea," + id + " select");
        for (var i = 0; i < $inputs.length; i++) {
            var name = $inputs.eq(i).attr("name");
            if (!name) {
                continue;
            }
            var value = data[name];
            $inputs.eq(i).val(value);
            //如果是select类型 设置默认值
            if ("SELECT" == $inputs.eq(i)[0].tagName) {
                $inputs.find(" option[value=" + value + "]").attr("selected", true)
            }
        }
    },
    setFormInputByJquery: function ($div, data) {
        var $inputs = $div.find("input," + "textarea", "select");
        for (var i = 0; i < $inputs.length; i++) {
            var name = $inputs.eq(i).attr("name");
            if (!name) {
                continue;
            }
            var value = data[name];
            $inputs.eq(i).val(value);
            //如果是select类型 设置默认值
            if ("SELECT" == $inputs.eq(i)[0].tagName) {
                $inputs.find(" option[value=" + value + "]").attr("selected", true)
            }
        }
    }
    ,

    /**
     * 获取表单中的数据
     * @param id 标签属性
     * @returns {{}}
     */
    getFrom: function (id) {
        var obj = {};
        var $inputs = $(id + " input," + id + " textarea," + id + " select");
        for (var i = 0; i < $inputs.length; i++) {
            if ($inputs.eq(i)[0].disabled) {
                continue;
            }
            var name = $inputs.eq(i).attr("name");
            if (!name) {
                continue;
            }
            var value = $inputs.eq(i).val();
            obj[name] = value;
        }
        return obj;
    }
    ,
    getFromContainNull: function (id) {
        var obj = {};
        var $inputs = $(id + " input," + id + " textarea," + id + " select");
        for (var i = 0; i < $inputs.length; i++) {
            if ($inputs.eq(i)[0].disabled) {
                continue;
            }
            var name = $inputs.eq(i).attr("name");
            if (!name) {
                continue;
            }
            var value = $inputs.eq(i).val();
            if (!value) {
                continue;
            }
            obj[name] = value;
        }
        return obj;
    }
    ,
    /**
     * 清空表单中的数据
     * @param id  标签属性
     */
    clearFrom: function (id) {
        var $inputs = $(id + " input," + id + " textarea," + id + " select");
        for (var i = 0; i < $inputs.length; i++) {
            var name = $inputs.eq(i).attr("name");
            if (!name) {
                continue;
            }
            $inputs.eq(i).val("");
        }
    }
    ,
    /**
     * 生成不重复UUID算法
     * @returns {string}
     */
    getUuid: function () {
        var s = [];
        var hexDigits = "0123456789abcdef";
        for (var i = 0; i < 36; i++) {
            s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
        }
        s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
        s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
        s[8] = s[13] = s[18] = s[23] = "-";

        var uuid = s.join("");
        return uuid;
    }
    ,
    setTable: function (array, $tbody, $TrTemp) {
        $tbody.html("");
        for (var i = 0; i < array.length; i++) {
            var data = array[i];
            var $tr = $TrTemp.clone(true);
            setTr(data, $tr);
            $tbody.append($tr);
        }
    }
    ,
    setTr: function (data, $tr) {
        $tr.data(data);
        for (key in data) {
            $tr.find('.' + key).html(data[key] + "");
        }
    }
    ,
    /**
     * 只要包含小数就进位
     * @param 数字类型 v
     * @returns {*}
     */
    modFoat: function (v) {
        var _max = parseInt(v) + 1;
        if (_max - v < 1) {
            return _max;
        }
        return v;
    }
}
;
jQuery.extend({
    createUtil: function () {
        return new Util();
    }
});