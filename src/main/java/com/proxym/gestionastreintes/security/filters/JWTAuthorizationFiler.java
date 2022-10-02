package com.proxym.gestionastreintes.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.proxym.gestionastreintes.security.JWTUtil;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//3malna parse lel bearer fih 7
public class JWTAuthorizationFiler extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // if (request.getServletPath().equals("/refreshToken")) {
        // filterChain.doFilter(request, response);
        // } else if (request.getServletPath().equals("/login")) {
        // filterChain.doFilter(request, response);
        // return;
        // } else {
        // System.out.println(request.getServletPath());
        // String authorizationToken = request.getHeader(JWTUtil.AUTH_HEADER);
        // if (authorizationToken != null &&
        // authorizationToken.startsWith(JWTUtil.PREFIX)) {
        // try {
        // String jwt = authorizationToken.substring(JWTUtil.PREFIX.length());
        // Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
        // JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        // DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
        // String username = decodedJWT.getSubject();
        // String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        // Collection<GrantedAuthority> authorities = new ArrayList<>();
        // for (String r : roles) {
        // authorities.add(new SimpleGrantedAuthority(r));
        // }
        // //intercepter la requete faire les verifications puis je passe au filtre
        // suivant wou mba3ed requete temchi lil dipatcher servlets
        // //authentifier l'user
        // UsernamePasswordAuthenticationToken authenticationToken =
        // new UsernamePasswordAuthenticationToken(username, null, authorities);
        // SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // filterChain.doFilter(request, response);
        // } catch (Exception e) {
        //
        // response.setHeader("error-message", e.getMessage());
        // response.sendError(HttpServletResponse.SC_FORBIDDEN);
        //
        // }
        //
        // } else {
        // filterChain.doFilter(request, response);
        // }
        // }
        //
        // }
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (request.getRequestURI().equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        } else {
            String jwtToken = request.getHeader(JWTUtil.AUTH_HEADER);
            System.out.println("Token=" + jwtToken);
            if (jwtToken == null || !jwtToken.startsWith(JWTUtil.PREFIX)) {
                filterChain.doFilter(request, response);
                return;
            }
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(JWTUtil.SECRET)).build();
            String jwt = jwtToken.substring(JWTUtil.AUTH_HEADER.length());
            DecodedJWT decodedJWT = verifier.verify(jwt);
            System.out.println("JWT=" + jwt);
            String username = decodedJWT.getSubject();
            List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
            System.out.println("username=" + username);
            System.out.println("roles=" + roles);
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            roles.forEach(rn -> {
                authorities.add(new SimpleGrantedAuthority(rn));
            });
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null,
                    authorities);
            SecurityContextHolder.getContext().setAuthentication(user);
            filterChain.doFilter(request, response);
        }
    }
}
