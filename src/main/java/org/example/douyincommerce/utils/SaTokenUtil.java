package org.example.douyincommerce.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.HttpServletRequest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SaTokenUtil {

    private static final String SECRET = "y6plziidr4a5prcw6zupgyihrd6o0id2as1238dfda1dafmbm";

    private SaTokenUtil(){}

    /**
     * @desc  1.检测token的合法性
     * @author zjk
     */
    public boolean isFailed(HttpServletRequest req) {
        try {
            String token =  req.getHeader("Authorization").substring("Bearer ".length());
            Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public boolean isFailed(String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return false;
        }catch (Exception e){
            return true;
        }
    }

    /**
     * @desc 2.创建token
     * @author 张家口
     */
    public static   String createToken(String id,String name) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        Map<String,Object> header = new HashMap<>();
        Map<String,Object> params = new HashMap();

        //添加头
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        //添加负载
        params.put("id", id);
        params.put("name", name);
        //生成token内容,设定两周内有效
        String token = Jwts.builder()
                .setHeader(header)
                .setClaims(params)
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
        return token;
    }

    /**
     * @desc  3.从token中获取用户id
     * @param req
     * @return
     */
    public static String getId(HttpServletRequest req) {
        String token =  req.getHeader("Authorization").substring("Bearer ".length());
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return(String) body.get("id");
    }
    public static String getId(String token) {
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return(String) body.get("id");
    }
    public static String getName(HttpServletRequest req) {
        String token =  req.getHeader("Authorization").substring("Bearer ".length());
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return(String) body.get("id");
    }
    public static String getName(String token) {
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return(String) body.get("id");
    }

}
