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
            req.setAttribute("massage", "Access denied");
            req.getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, resp);
        } else {
            if (req.getSession().getAttribute("all operation") == null) {
                req.getSession().setAttribute("all operation", new ArrayList<>());
            }
            String num1 = req.getParameter("num1");
            String num2 = req.getParameter("num2");
            String operation = req.getParameter("operation");
            if (num1.isEmpty() || num2.isEmpty()) {
                req.setAttribute("massage", "All fields must be filled ");
                req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
            } else {
                double resultOperation = Calculator.calculator(Double.parseDouble(num1), Double.parseDouble(num2), operation);
                req.setAttribute("resultOperation", resultOperation);
                req.getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
                List<String> all_operation = (List<String>) getServletContext().getAttribute("all operation");
                all_operation.add("Result= " + num1 + " " + operation + " " + num2 + "= " + resultOperation);

            }
        }
    }
}