package com.barbeariaapi.tenant;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class DataSourceFilter extends OncePerRequestFilter {

    private static final String DB_KEY_HEADER = "X-DB-KEY";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String dbKey = request.getHeader(DB_KEY_HEADER);
        if (dbKey != null && !dbKey.isEmpty()) {
            System.out.println("🔑 Header X-DB-KEY detectado: " + dbKey);
            DataSourceContextHolder.set(dbKey);
        } else {
            System.out.println("⚠️ Nenhum header X-DB-KEY enviado. Usando banco padrão.");
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            DataSourceContextHolder.clear(); // importantíssimo
        }
    }
}
