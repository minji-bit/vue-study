package kr.co.wikibook.gallery.common.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenUtils {
    private static final Key signKey;

    static {
        //외부에 노출되면 안되는 중요한 보안키(32바이트 이상)
        String secretKey = "SECURITY_KEY_2025112415484134854_!!";
        byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        signKey = new SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    //토큰발급
    public static String generate(String subject,String name, Object value,int expMinutes){
        //만료 시간 설정
        Date expTime = new Date();

        //분(minute)을 밀리초로 변환해 입력
        expTime.setTime(expTime.getTime() + expMinutes * 60 * 1000L);

        //기본 정보 입력
        HashMap<String, Object> map = new HashMap<>();
        map.put("typ","JWT");
        map.put("alg","HS256");

        //클레임 입력
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(name,value);

        //토큰 발급
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(map)
                .setSubject(subject)
                .setExpiration(expTime)
                .setClaims(claims)
                .signWith(signKey, SignatureAlgorithm.HS256);

        return jwtBuilder.compact();
    }

    public static boolean isValid(String token){
        //토큰 값이 있다면
        if(StringUtils.hasLength(token)){
            try{
                Jwts.parser().setSigningKey(signKey).build().parseClaimsJws(token);
                return true;
            }catch (ExpiredJwtException e){//만료됨
            }catch (JwtException e){//유효하지 않음
            }
        }
        return false;
    }

    //토큰값 추출
    public static Map<String,Object> parse(String token){
        return Jwts.parser().setSigningKey(signKey).build().parseClaimsJws(token).getBody();
    }
}
