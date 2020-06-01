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
        User userByLogin = userStorage.getUserByLogin(req.getParameter("login"));

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(name, login, password);

//        try {
//            if (userStorage.getUserByLogin("login").equals(login)) {
//                req.getSession().setAttribute("currentUser", user);
//                req.setAttribute("massage","User is already exists");
//                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//            }
//        } catch (NullPointerException e) {
////            resp.getWriter().println("User is already exists");
//            req.setAttribute("massage","User is already exists");
//            req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//        }
        resp.sendRedirect("/auth");
        userStorage.add(user);
       // resp.getWriter().println("Registration was successful. Your data:" + "name - " + user.getName() + " ;login -  " + user.getLogin() + " ;password -  " + user.getPassword());

    }
}
