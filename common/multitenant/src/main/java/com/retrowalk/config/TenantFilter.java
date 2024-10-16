package com.retrowalk.config;

import com.retrowalk.enums.Database;
import com.retrowalk.enums.Headers;
import com.retrowalk.models.TenantContext;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class TenantFilter extends OncePerRequestFilter {

    static final String TENANT_HEADER = Headers.TENANT_ID.getValue();

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String tenantId = request.getHeader(TENANT_HEADER);
            if (tenantId == null || tenantId.isEmpty()) {
                tenantId = Database.DEFAULT_DATABASE.getDbName();
            }

            TenantContext.setCurrentTenant(tenantId);
            filterChain.doFilter(request, response);

        } finally {
            TenantContext.clear();
        }
    }
}

