package com.panguaxe.sky.utils.http;

import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.utils.ObjectUtils;
import net.sf.json.JSONObject;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Title OkHttpUtils
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/6/1 17:23
 **/
public class OkHttpUtils {

    private static final Logger log = LoggerFactory.getLogger(OkHttpUtils.class);
    private static int maxHttpTiemSecond = 5;


    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              get请求不带参数
     * @Date: 2019年06月01日 17:46
     * @param url
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doGet(String url){
        return doGet(url, null);
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              get请求带参数
     * @Date: 2019年06月01日 17:46
     * @param reqUrl
     * @param req
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doGet(String reqUrl, JSONObject req) {
        JSONObject result = new JSONObject();
        try {
            OkHttpClient okHttpClient = getOkHttpClient();
            reqUrl = reqUrl + "?";
            if (ObjectUtils.isNotEmpty(req)) {
                Iterator<String> reqkeys = req.keys();
                while (reqkeys.hasNext()) {
                    String key = reqkeys.next();
                    log.info("请求key{}",reqUrl);
                    String value = req.getString(key);
                    log.info("请求value{}",reqUrl);
                    reqUrl = reqUrl + key + "=" + value + "&";
                }
                reqUrl = StringUtils.substring(reqUrl, 0, reqUrl.length() - 1);
                log.info("拼接后的get请求url{}",reqUrl);
                Request request = new Request.Builder().get().url(reqUrl).build();
                Call call = okHttpClient.newCall(request);
                Response response = null;
                result = unifiedResultHandle(call, response, result, req == null ? null : req.toString());
            } else {
                result.put("errMsg","请求参数为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              表单形式post请求 map的请求
     * @Date: 2019年06月01日 17:54
     * @param url
     * @param map
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPost(String url, Map<String, String> map){
        JSONObject result = new JSONObject();
        FormBody.Builder builder = new FormBody.Builder();
        OkHttpClient okHttpClient = getOkHttpClient();
        Response response = null;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                log.info("key :{},value :{}", key, value);
                builder.add(key, value);
            }
            FormBody body = builder.build();
            log.info("组装后的请求body{}",body);
            Request request = new Request.Builder().url(url).post(body).build();
            log.info("请求体Request{}",request);
            Call call = okHttpClient.newCall(request);
            result = unifiedResultHandle(call, response, result, body.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              Json body形式的post请求
     * @Date: 2019年06月01日 18:07
     * @Param  * @param url
     * @param json
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPost(String url, String json){
        JSONObject result = new JSONObject();
        OkHttpClient okHttpClient = getOkHttpClient();
        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
            log.info("组装后的请求body{}",body);
            Request request = new Request.Builder().post(body).url(url).build();
            Call call = okHttpClient.newCall(request);
            Response response = null;
            result = unifiedResultHandle(call, response, result, json);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              表单形式post请求
     * @Date: 2019年06月01日 18:09
     * @Param  * @param url
     * @param jsonO
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPostFormJson(String url, JSONObject jsonO){
        JSONObject result = new JSONObject();
        OkHttpClient okHttpClient = getOkHttpClient();
        try {
            FormBody.Builder builder = new FormBody.Builder();
            Iterator<String> keys = jsonO.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonO.getString(key);
                log.info("key :{},value :{}", key, value);
                builder.add(key, value);
            }
            FormBody body = builder.build();
            log.info("组装后的请求body{}",body);
            Request request = new Request.Builder().url(url).post(body).build();
            Call call = okHttpClient.newCall(request);
            Response response = null;
            result = unifiedResultHandle(call, response, result, jsonO.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              requestBody形式
     * @Date: 2019年06月01日 18:10
     * @Param  * @param url
     * @param jsonO
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPostJson(String url, JSONObject jsonO){
        JSONObject result = new JSONObject();
        OkHttpClient okHttpClient = getOkHttpClient();
        String content = "";
        Response response = null;
        try {
            Iterator<String> keys = jsonO.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonO.getString(key);
                log.info("key :{},value :{}", key, value);
                content += key + "=" + value;
                if (keys.hasNext()){
                    content += "&";
                }
                log.info("content{}",content);
            }
            RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), content);
            Request request = new Request.Builder().url(url).post(body).build();
            log.info("组装后的请求body{}",body);
            log.info("组装后的请求请求体{}",request);
            Call call = okHttpClient.newCall(request);
            result = unifiedResultHandle(call, response, result, content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              传输文件或者图片的公用方法(multipartFile)
     * @Date: 2019年06月01日 18:14
     * @param url
     * @param fileParamName         请求时file文件的参数名
     * @param fileName
     * @param json
     * @param file
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPost(String url, String fileParamName, String fileName, JSONObject json,MultipartFile file) throws IOException {
        JSONObject result = new JSONObject();
        OkHttpClient okHttpClient = getOkHttpClient();
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file.getBytes());
        Response response = null;
        try {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            if (ObjectUtils.isNotEmpty(json)) {
                Iterator<String> keys = json.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = getJsonString(json, key);
                    builder.addFormDataPart(key, value);
                }
            }
            builder.addFormDataPart(ObjectUtils.isEmpty(fileParamName) ? "file" : fileParamName, fileName, fileBody);
            MultipartBody multipartBody = builder.build();
            log.info("组装请求multipartBody{}",multipartBody);
            Request request = new Request.Builder().url(url).post(multipartBody).build();
            log.info("组装请求实体{}",request);
            Call call = okHttpClient.newCall(request);
            result = unifiedResultHandle(call, response, result, json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              传输文件或者图片的公用方法
     * @Date: 2019年06月01日 18:22
     * @param url
     * @param json
     * @param file
     * @param type
     * @return net.sf.json.JSONObject
     **/
    public static JSONObject doPost(String url, JSONObject json, File file, String type){
        JSONObject result = new JSONObject();
        OkHttpClient okHttpClient = getOkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        Response response = null;
        try {
            if (ObjectUtils.isNotEmpty(json)) {
                Iterator<String> keys = json.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    String value = getJsonString(json, key);
                    log.info("key :{},value :{}", key, value);
                    builder.add(key, value);
                }
            }
            FormBody body = builder.build();
            log.info("组装body{}",body);
            if (ObjectUtils.isNotEmpty(file)) RequestBody.create(MediaType.parse("multipart/form-data"), image2byte(file));
            Request request = new Request.Builder().url(url).post(body).build();
            log.info("组装后的请求实体{}",request);
            Call call = okHttpClient.newCall(request);
            result = unifiedResultHandle(call, response, result, json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              统一结果处理
     * @Date: 2019年06月01日 17:40
     * @Param  * @param call
     * @param response
     * @param result
     * @param content
     * @return net.sf.json.JSONObject
     **/
    private static JSONObject unifiedResultHandle(Call call, Response response, JSONObject result, String content) {
        String resultData = "";
        try {
            int count = 0;
            StringBuffer sb = new StringBuffer();
            byte[] bytes = new byte[1024];

            response = call.execute();
            InputStream byteStream = response.body().byteStream();
            while ((count = byteStream.read(bytes)) != -1) {
                String str = new String(bytes, 0, count, "utf-8");
                sb.append(str);
            }
            resultData = sb.toString();
            bytes = null;
            log.info("返回结果{}", resultData);
            response.body().source().close();
            log.info("响应状态{}", response.isSuccessful());
            if (response.isSuccessful()) {
                result.put("code", GlobalEnums.RESULT_CODE_ENUMS.SUEECEE_CODE.getResultCode());
                result.put("data", resultData);
                return result;
            }
        } catch (UnknownHostException e) {
            log.info("UnknownHostException端口错误{}", " 服务器端口异常。");
        } catch (Exception e) {
            log.info("ERR_CONNECTION_REFUSED无法访问此网站{}", " 服务器拒绝了我们的连接请求。");
        }
        return result;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              获得OkHttpClient
     * @Date: 2019年06月01日 17:50
     * @return okhttp3.OkHttpClient
     **/
    public static OkHttpClient getOkHttpClient(){
        return new OkHttpClient().newBuilder().connectTimeout(maxHttpTiemSecond, TimeUnit.SECONDS).build();
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              字符串转换成接送
     * @Date: 2019年06月01日 18:28
     * @param jsonObject
     * @param map
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    public static Map<String, Object> jsonToMap(JSONObject jsonObject, Map<String, Object> map) {
        @SuppressWarnings("unchecked")
        Set<String> keys = jsonObject.keySet();
        for (String key : keys) {
            Object value = getJsonString(jsonObject, key);
            if (ObjectUtils.isNotEmpty(value)) {
                map.put(key, value);
            }
        }
        return map;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              根据key获取结果值字符串
     * @Date: 2019年06月01日 18:28
     * @param jsonString
     * @param key
     * @return java.lang.String
     **/
    public static String getJsonString(JSONObject jsonString, String key) {
        String result = "";
        Object obj = getJsonObj(jsonString, key);
        if (obj != null) {
            result = obj.toString();
        }
        return result;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          根据key获取结果值
     * @Date: 2019年06月01日 18:29
     * @Param  * @param jsonString
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

    private static String image2byte(File file) {
        return null;
    }

}
