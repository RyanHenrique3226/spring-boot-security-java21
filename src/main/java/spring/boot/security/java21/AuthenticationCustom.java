package spring.boot.security.java21;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationCustom implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)throws IOException, ServletException {

        var roles = authentication.getAuthorities();

        if (roles.stream().anyMatch(r -> r.getAuthority().equals("ROLE_MANAGER"))){
            response.sendRedirect("/manager");
        } else if (roles.stream().anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
            response.sendRedirect("/users");
        }else {
            response.sendRedirect("/");
        }


    }
}
