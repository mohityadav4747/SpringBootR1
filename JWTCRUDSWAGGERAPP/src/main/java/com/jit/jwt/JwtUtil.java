package com.jit.jwt;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	@Value("${app.secret}")
	private String secret;
	//6.valid uname in token and db expdate
	public boolean validateToken(String token,String userName) {
		String tokenuser=getUserName(token);
		return (userName.equals(tokenuser) && !isTokenExpire(token));
		
	}
	//5.validate exp date
	public boolean isTokenExpire(String token) {
		Date expdate=getExpDate(token);
		return expdate.before(new Date(System.currentTimeMillis()));
	}
	//4.
	public String getUserName(String token) 
	{
		return getClaims(token).getSubject();
	}
	//3.read exp date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	//2 read token
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}
	//1.gen token
	public String generateToken(String subject){
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("jay001infotech")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact()
				;
	}
}
