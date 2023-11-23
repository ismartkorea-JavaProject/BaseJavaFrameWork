package egovframework.test;

import io.jsonwebtoken.Jwts;

public class getAllClaimsFromTokenTest {
	
	private static final String SECRET_KEY = "sonsystem"; // 실제 프로젝트에서는 이 값을 보안상의 이유로 외부에 노출시키면 안됩니다.
	private static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLqtIDrpqzsnpAiLCJuYW1lIjoi6rSA66as7J6QIiwiaWQiOiJhZG1pbiIsImV4cCI6MTcwMDQ2OTI3OCwiaWF0IjoxNzAwNDY1Njc4fQ.4LNB6jtfW7rONefVpavPY7Ho045xrXNX02MpwOhvaMg";
	private static final String ToKEN2 = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVU1JhZG1pbiIsImV4cCI6MTcwMDQ3NDc2MCwiaWF0IjoxNzAwNDcxMTYwfQ.I6LgR5SlNl6n5KUGo90CwHvZTPxMj__JEMu1ymYojq-dgE-vzBSkwTyAVkQs3cW8mYHW9OKjPFVujEzLq92E7A";
	private static final String ToKEN3 = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJVU1JhZG1pbiIsInBhc3N3b3JkIjoiSmZRN0ZJYXRsYUU1amo3clBZTzhRQkFCWDh5YjdiTmJReTRBS1kxUUlmYz0iLCJ1c2VyU2UiOiJVU1IiLCJpZCI6ImFkbWluIiwiZXhwIjoxNzAwNDc1MjY3LCJpYXQiOjE3MDA0NzE2Njd9.caTBRr0vQhePjf0JszxBccuVwTiPVYgPG2YLHP34UjE";
    private static final String TOKEN_UTF8 = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiLthqDtgbAg7Iug6recIOyDneyEsSIsIm5hbWUiOiLqtIDrpqzsnpAiLCJpZCI6ImFkbWluIiwiZXhwIjoxNzAwNDcwODIwLCJpYXQiOjE3MDA0NjcyMjB9.ROjWguS-RmrPN7rAsga3Juc_d_9mB3wi4NidLDPsITM";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    	System.out.println("===>>> getAllClaimsFromToken <<<===");
    	System.out.println("===>>> secret = "+SECRET_KEY);
    	
    	System.out.println("===>>> Jwts.parser() : " + Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(ToKEN3).getBody());
        
	}

}
