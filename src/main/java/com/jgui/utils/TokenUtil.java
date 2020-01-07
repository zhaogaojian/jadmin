package com.jgui.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.jgui.domain.JUser;

import java.util.Date;

/**
 * @Author: zhaogaojian
 * @Description:
 * @Date: Created in 2020/1/722:13
 */
public class TokenUtil {
    private static final long TOKEN_EXPIRE_TIME= 30*60*1000;//超时时间30分钟
    private static final long REFRESH_TOKEN_EXPIRE_TIME= 15*24*60*1000;//超时时间15天
    private static final String TOKEN_SECRET="jguiafadfiierpewirpew8908ewrq";//秘钥
    private static final String ISSUER="jgadmin";//签发人
    /**
     * 签名生成
     * @param user
     * @return
     */
    public static String sign(JUser user){

        String token = "";
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME);
            Date now = new Date();
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withClaim("username", user.getUsername())
                    .withExpiresAt(expiresAt)
                    .withIssuedAt(now)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;

    }
    /**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("签发时间：" + jwt.getIssuedAt());
            System.out.println("过期时间：" + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }

    }
    /**
     * 从token获取username
     */
    public static String getUsername(String token){
        try{
            return JWT.decode(token).getClaim("username").asString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}
