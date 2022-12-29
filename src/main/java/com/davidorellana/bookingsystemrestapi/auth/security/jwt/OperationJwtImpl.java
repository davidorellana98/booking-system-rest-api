package com.davidorellana.bookingsystemrestapi.auth.security.jwt;

import com.davidorellana.bookingsystemrestapi.auth.dto.TokenDto;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Date;

public class OperationJwtImpl implements OperationJwt {

    @Value("${KEY_SECRET}")
    private String KEY_SECRET;

    private final Integer MINUTES_JWT_EXPIRATION = 30;

    @Override
    public String generateJwt(User user, Calendar expirationDate) {

        return Jwts.builder()
                .setSubject(user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, KEY_SECRET)
                .compact();
    }

    @Override
    public TokenDto generateTokenDto(User user) {
        Calendar dateExpiration = Calendar.getInstance();
        dateExpiration.add(Calendar.MINUTE, MINUTES_JWT_EXPIRATION);
        String jwt = generateJwt(user, dateExpiration);
        return new TokenDto(jwt, dateExpiration.getTime());
    }

    @Override
    public Boolean validateJwt(String jwt, User user) {
        Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
        return user.getId().equals(extractSubject(jwt)) && !isJwtExpired;
    }

    @Override
    public Claims returnClaims(String jwt) {
        return Jwts.parser()
                .setSigningKey(KEY_SECRET)
                .parseClaimsJws(jwt)
                .getBody();
    }

    @Override
    public String extractSubject(String jwt) {
        return returnClaims(jwt).getSubject();
    }
}
