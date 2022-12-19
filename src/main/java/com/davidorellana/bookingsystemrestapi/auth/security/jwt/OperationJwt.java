package com.davidorellana.bookingsystemrestapi.auth.security.jwt;

import com.davidorellana.bookingsystemrestapi.auth.dto.TokenDto;
import com.davidorellana.bookingsystemrestapi.user.model.data.User;
import io.jsonwebtoken.Claims;

import java.util.Calendar;

public interface OperationJwt {

    String generateJwt(User user, Calendar expirationDate);
    TokenDto generateTokenDto(User user);
    Boolean validateJwt(String jwt, User user);
    Claims returnClaims(String jwt);
    String extractSubject(String jwt);
}
