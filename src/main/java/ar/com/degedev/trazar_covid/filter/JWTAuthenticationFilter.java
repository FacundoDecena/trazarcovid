package ar.com.degedev.trazar_covid.filter;

import static ar.com.degedev.trazar_covid.ConstantsConfig.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.degedev.trazar_covid.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(
                    user.getUserName(), user.getPassword(), new ArrayList<>())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        Date expirationTime = new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME);
        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
                .setSubject(((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername())
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512, SIGNATURE_KEY).compact();
        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
    }

}

