package main.first_project.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "0df1e826bb3f1f861c1ed32b9269650ea74b90a447cb754ba5dd66ba4af05d1c";

    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }

    public static String extractUsername(String token){

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token){

        try{
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;

        }catch (JwtException e){
            return false;
        }
    }
}