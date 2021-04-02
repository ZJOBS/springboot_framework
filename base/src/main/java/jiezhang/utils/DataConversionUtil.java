package jiezhang.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据转换类
 *
 * @author jiezhang
 */
public class DataConversionUtil {

    /**
     * 下划线转驼峰
     */
    private static final Pattern camelPattern = Pattern.compile("_(\\w)");

    /**
     * 驼峰转下划线
     */
    private static final Pattern underline = Pattern.compile("[A-Z]");


    /**
     * 对象转Map，当value为null时，转换为""
     *
     * @param javaBean
     * @return
     */
    public static Map<String, Object> toMapContainsNull(Object javaBean) {
        Map<String, Object> result = new HashMap<String, Object>();
        Method[] methods = javaBean.getClass().getMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    result.put(field, value);
                }
            } catch (Exception e) {
//                System.out.println("toMap方法报错，已有用log代替");
            }
        }
        return result;
    }

    /**
     * 对象转Map，剔除value等于null的属性
     *
     * @param javaBean
     * @return
     */
    public static Map<String, Object> toMapExclusiveNull(Object javaBean) {
        Map<String, Object> result = new HashMap<String, Object>();
        Method[] methods = javaBean.getClass().getMethods();
        for (Method method : methods) {
            try {
                if (method.getName().startsWith("get")) {
                    String field = method.getName();
                    field = field.substring(field.indexOf("get") + 3);
                    field = field.toLowerCase().charAt(0) + field.substring(1);
                    Object value = method.invoke(javaBean, (Object[]) null);
                    if (value != null) {
                        result.put(field, value);
                    }
                }
            } catch (Exception e) {
//                System.out.println("toMap方法报错，已有用log代替");
            }
        }
        return result;
    }

    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String camel(String str) {
        return camel(new StringBuffer(str)).toString();
    }


    private static StringBuffer camel(StringBuffer str) {
        Matcher matcher = camelPattern.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的也添加到StringBuffer对象里
            matcher.appendTail(sb);
        } else {
            return sb;
        }
        return camel(sb);
    }

    /**
     * 驼峰转下划线
     *
     * @param str
     * @return
     */
    public static String underline(String str) {
        return underline(new StringBuffer(str)).toString();
    }


    private static StringBuffer underline(StringBuffer str) {
        Matcher matcher = underline.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配子串替换为指定字符串，并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里。
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            //把之后的也添加到StringBuffer对象里
            matcher.appendTail(sb);
        } else {
            return sb;
        }
        return underline(sb);
    }

    //
    // @SuppressWarnings("unchecked")
    // public static Map<String, Object> toMap(JsonObject jsonObject) {
    // Map<String, Object> result = new HashMap<String, Object>();
    // if (jsonObject != null) {
    // Iterator<String> iterator = jsonObject.keys();
    // String key = null;
    // Object value = null;
    // while (iterator.hasNext()) {
    // key = iterator.next();
    // value = jsonObject.get(key);
    // result.put(key, value);
    // }
    // }
    // return result;
    // }
    //
    // public static Object toJavaBean(Object javabean, Map<String, String>
    // data) {
    // Method[] methods = javabean.getClass().getDeclaredMethods();
    // for (Method method : methods) {
    // try {
    // if (method.getName().startsWith("set")) {
    // String field = method.getName();
    // field = field.substring(field.indexOf("set") + 3);
    // field = field.toLowerCase().charAt(0) + field.substring(1);
    // method.invoke(javabean, new Object[] { data.get(field) });
    // }
    // } catch (Exception e) {
    // }
    // }
    //
    // return javabean;
    // }
    //
    // public static JSONObject toJsonObject(Object javaBean) {
    // Map<String, Object> map = toMap(javaBean);
    // JSONObject jsonObject = JSONObject.fromObject(map);
    // return jsonObject;
    //
    // }
    //
    // public static JsonObject toJson(Object obj, String[] fieldsname) {
    // JsonObject json = new JsonObject();
    //
    // for (int i = 0; i < fieldsname.length; i++) {
    // Field field;
    // try {
    // field = obj.getClass().getDeclaredField(fieldsname[i]);
    // String name = field.getName();
    // Object value = getValue(obj, name);
    // if (value == null) {
    // json.put(name, "");
    // } else {
    // json.put(name, value);
    // }
    // } catch (NoSuchFieldException e) {
    // e.printStackTrace();
    // } catch (SecurityException e) {
    // e.printStackTrace();
    // }
    //
    // }
    // return json;
    // }
    //
    // // public void toJavaBean(Object javabean, JsonObject json) {
    // // Map map =
    // //
    // toMap(json.toString());tomap<String,String>����ֵ��toJAVAbean<String,Object>����ֵ���Ͳ�ͬ
    // // toJavaBean(javabean, map);
    // // }
    //
    // public static Object getValue(Object obj, String name) {
    // Object retVal = null;
    // try {
    // String methodName = "get" + name.substring(0, 1).toUpperCase()
    // + name.substring(1);
    // retVal = obj.getClass().getMethod(methodName, new Class[] {})
    // .invoke(obj, new Object[] {});
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return retVal;
    // }
    //
    // public static void setValue(Object obj, String name, Object value) {
    // try {
    // Field field = obj.getClass().getDeclaredField(name);
    // String methodName = "set" + name.substring(0, 1).toUpperCase()
    // + name.substring(1);
    // obj.getClass()
    // .getMethod(methodName, new Class[] { field.getType() })
    // .invoke(obj, new Object[] { value });
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    //
    // public static void setValue(Object obj, String name, String value) {
    // try {
    // Field field = obj.getClass().getDeclaredField(name);
    // String methodName = "set" + name.substring(0, 1).toUpperCase()
    // + name.substring(1);
    // Object v = null;
    // if (field.getType() == Integer.class) {
    // v = Integer.parseInt(value);
    // } else if (field.getType() == Long.class) {
    // v = Long.parseLong(value);
    // } else if (field.getType() == Double.class) {
    // v = Double.parseDouble(value);
    // } else if (field.getType() == Float.class) {
    // v = Float.parseFloat(value);
    // } else if (field.getType() == Character.class) {
    // v = value.charAt(0);
    // } else if (field.getType() == Short.class) {
    // v = Short.parseShort(value);
    // } else if (field.getType() == Boolean.class) {
    // v = Boolean.parseBoolean(value);
    // } else if (field.getType() == Byte.class) {
    // v = Byte.parseByte(value);
    // } else if (field.getType() == Date.class) {
    // DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // v = format.parse(value);
    // } else {
    // v = value;
    // }
    //
    // obj.getClass()
    // .getMethod(methodName, new Class[] { field.getType() })
    // .invoke(obj, new Object[] { v });
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    //
    // public static void convert(JsonObject json, Object obj) {
    // Field[] fields = obj.getClass().getDeclaredFields();
    // for (int i = 0; i < fields.length; i++) {
    // Field field = fields[i];
    // String name = field.getName();
    // if (json.containsKey(name)) {
    // Object value = json.get(name);
    // if (value != null) {
    // if (fields[i].getType() == java.util.Date.class) {
    // value = parse(value.toString());
    // }
    // if (fields[i].getType() == java.lang.Long.class) {
    // try {
    // value = Long.parseLong(value.toString());
    // } catch (Exception ex) {
    // value = 0;
    // }
    // }
    //
    // if (fields[i].getType() == java.lang.Double.class) {
    // try {
    // value = Double.parseDouble(value.toString());
    // } catch (Exception ex) {
    // value = 0;
    // }
    // }
    // if (fields[i].getType() == java.lang.Float.class) {
    // try {
    // value = Float.parseFloat(value.toString());
    // } catch (Exception ex) {
    // value = 0;
    // }
    // }
    // if (fields[i].getType() == java.lang.Integer.class) {
    // try {
    // value = Integer.parseInt(value.toString());
    // } catch (Exception ex) {
    // value = 0;
    // }
    // }
    // setValue(obj, name, value);
    // }
    // }
    // }
    // }
    //
    // public static Date parse(String source) {
    // Date date = null;
    // try {
    // date = datetimeFormat.parse(source);
    // } catch (ParseException e) {
    // e.printStackTrace();
    // }
    // return date;
    // }
    //
    // public static Map<String, Object> listTOMap(List<Map<String, Object>>
    // list) {
    // Map<String, Object> result = new HashMap<String, Object>();
    // for (Map<String, Object> map : list) {
    // result.putAll(map);
    // }
    // return result;
    // }
    //
    // public boolean isEmpty(String str) {
    // if (str == null || str.equals("")) {
    // return true;
    // }
    // return false;
    // }

}