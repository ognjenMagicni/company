package com.transport.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.transport.dto.UserRegisterDto;
import com.transport.entity.Driver;
import com.transport.entity.Manager;
import com.transport.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthProvider {
    String secretKey = "secret";

    public String createToken(User user){
        Date now = new Date();
        Date expire = new Date(now.getTime()+3600000);
        return JWT.create()
                .withIssuedAt(now)
                .withExpiresAt(expire)
                .withClaim("name",user.getName())
                .withClaim("surname",user.getSurname())
                .sign(Algorithm.HMAC256(this.secretKey));
    }

    public String createToken(Driver driver){
        Date now = new Date();
        Date expire = new Date(now.getTime()+3600000);
        return JWT.create()
                .withIssuedAt(now)
                .withExpiresAt(expire)
                .withClaim("name",driver.getName())
                .withClaim("surname",driver.getSurname())
                .sign(Algorithm.HMAC256(this.secretKey));
    }

    public String createToken(Manager manager){
        Date now = new Date();
        Date expire = new Date(now.getTime()+3600000);
        return JWT.create()
                .withIssuedAt(now)
                .withExpiresAt(expire)
                .withClaim("name",manager.getName())
                .withClaim("surname",manager.getSurname())
                .sign(Algorithm.HMAC256(this.secretKey));
    }

    public Authentication validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(this.secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decode = verifier.verify(token);
        UserRegisterDto user = UserRegisterDto.builder()
                .name(decode.getClaim("name").asString())
                .surname(decode.getClaim("surname").asString())
                .build();
        return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
    }
}
