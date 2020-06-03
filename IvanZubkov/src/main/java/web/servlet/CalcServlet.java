package web.servlet;

import entity.Operation;
import entity.User;
import service.ServiceCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @WebServlet(name = "CalcServlet", urlPatterns = "/calc")

public class CalcServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("flag", true);
            getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("flag", false);
            List <Operation> historyList = (List) req.getSession().getAttribute("historyList");
            User currentUser = (User) req.getSession().getAttribute("currentUser");
            double num1 = Double.parseDouble(req.getParameter("num1"));
            double num2 = Double.parseDouble(req.getParameter("num2"));
            String calcAction = req.getParameter("operation");
            ServiceCalc calculator = (ServiceCalc) req.getSession().getAttribute("calculator");
            double resultOfCalculation = calculator.calculation(calcAction, num1, num2);
            Operation operation = new Operation(num1, num2, resultOfCalculation, calcAction, currentUser);
            historyList.add(operation);

            getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);

        }
}
