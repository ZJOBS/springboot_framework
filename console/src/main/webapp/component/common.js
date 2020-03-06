// //var SUCCESS = "success";
// //var ERROR = "error";
// //var currentPage = 1;
// //var pageSize = 10;
// //var searchuuid = "";
//
//
// //防止回退键导致页面回退
// document.onkeydown = function (event) {
//     var e = event || window.event || arguments.callee.caller.arguments[0];
//     var d = e.srcElement || e.target;
//     if (e && e.keyCode == 8) {
//         return d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA' ? true : false
//     }
// }
//
// function getMaxHeightChild(id) {
//     var $o = $(id).find("div");
//     var maxHeight = 0;
//     for (var i = 0; i < $o.length; i++) {
//         maxHeight = maxHeight < $o.eq(i).height() ? $o.eq(i).height()
//             : maxHeight;
//     }
//     return maxHeight;
// }
//
// function toString(query) {
//     return JSON.stringify(query);
// }
//
// function toJson(string) {
//     return JSON.parse(string);
// }
//
// function updateRow($tr, obj, fields) {
//     $tr.find("td").remove();
//     for (var i = 0; i < fields.length; i++) {
//         $td = $("<td>");
//         $tr.append($td);
//         $td.append(eval("obj." + fields[i]));
//     }
//     $td = $("<td>");
//     $tr.append($td);
// }
//
// function getLocation() {
//     return window.location.href;
// }
//
// /* 钱云版本*/
// /*function getFormInput(id) {
//  var obj = {};
//  var $inputs = $(id + " input," + id + " textarea," + id + " select");
//  for (var i = 0; i < $inputs.length; i++) {
//  if ($inputs.eq(i)[0].disabled) {
//  continue;
//  }
//  var name = $inputs.eq(i).attr("name");
//  if (!name) {
//  continue;
//  }
//  var value = $inputs.eq(i).val();
//  value = toString(value);
//  eval("obj." + name + "=" + value + "");
//  }
//  obj._uri = getLocation();
//  return obj;
//  }*/
//
// /*棠棣工作时修改，标签name重复会转为Array对象。*/
// function getFormInput(id) {
//     var obj = {};
//     var $inputs = $(id + " input," + id + " textarea," + id + " select");
//     for (var i = 0; i < $inputs.length; i++) {
//         if ($inputs.eq(i)[0].disabled) {
//             continue;
//         }
//         var name = $inputs.eq(i).attr("name");
//         if (!name) {
//             continue;
//         }
//         var value = $inputs.eq(i).val();
//         obj[name] = value;
//     }
//     return obj;
// }
//
// function setFormInput(id, data) {
//     var $inputs = $(id + " input," + id + " textarea," + id + " select");
//     for (var i = 0; i < $inputs.length; i++) {
//         var name = $inputs.eq(i).attr("name");
//         if (!name) {
//             continue;
//         }
//         var value = data[name];
//         // value = toString(value);
//         $inputs.eq(i).val(value);
//         //如果是select类型 设置默认值
//         if ("SELECT" == $inputs.eq(i)[0].tagName) {
//             $inputs.find(" option[value=" + value + "]").attr("selected", true)
//         }
//     }
// }
//
// function resetFormInput(id) {
//     var $inputs = $(id + " input," + id + " textarea," + id + " select");
//     for (var i = 0; i < $inputs.length; i++) {
//         var name = $inputs.eq(i).attr("name");
//         if (!name) {
//             continue;
//         }
//         $inputs.eq(i).val("");
//     }
// }
//
// function select($obj) {
//     $(".selected").removeClass("selected");
//     if ($obj != null) {
//         $obj.addClass("selected");
//     }
// }
//
// function getInput($parent) {
//     var obj = {};
//     var $inputs = $parent.find(" input," + " textarea," + " select");
//     for (var i = 0; i < $inputs.length; i++) {
//         if ($inputs.eq(i)[0].disabled) {
//             continue;
//         }
//         var name = $inputs.eq(i).attr("name");
//         if (!name) {
//             continue;
//         }
//         var value = $inputs.eq(i).val();
//         value = toString(value);
//         eval("obj." + name + "=" + value + "");
//     }
//     obj._uri = getLocation();
//     return obj;
// }
//
// function setInput($parent, data) {
//     var $inputs = $parent.find(" input," + " textarea," + " select");
//     for (var i = 0; i < $inputs.length; i++) {
//         var name = $inputs.eq(i).attr("name");
//         if (!name) {
//             continue;
//         }
//         var value = "";
//         eval("value = data." + name);
//         $inputs.eq(i).val(value);
//     }
// }
//
// function setTable(array, $tbody, $TrTemp) {
//     $tbody.html("");
//     for (var i = 0; i < array.length; i++) {
//         var data = array[i];
//         var $tr = $TrTemp.clone(true);
//         setTr(data, $tr);
//         $tbody.append($tr);
//     }
// }
//
// function setTr(data, $tr) {
//     $tr.data(data);
//     for (key in data) {
//         $tr.find('.' + key).html(data[key] + "");
//     }
// }
//
// function modFoat(v) {
//     var _max = parseInt(v) + 1;
//     if (_max - v < 1) {
//         return _max;
//     }
//     return v;
// }
//
// function ajax(parameters, url, callback) {
//     var data = {};
//     data = JSON.stringify(parameters);
//     $.ajax({
//         type: "POST",
//         url: contextPath + "/" + url + ".do",
//         data: parameters,
//         dataType: "json",
//         success: function (result, textStatus, jqXHR) {
//             eval(callback)(result);
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             alert(textStatus);
//         },
//         beforeSend: function (jqXHR, settings) {
//             // $("#loading").show();
//         },
//         complete: function (jqXHR, textStatus) {
//             // $("#loading").hide();
//         }
//     });
// }
//
// function isContains(array, obj) {
//     for (var i = 0; i < array.length; i++) {
//         if (array[i] === obj) {
//             return true;
//         }
//     }
//     return false;
// }
//
// function CloneTag($tag) {
//     return $tag.clone(true);
// }
//
// function mergeJSON(destination, source) {
//     for (var property in source)
//         destination[property] = source[property];
//     return destination;
// }
//
// function createSelect(data) {
//     var $select = $('<select>');
//     var $option = $("<optionv selected='selected'>---</option>");
//     $select.append($option);
//     for (var key in data) {
//         $option = $('<option>');
//         $option.val(key);
//         $option.append(data[key]);
//         $select.append($option);
//     }
// }
//
// //
// //function prev(obj, event) {
// //
// //		var page = thisPage - 1;
// //		var data = {};
// //		data.page = page;
// //		data.pagesize = pagesize;
// //		data.keys = JSON.stringify(keys);
// //
// //		var ajax = {};
// //		ajax.url = "part/queryPart";
// //		ajax.callback = "afQueryPart";
// //		ajax.data = data;
// //		callService(ajax, $('.part-temp').find('tbody tr').clone(true));
// //
// //		thisPage = page;
// //		$("#searchPage").val(thisPage);
// //}
