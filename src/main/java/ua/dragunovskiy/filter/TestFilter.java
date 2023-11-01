package ua.dragunovskiy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

// filter just check host name just for example
public class TestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String host = request.getHeader("Host");
        if (host.equals("localhost:8081")) {
            filterChain.doFilter(request, response);
        } else {
            throw new AccessDeniedException("wrong host name");
        }
    }
}
