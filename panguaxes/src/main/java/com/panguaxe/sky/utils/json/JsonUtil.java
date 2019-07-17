package com.panguaxe.sky.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.panguaxe.sky.utils.string.StringUnicodeSerializerUtil;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Title JsonUtil
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 17:21
 **/
public class JsonUtil {

    /**定义jackson对象*/
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static ObjectMapper mapper;
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              将对象转换成json字符串。
     * @Date: 2019年07月12日 17:26
     * @param data
     * @return java.lang.String
     **/
    public static String ObjToString(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              将json结果集转化为对象
     * @Date: 2019年07月12日 17:26
     * @param jsonData      json数据
     * @param beanType      对象中的object类型
     * @return T
     **/
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              将json数据转换成pojo对象list
     * @Date: 2019年07月12日 17:25
     * @param jsonData
     * @param beanType
     * @return java.util.List<T>
     **/
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              将Object对象以json形式写入response返回
     * @Date: 2019年07月12日 17:25
     * @param response
     * @param obj
     * @return boolean
     **/
    public static boolean writeResponse(HttpServletResponse response,Object obj){
        boolean flag = true;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            MAPPER.writeValue(response.getWriter(),obj);
        }catch (Exception e){
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          根据key获取结果值
     * @Date: 2019年07月12日 17:23
     * @param jsonString
     * @param key
     * @return java.lang.Object
     **/
    public static Object getJsonObj(JSONObject jsonString, String key) {
        Object obj = null;
        if (jsonString.containsKey(key)) {
            obj = jsonString.get(key);
        }
        return obj;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              将json字符串转换成java对象
     * @Date: 2019年07月12日 17:23
     * @param json          json准备转换的json字符串
     * @param cls           cls准备转换的类
     * @return java.lang.Object
     **/
    public static Object jsonToBean(String json, Class<?> cls) {
        ObjectMapper objectMapper = getMapperInstance();
        Object object = null;
        try {
            object = objectMapper.readValue(json, cls);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          获取ObjectMapper实例 Inclusion Inclusion.ALWAYS 全部列入 Inclusion
     *                              Inclusion.NON_DEFAULT 字段和对象默认值相同的时候不会列入 Inclusion Inclusion.NON_EMPTY
     *                              字段为NULL或者""的时候不会列入 Inclusion Inclusion.NON_NULL 字段为NULL时候不会列入
     * @Date: 2019年07月12日 17:28
     * @return com.fasterxml.jackson.databind.ObjectMapper
     **/
    public static synchronized ObjectMapper getMapperInstance() {
        if (mapper == null) {
            mapper = new ObjectMapper();
            // 当找不到对应的序列化器时 忽略此字段
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            // 使Jackson JSON支持Unicode编码非ASCII字符
            SimpleModule module = new SimpleModule();
            module.addSerializer(String.class, new StringUnicodeSerializerUtil());
            mapper.registerModule(module);
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
            mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true) ;
            mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS,true);
            // 所有日期格式都统一为以下样式
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        }
        return mapper;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              根据key获取结果值字符串
     * @Date: 2019年07月12日 17:24
     * @param jsonString
     * @param key
     * @return int
     **/
    public static int getJsonInt(JSONObject jsonString, String key) {
        int result = 0;
        Object obj = getJsonObj(jsonString, key);
        if (obj != null) {
            result = new Integer(obj.toString());
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          根据key获取结果值字符串
     * @Date: 2019年07月12日 17:24
     * @param jsonString
     * @param key
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject getJsonObject(JSONObject jsonString, String key) {
        JSONObject result = new JSONObject();
        Object obj = getJsonObj(jsonString, key);
        if (obj != null) {
            result = JSONObject.fromObject(obj);
        }
        return result;
    }

}
