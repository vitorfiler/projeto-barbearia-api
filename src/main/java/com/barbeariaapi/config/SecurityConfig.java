package com.barbeariaapi.config;

import com.barbeariaapi.tenant.DataSourceContextHolder;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
@Order(100)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .addFilterBefore(new DBKeyFilter(), UsernamePasswordAuthenticationFilter.class)
            .addFilterAfter(new JWTAuthorizationFilter(), DBKeyFilter.class)
            .authorizeRequests()
            
            .antMatchers(HttpMethod.GET, "/estabelecimento/recuperacao").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.POST, "/estabelecimento").permitAll()
            .antMatchers(HttpMethod.POST, "/**").permitAll()
            .antMatchers(HttpMethod.GET, "/**").permitAll()
            .antMatchers(HttpMethod.PUT, "/**").permitAll()
            .antMatchers(HttpMethod.DELETE, "/**").permitAll()

            .anyRequest().authenticated();
    }

    public static class DBKeyFilter implements Filter {
        private static final String DB_KEY_HEADER = "X-DB-KEY";

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String dbKey = httpRequest.getHeader(DB_KEY_HEADER);
            if (dbKey != null && !dbKey.isEmpty()) {
                DataSourceContextHolder.set(dbKey.toLowerCase());
            }
            try {
                chain.doFilter(request, response);
            } finally {
                DataSourceContextHolder.clear();
            }
        }
    }
}
