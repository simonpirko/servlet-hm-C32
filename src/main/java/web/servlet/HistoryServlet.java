package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "history", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<String> all_operation = (List<String>) getServletContext().getAttribute("all operation");
        String operation = req.getParameter("operation");

        if ("sum".equals(operation)) {
            for (String str : all_operation) {
                if (str.contains("sum")) {
//                    resp.getWriter().println(str);
                    List<String> str11 =new ArrayList<>();
                    req.setAttribute("Str",str11);
                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
                }
            }
        }
        if ("div".equals(operation)) {
            for (String str2 : all_operation) {
                if (str2.contains("div")) {
//                    resp.getWriter().println(str);
                    List<String> str12 =new ArrayList<>();
                    req.setAttribute("Str",str12);
                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
                }
            }
        }
        if ("minus".equals(operation)) {
            for (String str4 : all_operation) {
                if (str4.contains("minus")) {
//                    resp.getWriter().println(str);
                    List<String> str14 =new ArrayList<>();
                    req.setAttribute("Str",str14);
                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
                }
            }
        }
        if ("multiply".equals(operation)) {
            for (String str3 : all_operation) {
                if (str3.contains("multiply")) {
//                    resp.getWriter().println(str);
                    List<String> str13 =new ArrayList<>();
                    req.setAttribute("Str",str13);
                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
                }
            }
        }

        if ("clear".equals(operation)) {
            all_operation.clear();
//            resp.getWriter().println("History is empty");
            req.setAttribute("massage","History is empty");
        }

        if ("showAll".equals(operation)) {
            int count = 0;
            for (String str5 : all_operation) {
                count++;
//                resp.getWriter().println(count + ") " + str);
                List<String> str15 =new ArrayList<>();
                req.setAttribute("Str",count + ") " + str15);
                req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
            }
        }

    }
}

