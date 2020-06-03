package web.servlet;

import service.UserService;
import service.UserStorage;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthUserServlet extends HttpServlet {
    private UserStorage userStorage = new UserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login.isEmpty() || password.isEmpty()) {
            req.setAttribute("massage", "All fields must be filled ");
            req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        } else {
            UserService userService = new UserService();
            User user = userService.authService(login, password);
            if (user != null){
                req.getSession().setAttribute("currentUser", user);
                req.getSession().setAttribute("checkAuth", true);
                resp.sendRedirect("/");
            } else {
                String message = userService.authMessageService(login, password);
                req.setAttribute("message",message);
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
            }
        }
    }
}