package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.memory.MealDaoInMemoryImpl;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/meal")
public class EditMealServlet extends HttpServlet {
    private MealDao mealDao = new MealDaoInMemoryImpl();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            Meal meal = mealDao.get(Long.parseLong(req.getParameter("id")));
            req.setAttribute("meal", meal);
        }
        req.getRequestDispatcher("/meal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateTime = req.getParameter("dateTime") + " 00:00";
        String calories = req.getParameter("calories");
        String id = req.getParameter("id");
        Meal meal = new Meal(dateTime != null ? LocalDateTime.parse(dateTime, dateTimeFormatter) : null,
                req.getParameter("description"),
                calories != null ? Integer.parseInt(calories) : null);
        if (id != null && !id.isBlank()) {
            meal.setId(Long.valueOf(id));
            mealDao.update(meal);
        }
        else {
            mealDao.save(meal);
        }
        resp.sendRedirect("meal?id=" + meal.getId());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            mealDao.delete(Long.parseLong(req.getParameter("id")));
        }
    }
}
