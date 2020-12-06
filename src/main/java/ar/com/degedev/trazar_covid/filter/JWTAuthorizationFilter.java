package ar.com.degedev.trazar_covid.filter;

import io.jsonwebtoken.Jwts;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static ar.com.degedev.trazar_covid.ConstantsConfig.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        val token = request.getHeader(HEADER_AUTHORIZACION_KEY);
        if (token != null) {
            // Se procesa el token y se recupera el usuario.
            val user = Jwts.parser()
                    .setSigningKey(SIGNATURE_KEY)
                    .parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
        if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }
        val authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

}
