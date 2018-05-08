package com.clinic.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndexPage(Authentication authentication) {
        if (authentication == null) {
            return "login";
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))) {
            return "redirect:/employee";
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/patient";
        }

        return null;
    }
}
