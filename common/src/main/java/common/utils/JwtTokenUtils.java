package common.utils;

import com.model.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {

    private static final String SECRET = "tokenSecret";

    private static final Long EXPIRATION = 1000L * 3600 * 24;  // 过期时间一天


    /**
     * 生成token
     */
    public static String generateToken(SysUser sysUser) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("sub",sysUser.getUsername());
        claims.put("createTime", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     */
    public static String getUsernameByToken(String token) {
        String username;
        Claims claims = getClaimByToken(token);
        username = claims.getSubject();
        return username;
    }

    /**
     * 判断令牌是否过期
     */
    public static Boolean isTokenExpired(String token) {
        Claims claims = getClaimByToken(token);
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    /**
     * 刷新令牌
     */
    public static String refreshToken(String token) {
        Claims claims = getClaimByToken(token);
        claims.put("createTime",new Date());  //重新设置token生成时间
        return generateToken(claims);
    }

    /**
     * 验证令牌
     */
    public static Boolean validToken(String token,SysUser sysUser) {
        String username = getUsernameByToken(token);
        return (username.equals(sysUser.getUsername()) && !isTokenExpired(token));
    }

    /**
     * 获取请求头中的真正token值
     */
    public static String realToken(String head) {
        return head.replace("Bearer ", "");
    }

    /**
     * 生成token
     */
    public static String generateToken(Map<String,Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION);
        return Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }


    /**
     * 从令牌中获取数据声明
     */
    public static Claims getClaimByToken(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

}
