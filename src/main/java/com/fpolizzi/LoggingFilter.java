package com.fpolizzi;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by fpolizzi on 04.05.26
 */
@Component
@Order(1)
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.println("Logging Filter: ");

        request.getHeaderNames()
                .asIterator()
                .forEachRemaining(n ->
                        System.out.println(n + " :" + request.getHeader(n)));

        if (request.getHeader("Amigoscode").equals("reject")) {
            HttpServletResponse httpServletResponse =
                    (HttpServletResponse) servletResponse;
            ((HttpServletResponse) servletResponse).sendError(403);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
