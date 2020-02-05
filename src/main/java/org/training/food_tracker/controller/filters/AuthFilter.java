package org.training.food_tracker.controller.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.food_tracker.controller.servlet.LogoutServlet;
import org.training.food_tracker.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    private static final Logger log = LogManager.getLogger(AuthFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        ServletContext context = servletRequest.getServletContext();

        log.debug("logged users: {}", servletRequest.getServletContext().getAttribute("loggedUsers"));

        String path = request.getRequestURI();
        log.debug("path: {}", path);

        User user = getUserIfLoggedIn(session);

        boolean isLoggedIn = user != null;
        boolean isLoginRequest = path.contains("login");

        if (!isLoggedIn && isLoginRequest) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        if (isLoggedIn && isLoginRequest) {
            response.sendRedirect("/logout");
            return;
        }


        filterChain.doFilter(servletRequest,servletResponse);
    }

    private User getUserIfLoggedIn(HttpSession session) {
        return (session.getAttribute("user") instanceof User) ? (User) session.getAttribute("user") : null;
    }

    @Override
    public void destroy() {

    }
}
