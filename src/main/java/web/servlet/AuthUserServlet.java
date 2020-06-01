package web.servlet;

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

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User userByLogin1 = userStorage.getUserByLogin(req.getParameter("name"));
//        req.setAttribute("name", userByLogin1);
//        req.getServletContext().getRequestDispatcher("/logout").forward(req, resp);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userByLogin = userStorage.getUserByLogin(req.getParameter("login"));
        try {
            if (userByLogin.getLogin() == null || !userByLogin.getLogin().equals("login")) {
            }
        }catch (NullPointerException e){
            req.setAttribute("massage", "User not found");
            req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }

        if (userByLogin.getPassword().equals(req.getParameter("password"))&&
                userByLogin.getLogin().equals(req.getParameter("login"))) {
            req.getSession().setAttribute("currentUser", userByLogin);
//            resp.getWriter().println("Yor are authorized." + "Hi " + userByLogin.getName() + "!");
            req.setAttribute("massage","Yor are authorized");
            resp.sendRedirect("/");
        } else {
            if (!userByLogin.getPassword().equals(req.getParameter("password")) || userByLogin.getPassword()==null)
//            resp.getWriter().println("password is not correct!");
            req.setAttribute("massage","Incorrect password");
            req.getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, resp);
        }
    }
}
