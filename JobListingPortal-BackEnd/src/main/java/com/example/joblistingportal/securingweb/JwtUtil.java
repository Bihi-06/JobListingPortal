package com.example.joblistingportal.securingweb;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtUtil {

    private static final String SECRET_KEY = "f35fdd458975f195ac55be54cc9111ef26ab10a9d4e8f187d8a779096c704062288cfb2ac5bc21c80edf2ea434289eca44182642364a51885363bd92797bddd7bc5a118e3f9affe385078a08cadd8451f7e5c40c70036adf30dc6ad4ccae75f3855a1be481bac9fa2a5e341c373d93dfed90c68cc199f75f09cd65194cb782b0881ccb7c9b421165ef87e53928736f621654ac18ebac7e0b9cc3f50d7a86f00f9ed58f65fa67a378259396112267e4992733d10cbb0929214d383faecfc2fe8c4770ff23dd8822131f5bd56908285c72c5e0abfaa1b5b959b60c2b83922ba5059513dd2998711b7268c5fcad756c535203c8c6477dc4c767d2cc110e342b38f4";
    private static final Key SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 HOURS

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetails.getUsername());
        return createToken(claims, userDetails.getUsername());
    }

    public String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expirationDate.before(new Date());
    }
}
