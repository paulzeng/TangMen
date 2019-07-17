package com.panguaxe.sky.SDK.faceocr.utils;

import com.panguaxe.sky.SDK.faceocr.config.FaceOCRConfig;
import com.panguaxe.sky.SDK.faceocr.enums.FaceOCRStatusEnum;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.utils.ObjectUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @Title FaceOCRUtil
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/5 10:47
 **/
public class FaceOCRUtil {

    private static final Logger log = LoggerFactory.getLogger(FaceOCRUtil.class);
    private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();

    public static void main(String[] args) throws Exception,IOException{
        String url = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
        File file = new File("C:\\Users\\Administrator\\Desktop\\ocr\\IDC-front.jpg");
//        Map<String, byte[]> imageFile = imageFile(file);//TODO 构建图片参数
//        byte[] bacd = post(url,imageFile);
//        String result = new String(bacd);// byte[]转String
//        APIResult apiResult = handleResult("IDC", result);
//        System.out.println(JSONObject.fromObject(apiResult));
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              处理结果
     * @Date: 2019年07月05日 13:21
     * @param type
     * @param result
     * @return com.panguaxe.axe.common.APIResult
     **/
    public static APIResult handleResult(String type,JSONObject result){
        log.info("请求返回结果：{}",result);
        APIResult api = new APIResult();
        String httpCode = result.getString("httpCode");
        if (Integer.parseInt(httpCode) != 200) {
            JSONObject errorData = result.getJSONObject("data");
            String error_message = errorData.getString("error_message");
            String errorMsg = FaceOCRStatusEnum.getReturnMsg(error_message);
            return api.setError(errorMsg);
        }
        JSONObject data = result.getJSONObject("data");
        api.setData(data);
        if ("1".equals(type)){//身份证
            if (data.containsKey("cards")){
                JSONArray cards = data.getJSONArray("cards");
                if (cards.size() > 0){
                    Map<String, Object> map = jsonArrayToMap(cards);
                    api.setData(map);
                    api.setMsg("身份证信息识别成功!");
                }else {
                    api.setError("未识别到身份证信息!");
                }
            }else {
                api.setError("未识别到身份证信息");
            }
        }else if ("2".equals(type)){//银行卡
            if (data.containsKey("bank_cards")){
                JSONArray bank_cards = data.getJSONArray("bank_cards");
                if (bank_cards.size() > 0){
                    JSONObject bankCards = (JSONObject)bank_cards.get(0);
                    if (bankCards.containsKey("number") && bankCards.containsKey("bank")){
                        Map<String, Object> map = new HashMap<>();
                        if (bankCards.containsKey("organization")){
                            JSONArray organization = bankCards.getJSONArray("organization");
                            if (organization.size() > 0) map.put("organization",organization.get(0));
                        }
                        String number = bankCards.getString("number");
                        String bank = bankCards.getString("bank");
                        map.put("number",number);
                        map.put("bank",bank);
                        api.setData(map);
                        api.setMsg("银行卡信息识别成功!");
                    }
                }else {
                    api.setError("未识别到银行卡信息!");
                }
            }else {
                api.setError("未识别到银行卡信息!");
            }
        }else {
            api.setError("不支持的识别类型!");
        }
        return api;
    }



    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              发送请求
     * @Date: 2019年07月05日 11:46
     * @param type
     * @param file
     * @return byte[]
     **/
    public static JSONObject post(String type,MultipartFile file)throws Exception {
        JSONObject result = new JSONObject();
        //TODO 构建基础参数
        Map<String, String> map = putParam();
        //TODO 构建图片参数
        InputStream ins = file.getInputStream();
        File f = new File(file.getOriginalFilename());
        inputStreamToFile(ins, f);
        Map<String, byte[]> imageFile = imageFile(f);
        //TODO 根据类型获取对应的请求地址
        String reqURL = FaceOCRStatusEnum.FACE_OCR_URL.getReqURL(type);
        URL url1 = new URL(reqURL);
        //TODO 发送请求
        HttpURLConnection conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if (imageFile != null && imageFile.size() > 0) {
            Iterator fileIter = imageFile.entrySet().iterator();
            while (fileIter.hasNext()) {
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey() + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();//TODO 释放资源
        int code = conne.getResponseCode();
        ins = (code == 200) ? conne.getInputStream() : conne.getErrorStream();
        //TODO 读取内容
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while ((len = ins.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        ins.close();//TODO 释放资源
        f.delete();//TODO 删除临时文件
        String str = baos.toString();
        if (baos.toString().endsWith("\n"))  str = str.replace("\n","");
        result.put("httpCode",code);
        result.put("data",str);
        return result;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              校验参数是否为空
     * @Date: 2019年07月05日 11:14
     * @param file                  待识别文件
     * @param type                  类型
     * @return boolean
     **/
    public static boolean dataCheck(MultipartFile file, String type) throws Exception {
        boolean flag = true;
        if (file.equals("") || file.getSize() <= 0) flag = false;
        if (ObjectUtils.isEmpty(type)) flag = false;
        return flag;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              校验文件大小是否大于2MB
     * @Date: 2019年07月05日 11:19
     * @param file
     * @return boolean
     **/
    private static boolean checkFileSize(File file){
        boolean flag = false;
        BigDecimal initial = BigDecimal.valueOf(file.length());// 图片初始大小
        BigDecimal initialKb = initial.divide(BigDecimal.valueOf(1024));// 转Kb
        BigDecimal fin = initialKb.divide(BigDecimal.valueOf(1024));// 转换为兆M
        if (fin.compareTo(FaceOCRConfig.Limit_Size) > 0) {// 如果大于2兆 压缩图片大小
            flag = true;
        }
        return flag;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  根据指定大小压缩图片
     * @Date: 2019年07月05日 11:25
     * @param imageBytes        源图片字节数组
     * @return byte[]
     **/
    public static byte[] compressPicForScale(byte[] imageBytes) throws IOException {
        long appointFileSize = FaceOCRConfig.APPOINT_FILESIZE;//TODO 指定图片大小，单位kb
        if (imageBytes == null || imageBytes.length <= 0 || imageBytes.length < appointFileSize * 1024) {
            return imageBytes;
        }
        long srcSize = imageBytes.length;
        double accuracy = getAccuracy(srcSize / 1024);
        while (imageBytes.length > appointFileSize * 1024) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
            Thumbnails.of(inputStream).scale(accuracy).outputQuality(accuracy).toOutputStream(outputStream);
            imageBytes = outputStream.toByteArray();
        }
        return imageBytes;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              自动调节精度(经验数值)
     * @Date: 2019年07月05日 11:27
     * @param size          源图片大小
     * @return double       图片压缩质量比
     **/
    private static double getAccuracy(long size) {
        double accuracy;
        if (size < 900) {
            accuracy = 0.85;
        } else if (size < 2047) {
            accuracy = 0.6;
        } else if (size < 3275) {
            accuracy = 0.44;
        } else {
            accuracy = 0.4;
        }
        return accuracy;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              文件读取 写入
     * @Date: 2019年07月05日 11:16
     * @param ins
     * @param f
     * @return void
     **/
    public static void inputStreamToFile(InputStream ins, File f) throws Exception {
        try {
            OutputStream os = new FileOutputStream(f);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              构建APIKey和APISecret 等必须参数
     * @Date: 2019年07月05日 11:30
     * @param
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    private static Map<String, String> putParam() {
        Map<String, String> map = new HashMap<>();
        map.put("api_key", FaceOCRConfig.FaceOCR_APIKey);// api_key
        map.put("api_secret", FaceOCRConfig.FaceOCR_APISecret);// api_secret
        map.put("return_landmark", "1");
        map.put("return_attributes",
                "gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
        return map;
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO                  构建图片参数  如果大于2MB做压缩处理  否则原图大小直接上送
     * @Date: 2019年07月05日 11:43
     * @param file
     * @return java.util.Map<java.lang.String,byte[]>
     **/
    public static Map<String, byte[]> imageFile(File file) throws IOException{
        Map<String, byte[]> map = new HashMap<>();
        byte[] fromFile = getBytesFromFile(file);
        boolean flag = checkFileSize(file);
        //true 即大于2MB  做压缩处理
        if (flag){
            fromFile = compressPicForScale(fromFile);
        }
        map.put("image_file", fromFile);// 构建文件参数
        return map;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              初始文件大小
     * @Date: 2019年07月05日 11:41
     * @param f
     * @return byte[]
     **/
    @SuppressWarnings("Duplicates")
    public static byte[] getBytesFromFile(File f) throws IOException{
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
    }

    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(
                    random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }

    private static String encode(String value) throws Exception {
        return URLEncoder.encode(value, "UTF-8");
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              JSONArray数组转map
     * @Date: 2019年07月05日 13:14
     * @param array
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    private static  Map<String, Object> jsonArrayToMap(JSONArray array) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (array.size() > 0) {
            JSONObject obj = JSONObject.fromObject(array.get(0));
            Iterator<String> iterator = obj.keys();
            String key = null;
            String value = null;
            while (iterator.hasNext()) {
                key = iterator.next();
                value = obj.getString(key);
                map.put(key, value);
            }
        }
        return map;
    }


}
