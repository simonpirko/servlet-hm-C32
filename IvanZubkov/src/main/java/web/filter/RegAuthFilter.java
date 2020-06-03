package web.filter;

import entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (filterName = "regFilter", servletNames = {"RegServlet", "AuthServlet"})
public class RegAuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("currentUser");
        if (user == null) {
            chain.doFilter(req, res);
        } else {
            req.setAttribute("message", "No action available");
            getServletContext().getRequestDispatcher("/").forward(req, res);
        }
    }
    }

