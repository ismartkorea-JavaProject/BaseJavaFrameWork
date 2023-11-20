package egovframework.test;

import io.jsonwebtoken.Jwts;

public class getAllClaimsFromTokenTest {
	
	private static final String SECRET_KEY = "sonsystem"; // 실제 프로젝트에서는 이 값을 보안상의 이유로 외부에 노출시키면 안됩니다.
	private static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLqtIDrpqzsnpAiLCJuYW1lIjoi6rSA66as7J6QIiwiaWQiOiJhZG1pbiIsImV4cCI6MTcwMDQ2OTI3OCwiaWF0IjoxNzAwNDY1Njc4fQ.4LNB6jtfW7rONefVpavPY7Ho045xrXNX02MpwOhvaMg";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	System.out.println("===>>> getAllClaimsFromToken <<<===");
    	System.out.println("===>>> secret = "+SECRET_KEY);
    	
    	System.out.println("===>>> Jwts.parser() : " + Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(TOKEN).getBody());
        
	}

}
