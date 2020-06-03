package web.servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/reg", name = "RegServlet")

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User newUser = new User(name, login, password);
        req.getSession().setAttribute("currentUser", newUser);
        List<User> users = (List<User>) req.getSession().getAttribute("users");
        if (users.contains(newUser.getLogin().equals(login))) {
            users.add(new User(login, name, password));
            resp.sendRedirect("/");
        }
        else {
            req.setAttribute("message", "Login can't be used");
            getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
        }
    }
}
