package com.davidorellana.bookingsystemrestapi.auth.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jwt;
    private Date expirationJwt;

    public TokenDto() { }

    public TokenDto(String jwt, Date expirationJwt) {
        this.jwt = jwt;
        this.expirationJwt = expirationJwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpirationJwt() {
        return expirationJwt;
    }

    public void setExpirationJwt(Date expirationJwt) {
        this.expirationJwt = expirationJwt;
    }

    @Override
    public String toString() {
        return "TokenDto{" +
                "jwt='" + jwt + '\'' +
                ", expirationJwt=" + expirationJwt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenDto tokenDto = (TokenDto) o;
        return Objects.equals(jwt, tokenDto.jwt) && Objects.equals(expirationJwt, tokenDto.expirationJwt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jwt, expirationJwt);
    }
}
