package jiezhang.base.utils;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class JsonUtil {
    private static final ObjectMapper OBJECT_MAP = new ObjectMapper();

    /**
     * json 转为 map 对象
     *
     * @return
     */
    public static Map<String, Object> jsonToMap(String json) {
        return objectFromJson(json, Map.class);
    }

    /**
     * map 转为json 字符串 默认编码utf-8
     *
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map) {
        return mapToJson(map, "UTF8");
    }

    /**
     * map 转为json 字符串
     *
     * @param map
     * @param charset 编码
     * @return
     */
    private static String mapToJson(Map<String, Object> map, String charset) {
        try {
            return new String(jsonFromObject(map, charset), charset);
        } catch (UnsupportedEncodingException e) {
            //logger.error(e.getMessage(), e);
        }
        return null;
    }

    private static <T> T objectFromJson(String paramString, Class<T> paramClass) {
        return JSONUtil.toBean(paramString, paramClass);
//        JsonParser localJsonParser = null;
//        T localObject1 = null;
//        try {
//            localJsonParser = OBJECT_MAP.getJsonFactory().createJsonParser(paramString);
//            localObject1 = localJsonParser.readValueAs(paramClass);
//        } catch (RuntimeException localRuntimeException) {
////			logger.error("Runtime exception during deserializing "
////					+ paramClass.getSimpleName() + " from " + paramString);
//            throw localRuntimeException;
//        } catch (Exception localException) {
////			logger.error("Exception during deserializing "
////					+ paramClass.getSimpleName() + " from " + paramString);
//            return null;
//        } finally {
//            if (localJsonParser != null) {
//                try {
//                    localJsonParser.close();
//                } catch (IOException localIOException2) {
//                }
//            }
//        }
//        return localObject1;
    }

    private static byte[] jsonFromObject(Object paramObject, String paramString) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        JsonGenerator localJsonGenerator = null;
        try {
            localJsonGenerator = OBJECT_MAP.getJsonFactory().createJsonGenerator(
                    localByteArrayOutputStream,
                    JsonEncoding.valueOf(paramString));
            localJsonGenerator.writeObject(paramObject);
            localJsonGenerator.flush();
        } catch (RuntimeException localRuntimeException) {
            throw localRuntimeException;
        } catch (Exception localException) {
//			logger.error("Unable to serialize to json: " + paramObject,
//					localException);
            return null;
        } finally {
            if (localJsonGenerator != null) {
                try {
                    localJsonGenerator.close();
                } catch (IOException localIOException2) {
                }
            }
        }
        return localByteArrayOutputStream.toByteArray();
    }
}
