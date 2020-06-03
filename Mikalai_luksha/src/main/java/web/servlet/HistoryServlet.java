package web.servlet;

import entity.Operation;
import service.HistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")

public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HistoryService historyService = new HistoryService();
        String operation = req.getParameter("operation");
        String sort = req.getParameter("sort");
        if (operation != null) {
            List<Operation> result = (List<Operation>) req.getSession().getAttribute("result");
            List<Operation> operations = (List<Operation>) historyService.calcResult(operation, result);
            List<Operation> operations1 =  new ArrayList<>(operations);
            List<Operation> operationList = (List<Operation>) historyService.sortRes(sort, operations1);
            req.setAttribute("resHis", operationList);
            req.setAttribute("messageSort", "Operation -" + operation + ", sorting - " + sort );
        }
        getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }


}
