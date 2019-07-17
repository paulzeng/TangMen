package com.panguaxe.sky.utils.safe;

import com.panguaxe.sky.land.model.Account;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Title PasswordSafeUtils
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/13 9:39
 **/
public class PasswordSafeUtils {

    private static RandomNumberGenerator RANDOMNUMBERGENERATOR = new SecureRandomNumberGenerator();
    private static String ALGORITHMNAME = "md5";
    private static int HASHITERATIONS = 2;

    public static void main(String[] args) {
        //fa260c404fa6a829fb8b934e7150da43
        System.out.println(getEncryptPassword("19937755858","888888","8a6e313f0c2230d0c98a571283c612f8"));
        System.out.println(checkPassword("18300665808","ly20161006","522e2c4aff3aa42c6a08518ef8969c3c","453bdd046e06465a36f61c4fb87693d1"));
        String pwd = new SimpleHash(ALGORITHMNAME, "888888", ByteSource.Util.bytes("19937755858" + "8a6e313f0c2230d0c98a571283c612f8"), HASHITERATIONS).toHex();
        System.out.println(pwd);
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              获取盐值
     * @Date: 2019年07月13日 09:46
     * @return java.lang.String
     **/
    public static String getPasswordSalt(){
        return RANDOMNUMBERGENERATOR.nextBytes().toHex();
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              获取加密后的密码
     * @Date: 2019年07月13日 09:49
     * @param telephone         手机号
     * @param password          密码
     * @param salt              盐值
     * @return java.lang.String
     **/
    public static String getEncryptPassword(String telephone,String password,String salt){
        String encryptPwd = new SimpleHash(ALGORITHMNAME, password, ByteSource.Util.bytes(telephone + salt), HASHITERATIONS).toHex();
        return encryptPwd;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              校验密码是否正确
     * @Date: 2019年07月13日 10:06
     * @param username          用户名/手机号
     * @param plaintextPwd      明文密码
     * @param salt              盐值(该用户账户表中的盐值)
     * @param ciphertextPwd     密文密码(该用户账户表中的密码)
     * @return boolean
     **/
    public static boolean checkPassword(String username, String plaintextPwd, String salt, String ciphertextPwd) {
        // 组合username,两次迭代，对密码进行加密
        String password_cipherText = new Md5Hash(plaintextPwd, username + salt, 2).toHex();
        return ciphertextPwd.equals(password_cipherText);
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              获取原密码
     * @Date: 2019年07月13日 09:56
     * @param account
     * @param password
     * @return java.lang.String
     **/
    public static String getOriginalPassword(Account account, String password) {
        return new SimpleHash(ALGORITHMNAME, password, ByteSource.Util.bytes(account.getUserName() + account.getSalt()), HASHITERATIONS).toHex();
    }

    public static String getPwd(String accountName, String password, String salt) {
        return new Md5Hash(password, accountName + salt, 2).toHex();
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              不能全是相同的数字或者字母（如：000000、111111、aaaaaa） 全部相同返回true
     * @Date: 2019年07月13日 09:58
     * @param numOrStr
     * @return boolean
     **/
    public static boolean equalStr(String numOrStr) {
        boolean flag = true;
        char str = numOrStr.charAt(0);
        for (int i = 0; i < numOrStr.length(); i++) {
            if (str != numOrStr.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              不能是连续的数字--递增（如：123456、12345678）连续数字返回true
     * @Date: 2019年07月13日 09:59
     * @param numOrStr
     * @return boolean
     **/
    public static boolean isOrderNumeric(String numOrStr) {
        // 如果全是连续数字返回true
        boolean flag = true;
        // 如果全是数字返回true
        boolean isNumeric = true;
        for (int i = 0; i < numOrStr.length(); i++) {
            if (!Character.isDigit(numOrStr.charAt(i))) {
                isNumeric = false;
                break;
            }
        }
        // 如果全是数字则执行是否连续数字判断
        if (isNumeric) {
            for (int i = 0; i < numOrStr.length(); i++) {
                if (i > 0) {// 判断如123456
                    int num = Integer.parseInt(numOrStr.charAt(i) + "");
                    int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") + 1;
                    if (num != num_) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }

    // 不能是连续的数字--递减（如：987654、876543）连续数字返回true
    public static boolean isOrderNumeric_(String numOrStr) {
        boolean flag = true;// 如果全是连续数字返回true
        boolean isNumeric = true;// 如果全是数字返回true
        for (int i = 0; i < numOrStr.length(); i++) {
            if (!Character.isDigit(numOrStr.charAt(i))) {
                isNumeric = false;
                break;
            }
        }
        if (isNumeric) {// 如果全是数字则执行是否连续数字判断
            for (int i = 0; i < numOrStr.length(); i++) {
                if (i > 0) {// 判断如654321
                    int num = Integer.parseInt(numOrStr.charAt(i) + "");
                    int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") - 1;
                    if (num != num_) {
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
        }
        return flag;
    }
}
