package org.training.food.tracker.controller.servlet.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.food.tracker.dao.DaoException;
import org.training.food.tracker.dao.jdbc.DayDaoJDBC;
import org.training.food.tracker.dao.jdbc.FoodDaoJDBC;
import org.training.food.tracker.dto.DTOconverter;
import org.training.food.tracker.dto.FoodDTO;
import org.training.food.tracker.dto.UserDTO;
import org.training.food.tracker.model.Day;
import org.training.food.tracker.model.User;
import org.training.food.tracker.service.FoodService;
import org.training.food.tracker.service.UserService;
import org.training.food.tracker.service.defaults.ConsumedFoodServiceDefault;
import org.training.food.tracker.service.defaults.DayServiceDefault;
import org.training.food.tracker.service.defaults.FoodServiceDefault;
import org.training.food.tracker.service.defaults.UserServiceDefault;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/main")
public class UserMainServlet extends HttpServlet {

    private UserService userService;
    private FoodService foodService;

    private static final Logger log = LogManager.getLogger(UserMainServlet.class.getName());
    private DayServiceDefault dayService;

    @Override public void init() throws ServletException {
        userService = new UserServiceDefault();
        foodService = new FoodServiceDefault(new FoodDaoJDBC(), new ConsumedFoodServiceDefault());
        dayService = new DayServiceDefault(new DayDaoJDBC());
    }

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("user");

        request.setAttribute("food", new FoodDTO());
        try {
            log.debug("setting allCommonFood");
            request.setAttribute("allCommonFood",
                    foodService.findAllCommonExcludingPersonalByUserIdInDTO(currentUser.getId()));

            log.debug("getting current day");
            Day currentDay = dayService.getCurrentDayOfUser(currentUser);
            request.setAttribute("currentDay", currentDay);

            log.debug("getting consumedStatsDTO");
            request.setAttribute("consumedStatsDTO", dayService.getConsumeStatsForDay(currentDay));

            log.debug("setting usersFoodDTOs");
            request.setAttribute("usersFoodDTOs", foodService.findAllByOwnerInDTOs(currentUser));

        } catch (DaoException e) {
            e.printStackTrace();
        }


        UserDTO userDTO = DTOconverter.userToUserDTO(currentUser);
        log.debug("setting userDTO {}", userDTO);
        request.setAttribute("userDTO", userDTO);

        request.getRequestDispatcher("/jsp/user/main.jsp").forward(request, response);
    }
}