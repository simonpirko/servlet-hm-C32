package web.servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getSession().getId() == null) {
            } else {
                User currentUser = (User) req.getSession().getAttribute("currentUser");
//                resp.getWriter().println("You're out. Goodbye " + currentUser.getName());
                req.getSession().invalidate();
                resp.sendRedirect("/");
            }
        } catch (NullPointerException e) {
//            resp.getWriter().println("You dont have active session");
            req.setAttribute("massage","You dont have active session");
            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
        }

    }
}
