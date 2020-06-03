package web.servlet;

import service.UserStorage;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegUserServlet extends HttpServlet {
    private UserStorage userStorage = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (name.isEmpty() || login.isEmpty() || password.isEmpty()) {
            req.setAttribute("massage", "All fields must be filled ");
            req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
        } else {
            User user = new User(name, login, password);

            if (userStorage.checkUserByLogin("login")) {
                req.setAttribute("massage", "User is already exists");
                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("/auth");
                userStorage.add(user);
            }
        }
    }
}