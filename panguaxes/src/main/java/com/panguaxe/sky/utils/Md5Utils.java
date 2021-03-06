package com.panguaxe.sky.utils;

import java.security.MessageDigest;

/**
 * @Title MD5Utils
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 14:19
 **/
public class Md5Utils {

    /**十六进制下数字到字符的映射数组*/
    private final static String[] HEXDIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d","e", "f" };

    public final static String getMD5(String str) {
        if (str != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  将得到的字节数组变成字符串返回
                byte[] results = md.digest(str.getBytes());
                StringBuffer resultSb = new StringBuffer();
                String a = "";
                for (int i = 0; i < results.length; i++) {
                    int n = results[i];
                    if (n < 0){
                        n = 256 + n;
                    }
                    int d1 = n / 16;
                    int d2 = n % 16;
                    a = HEXDIGITS[d1] + HEXDIGITS[d2];
                    resultSb.append(a);
                }
                return resultSb.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    public static String MD5Encode(String origin) {
        String result = null;
        try {
            result = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteArrayToHexString(md.digest(result.getBytes("UTF-8")));
        } catch (Exception exception) {
        }
        return result;
    }

}
