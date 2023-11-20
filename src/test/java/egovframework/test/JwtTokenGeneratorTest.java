package egovframework.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenGeneratorTest {

	private static final String SECRET_KEY = "sonsystem"; // 실제 프로젝트에서는 이 값을 보안상의 이유로 외부에 노출시키면 안됩니다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String username = "관리자"; // 예시로 사용할 사용자명
        String token = generateToken(username);
        System.out.println("Generated Token: " + token);		

	}
	
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600000); // 1시간 동안 유효한 토큰
        
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", "admin" );
        claims.put("name", "관리자" );

        return Jwts.builder()
        		.setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }	

}
