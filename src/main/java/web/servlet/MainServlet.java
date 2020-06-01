package web.servlet;

import service.Calculator;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("currentUser") == null) {
            resp.getWriter().println("Access denied");
        } else {
            User currentUser = (User) session.getAttribute("currentUser");
            if (req.getSession().getAttribute("all operation") == null) {
                req.getSession().setAttribute("all operation", new ArrayList<>());
            }
            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            String operation = req.getParameter("operation");
            double resultOperation = Calculator.calculator(Integer.parseInt(num1), Integer.parseInt(num2), operation);
            req.setAttribute("resultOperation",resultOperation);
            req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
//            resp.getWriter().println
//                    ("Hi " + currentUser.getName() +
//                            "!" + "Yore result " + num1 + " " + operation + " " + num2 + " = " + resultOperation);

            List<String> all_operation = (List<String>) getServletContext().getAttribute("all operation");
            all_operation.add("Result= " + num1 + " " + operation + " " + num2 + "= " + resultOperation);

        }
    }
}