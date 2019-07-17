package com.panguaxe.sky.utils.safe;

import com.panguaxe.sky.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 				AES加解密工具类
 * @Date: 2019年06月06日 14:07
 **/
public class AESEncryptUtil {

	private static final Logger log = LoggerFactory.getLogger(AESEncryptUtil.class);

	public static void main(String[] args) throws Exception {
		String pwd = "190508";
		String key = getAesKey("18300665808");
		log.info("根据用户手机号生成的AES key 即salt盐值:{}",key);
		System.out.println(encrypt(pwd,key));//加密
		System.out.println(decrypt("i+5n9I5t1qaP8kVP0t4dTg==","7196ed46f69ed758"));//解密
	}

	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				获取加密后的AesKey秘钥
	 * @Date: 2019年06月06日 13:44
	 * @param mobileKey				手机号
	 * @return java.lang.String		加密后的AesKey秘钥
	 **/
	public static String getAesKey(String mobileKey) {
		return MD5Util.MD5(mobileKey).substring(10, 26);//截取md5之后的32位的10-26位字符串
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				AES加密
	 * @Date: 2019年06月06日 13:45
	 * @param content			加密内容
	 * @param key				秘钥，必须为16位
	 * @return java.lang.String
	 **/
	private static String encryptException(String content, String key) throws Exception {
		return getCiphertext(content,key);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				AES加密
	 * @Date: 2019年06月06日 13:46
	 * @param content			加密内容
	 * @param key				秘钥，必须为16位
	 * @return java.lang.String	加密结果
	 **/
	public static String encrypt(String content, String key) {
		return getCiphertext(content,key);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				根据明文串和key加密处理
	 * @Date: 2019年06月06日 14:16
	 * @param plaintext
	 * @param key
	 * @return java.lang.String
	 **/
	private static String getCiphertext(String plaintext, String key){
		try {
			if(ObjectUtils.isNotEmpty(plaintext)) {
				//对加密的key进行处理
				Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, key,"UTF-8");
				//1、对字符串进行翻转
				StringBuilder sb = new StringBuilder(plaintext);
				String reverse = sb.reverse().toString();
				//2、字符串进行左位移
				int moveNum = getMoveIndex(reverse);//左位移个数
				reverse = leftMove(reverse, moveNum);
				//3、字符串进行加密
				byte[] resultByte = cipher.doFinal(reverse.getBytes("UTF-8"));
				return (new sun.misc.BASE64Encoder()).encode(resultByte);
			}
		}catch (Exception e){
			e.printStackTrace();
			log.info("AES加密明文串异常: {}",e.getMessage());
		}
		return null;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				字符串需要位移个数
	 * @Date: 2019年06月06日 13:47
	 * @param content		需要位移的字符串内容
	 * @return int			字符串需要位移个数
	 **/
	private static int getMoveIndex(String content) {
		return content.length()/2;//左位移个数
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				AES解密
	 * @Date: 2019年06月06日 13:48
	 * @param content			加密内容
	 * @param key				秘钥，必须为16位
	 * @return java.lang.String	解密结果
	 **/
	public static String decrypt(String content, String key) {
		try {
			/**
			 * 1、对字符串进行解密
			 * 2、对字符串进行右位移（对加密内容进行左移n位（n值取决于字符串长度/2））
			 * 3、对字符串进行解密
			 */
			if(ObjectUtils.isNotEmpty(content)) {
				Cipher cipher = getCipher(Cipher.DECRYPT_MODE, key, "UTF-8");
				//1、对字符串进行解密
				byte[] inputByte = (new sun.misc.BASE64Decoder()).decodeBuffer(content);
				byte[] resultByte = cipher.doFinal(inputByte);
				String 	tContent = new String(resultByte, "UTF-8");
				//2、字符串进行左位移
				int moveNum = getMoveIndex(tContent);//右位移个数
				tContent = rightMove(tContent, moveNum);
				//3、对字符串进行翻转
				StringBuilder sb = new StringBuilder(tContent);
				return sb.reverse().toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				获取cipher对象
	 * @Date: 2019年06月06日 13:48
	 * @param mode			加密方式
	 * @param key			秘钥，必须为16位
	 * @param charset		字符编码
	 * @return javax.crypto.Cipher
	 **/
	private static Cipher getCipher(int mode, String key, String charset) throws Exception {
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(charset), "AES");
		//偏移量同秘钥相同
		IvParameterSpec ivParameterSpec = new IvParameterSpec(key.getBytes(charset));
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//算法/模式/补码方式
		cipher.init(mode, secretKeySpec, ivParameterSpec);
		return cipher;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				对字符串进行左位移
	 * @Date: 2019年06月06日 13:49
	 * @param content			需要左位移字符串
	 * @param index				位移个数
	 * @return java.lang.String	左位移后字符串
	 **/
	private static String leftMove(String content,int index){
		String first = content.substring(0,index);
		first = reChange(first);
		String second = content.substring(index);
		second = reChange(second);
		content = first + second;
		return reChange(content);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				对字符串进行处理
	 * @Date: 2019年06月06日 13:50
	 * @param content			需要处理的字符串
	 * @return java.lang.String	处理后的字符串
	 **/
	private static String reChange(String content){
		char[] contents = content.toCharArray();
		int length = contents.length;
		for (int i = 0; i < length/2; i++){
			char temp = contents[i];
			contents[i] = contents[length - 1 -i];
			contents[length - 1 -i] = temp;
		}
		return String.valueOf(contents);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO					对字符串进行右位移
	 * @Date: 2019年06月06日 13:50
	 * @param content			需要右位移字符串
	 * @param index				位移个数
	 * @return java.lang.String	右位移后字符串
	 **/
	private static String rightMove(String content,int index){
		content = reChange(content);
		String first = content.substring(0,index);
		first = reChange(first);
		String second = content.substring(index);
		second = reChange(second);
		return first + second;
	}
}
