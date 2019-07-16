package com.panguaxe.sky.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.panguaxe.sky.common.AuthToken;
import com.panguaxe.sky.config.WeChatPayConfig;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.*;

/**
 * @Author 作者 : Panguaxe
 * @Description //TODO 
 * @Date: 2019年07月12日 14:09
 **/
public class WeChatDefrayUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatDefrayUtils.class);

	/** 扩展xstream,使其支持name带有"_"的节点*/
	public static XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
	private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.146 Safari/537.36";
	/**字符集GBK*/
	public static final Charset GBK = Charset.forName("GBK");
	/**字符集ISO-8859-1*/
	public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
	/**字符集UTF-8*/
	public static final Charset UTF_8 = Charset.forName("UTF-8");

	public static ObjectMapper jsonObjectMapper = new ObjectMapper();



	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				根据code获取微信授权access_token
	 * @Date: 2019年07月12日 14:10
	 * @param code
	 * @return com.panguaxe.sky.common.AuthToken
	 **/
	public static AuthToken getTokenByAuthCode(String code) {
		AuthToken authToken = null;
		StringBuilder json = new StringBuilder();
		try {
			URL url = new URL("");
			URLConnection uc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				json.append(inputLine);
			}
			in.close();
			// 将json字符串转成javaBean
			authToken = jsonToEntity(json.toString(), AuthToken.class);
		} catch (IOException ex) {
			LOGGER.info("获取access_token异常");
		}
		return authToken;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				获取微信签名
	 * @Date: 2019年07月12日 14:12
	 * @param map		请求参数集合
	 * @param apiKey
	 * @return java.lang.String		微信请求签名串
	 **/
	public static String getSign(SortedMap<String, Object> map, String apiKey) {
		StringBuffer buffer = new StringBuffer();
		Set<Map.Entry<String, Object>> set = map.entrySet();
		Iterator<Map.Entry<String, Object>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			String k = entry.getKey();
			Object v = entry.getValue();
			// 参数中sign、key不参与签名加密
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				buffer.append(k + "=" + v + "&");
			}
		}
		buffer.append("key=" + apiKey);
		String sign = Md5Utils.MD5Encode(buffer.toString()).toUpperCase();
		return sign;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				解析微信服务器发来的请求
	 * @Date: 2019年07月12日 14:13
	 * @param inputStream
	 * @return java.util.Map<java.lang.String,java.lang.String>		微信返回的参数集合
	 **/
	public static Map<String, String> parseXml(InputStream inputStream) {
		SortedMap<String, String> map = new TreeMap<String, String>();
		try {
			// 获取request输入流
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			// 得到xml根元素
			Element root = document.getRootElement();
			// 得到根元素所有节点
			List<Element> elementList = root.elements();
			// 遍历所有子节点
			for (Element element : elementList) {
				map.put(element.getName(), element.getText());
			}
			// 释放资源
			inputStream.close();
		} catch (Exception e) {
			LOGGER.info("微信工具类:解析xml异常");
		}
		return map;
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				请求参数转换成xml
	 * @Date: 2019年07月12日 14:14
	 * @param data
	 * @return java.lang.String			xml字符串
	 **/
	public static String sendDataToXml(Object data) {
		xStream.autodetectAnnotations(true);
		xStream.alias("xml", Object.class);
		return xStream.toXML(data);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO			获取当前时间戳
	 * @Date: 2019年07月12日 14:15
	 * @return java.lang.String
	 **/
	public static String getTimeStamp() {
		return String.valueOf(System.currentTimeMillis() / 1000);
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				Json字符转Java实体
	 * @Date: 2019年07月12日 14:15
	 * @param jsonString		Json字符串
	 * @param entityType		实体类型
	 * @return T                default null，表示转换失败
	 **/
	public static <T> T jsonToEntity(String jsonString, Class<T> entityType) {
		T entity = null;
		try {
			entity = jsonObjectMapper.readValue(jsonString, entityType);
		} catch (Exception e) {
			LOGGER.info("Json字符转Java实体异常");
		}
		return entity;
	}


	public static String postSSL(String url, String data, String certPath, String certPass) {
		HttpsURLConnection conn = null;
		OutputStream out = null;
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			KeyStore clientStore = KeyStore.getInstance("PKCS12");
			clientStore.load(new FileInputStream(certPath), certPass.toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(clientStore, certPass.toCharArray());
			KeyManager[] kms = kmf.getKeyManagers();
			SSLContext sslContext = SSLContext.getInstance("TLSv1");

			sslContext.init(kms, null, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			URL _url = new URL(url);
			conn = (HttpsURLConnection) _url.openConnection();

			conn.setConnectTimeout(25000);
			conn.setReadTimeout(25000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
			conn.connect();

			out = conn.getOutputStream();
			out.write(data.getBytes(UTF_8));
			out.flush();

			inputStream = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream,UTF_8));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(out);
			closeQuietly(reader);
			closeQuietly(inputStream);
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	public static String post(String url, String data,String certPass) {
		HttpsURLConnection conn = null;
		OutputStream out = null;
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			URL _url = new URL(url);
			conn = (HttpsURLConnection) _url.openConnection();
			conn.setConnectTimeout(25000);
			conn.setReadTimeout(25000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
			conn.connect();
			out = conn.getOutputStream();
			out.write(data.getBytes(UTF_8));
			out.flush();
			inputStream = conn.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream,UTF_8));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			closeQuietly(out);
			closeQuietly(reader);
			closeQuietly(inputStream);
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * closeQuietly
	 * @param closeable 自动关闭
	 */
	public static void closeQuietly(Closeable closeable) {
		try {
			if (closeable != null) {
				closeable.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO				发送post请求
	 * @Date: 2019年07月12日 14:17
	 * @param url				请求地址
	 * @param outputEntity		发送内容
	 * @param isLoadCert		是否加载证书
	 * @return org.apache.http.client.methods.CloseableHttpResponse
	 **/
	public static CloseableHttpResponse Post(String url, String outputEntity, boolean isLoadCert) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		// 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
		httpPost.addHeader("Content-Type", "text/xml");
		httpPost.setEntity(new StringEntity(outputEntity, "UTF-8"));
		if (isLoadCert) {
			// 加载含有证书的http请求
			return HttpClients.custom().setSSLSocketFactory(initCert()).build().execute(httpPost);
		} else {
			return HttpClients.custom().build().execute(httpPost);
		}
	}
	/**
	 * @Author 作者 : Panguaxe
	 * @Description //TODO			加载证书
	 * @Date: 2019年07月12日 14:17
	 * @return org.apache.http.conn.ssl.SSLConnectionSocketFactory
	 **/
	public static SSLConnectionSocketFactory initCert() throws Exception {
		FileInputStream instream = null;
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		instream = new FileInputStream(new File(WeChatPayConfig.WECHAT_MCH_CERT));
		keyStore.load(instream, WeChatPayConfig.MCH_ID.toCharArray());
		if (null != instream) {
			instream.close();
		}
		SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, WeChatPayConfig.MCH_ID.toCharArray()).build();
		return new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	}

    /**
     * @Description: TODO --- 将参数拼成map,生产签名
     * @author 作者：Mike
     * @date 2019年07月12日 14:17
     */
    public static SortedMap<String, Object> buildParamMap(Object data) {
        SortedMap<String, Object> paramters = new TreeMap<String, Object>();
        Field[] fields = data.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (null != field.get(data)) {
                    paramters.put(field.getName().toLowerCase(), field.get(data).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramters;
    }

	/**
	 * 针对支付的xml，没有嵌套节点的简单处理
	 *
	 * @param xmlStr
	 *            xml字符串
	 * @return <Map<String, String>>
	 */
	public static Map<String, String> xmlToMap(String xmlStr) {
		XmlHelper xmlHelper = XmlHelper.of(xmlStr);
		return xmlHelper.toMap();
	}
	
}
