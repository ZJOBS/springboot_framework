/** 验证email */
function isEmail(email) {
    var reg = new RegExp("^\w+[-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$");
    return reg.test(email);
}

/** 验证电话号码：--正确格式为：XXXX-XXXXXXX，XXXX-XXXXXXXX，XXX-XXXXXXX，XXX-XXXXXXXX，XXXXXXX，XXXXXXXX。 */
function isPhone(phone) {
    var reg = new RegExp("^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$");
    return reg.test(phone);
}

/** 验证身份证号:--正确格式为:15位或18位数字 */
function isIDCard(IDCard) {
    var reg = new RegExp(" ^\d{15}(\d{2}[0-9xX])?$");
    return reg.test(IDCard);
}

/** 验证特殊字符 */
function isCaracteresEspeciais() {
    var reg = new RegExp(
        "[ ,\\`,\\~,\\!,\\@,\#,\\$,\\%,\\^,\\+,\\*,\\&,\\\\,\\/,\\?,\\|,\\:,\\.,\\<,\\>,\\{,\\},\\(,\\),\\'',\\;,\\=,\"]");
    return reg.test(IDCard);
}

function isPassword(password) {
    var reg = new RegExp("^[a-zA-Z]\w{5,17}$");
    return reg.test(IDCard);
}

/** 不为空 */
// 问题！ 如果是“ ”很多空格的时候貌似会通过
function isNotEmpty(data) {
    if (data == "" || data == undefined) {
        return false;
    } else {
        return true;
    }
}