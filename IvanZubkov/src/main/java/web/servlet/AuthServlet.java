package web.servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth", name = "AuthServlet")

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User userForCheck = new User(login, password);
        req.getSession().setAttribute("currentUser", userForCheck);
        List<User> users = (List<User>) req.getSession().getAttribute("users");
        if (users.contains(userForCheck.getLogin().equals(login))){
            if (users.contains(userForCheck.getPassword().equals(password))) {
                resp.sendRedirect("/pages.calc.jsp");
            } else {
                req.setAttribute("message", "Wrong password!");
                resp.sendRedirect("/pages/auth.jsp");
            }
            req.setAttribute("message", "Wrong login!");
            resp.sendRedirect("/pages/auth.jsp");
        }
           getServletContext().getRequestDispatcher("/pages.calc.jsp").forward(req, resp);
        }
    }

