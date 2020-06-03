package web.servlet;

import entity.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Collections;

@WebServlet(urlPatterns = "/history", name = "HistoryServlet")

public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);

        String sortType = req.getParameter("sort");
        List<Operation> historyList = (List<Operation>) req.getSession().getAttribute("historyList");

        if (sortType != null && sortType.equalsIgnoreCase("increase")) {
            historyList.sort(Operation::compareTo);
            req.setAttribute("sorteredList", historyList);
            getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
        if (sortType != null && sortType.equalsIgnoreCase("decline")) {
            historyList.sort(Operation::compareTo);
            Collections.reverse(historyList) ;
            req.setAttribute("sorteredList", historyList);
            getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }

    }
}
