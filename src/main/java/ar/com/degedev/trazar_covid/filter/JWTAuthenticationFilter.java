package ar.com.degedev.trazar_covid.filter;

import ar.com.degedev.trazar_covid.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static ar.com.degedev.trazar_covid.ConstantsConfig.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            val user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(
                    user.getUserName(), user.getPassword(), new ArrayList<>())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response, FilterChain chain,
            Authentication auth) {

        val expirationTime = new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME);
        val token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512, SIGNATURE_KEY).compact();
        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
    }

}

