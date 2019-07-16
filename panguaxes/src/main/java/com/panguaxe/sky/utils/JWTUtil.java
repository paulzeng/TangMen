package com.panguaxe.sky.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

/**
 * @Title JWTUtil
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 12:29
 **/
public class JWTUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JWTUtil.class);
    //TODO 设置token过期时间
    private static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;

    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO              校验token是否正确
     * @Date: 2019年07月12日 12:47
     * @param token         密钥
     * @param mobile        手机
     * @param secret        用户的密码
     * @return com.panguaxe.sky.common.APIResult
     **/
    public static APIResult tokenVerify(String token, String mobile, String secret) {
        APIResult result = new APIResult();
        result.setData(token);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier jwtVerifier = JWT.require(algorithm).withClaim("mobile", mobile).build();
            jwtVerifier.verify(token);
            return result.setMsg("token认证成功!");
        }catch (Exception e){
            if (e instanceof TokenExpiredException){
                result.setError("token过期!").setMsgCode(Integer.parseInt(GlobalEnums.API_TOKEN_EXPIRE.getMsgCode()));
                result.setData(sign(mobile,secret));
            }
            result.setError("token认证过期!");
            return result;
        }
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          获得token中的信息无需secret解密也能获得
     * @Date: 2019年07月12日 12:40
     * @param token     验签的token
     * @return java.lang.String     token中包含的用户名
     **/
    public static String getMobile(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("mobile").asString();
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * @Author 作者 : Panguaxe
     * @Description //TODO          生成签名 EXPIRE_TIME 后过期
     * @Date: 2019年07月12日 12:39
     * @param mobile
     * @param secret
     * @return java.lang.String
     **/
    public static String sign(String mobile, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带mobile信息
            return JWT.create()
                    .withClaim("mobile", mobile)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            LOGGER.info("JWT  token生成签名异常{}",e.getMessage());
            return null;
        }
    }

}
