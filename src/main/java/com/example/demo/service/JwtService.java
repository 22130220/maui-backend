package com.example.demo.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class JwtService {
    String key = null;
    public JwtService(@Value("${jwt.secret}") String secret){
    this.key = secret;
    }

    public String generateToken(Map<String, Object> claims,String subject){
       return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(new Date(System.currentTimeMillis()+30*60*1000))  // het han sau 30 phút
                .setClaims(claims)
                .compact();
    }

    public Claims parseToken(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    public String getSubject(String token){
        return parseToken(token).getSubject();
    }
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
    public boolean isTokenValid(String token, String username) {
        final String tokenUsername = getSubject(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

}
