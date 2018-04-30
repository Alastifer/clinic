package com.clinic.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class DefaultAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final String ATTRIBUTE_USERNAME = "username";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        request.getSession().setAttribute(ATTRIBUTE_USERNAME, authentication.getName());
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))) {
            getRedirectStrategy().sendRedirect(request, response, "/employee");
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            getRedirectStrategy().sendRedirect(request, response, "/patient");
        }
    }
}
