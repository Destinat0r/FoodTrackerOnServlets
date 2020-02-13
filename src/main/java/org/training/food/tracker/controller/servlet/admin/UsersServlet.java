package org.training.food.tracker.controller.servlet.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.training.food.tracker.controller.servlet.LogoutServlet;
import org.training.food.tracker.dao.DaoException;
import org.training.food.tracker.model.User;
import org.training.food.tracker.service.UserService;
import org.training.food.tracker.service.defaults.UserServiceDefault;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users")
public class UsersServlet extends HttpServlet {

    private UserService userService;
    private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class.getName());

    @Override public void init() throws ServletException {
        userService = new UserServiceDefault();
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.debug("doGet()");
        List<User> users;
        LOG.debug("doGet() :: Selecting all users");
        try {
            users = userService.findAll();
        } catch (DaoException e) {
            LOG.error("doGet() :: Error occurred during selecting all users");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
            return;
        }

        request.setAttribute("users", users);
        request.getRequestDispatcher("/jsp/admin/users.jsp").forward(request, response);
    }
}
