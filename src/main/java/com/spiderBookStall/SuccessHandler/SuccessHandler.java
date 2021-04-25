package com.spiderBookStall.SuccessHandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SuccessHandler implements AuthenticationSuccessHandler
{
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/homePage");
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin");
            } else  {
                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/student");
            }

          }
    }
}
