package com.Project.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import com.Project.entities.Role;
import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "toshiba";

    public String generateToken(Long emp_Id, Role role) {
        return Jwts.builder()
                .setSubject(String.valueOf(emp_Id))
                .claim("role", role.name())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Long extractEmpId(String token) {
        return Long.valueOf(extractClaim(token, Claims::getSubject));
    }

    public Role extractRole(String token) {
        String roleString = extractClaim(token, claims -> claims.get("role", String.class));
        return Role.valueOf(roleString);
    }

    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public boolean validateToken(String token, Long empId) {
        return empId.equals(extractEmpId(token)) && !isTokenExpired(token);
    }

    @FunctionalInterface
    public interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
