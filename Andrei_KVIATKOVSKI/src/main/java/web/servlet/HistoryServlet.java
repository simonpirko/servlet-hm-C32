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
        List<String> all_operation = (List<String>) getServletContext().getAttribute("all operation");
        req.setAttribute("sum1",all_operation);
        req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        List<String> all_operation = (List<String>) getServletContext().getAttribute("all operation");
//        String operation = req.getParameter("operation");
//
//        if ("sum".equals(operation)) {
//            for (String str : all_operation) {
//                if (str.contains("sum")) {
//                    List<String> sum =new ArrayList<>();
//                    sum.add(str);
//                    req.setAttribute("sum",sum);
//                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
//                }
//            }
//        }
//
//        if ("div".equals(operation)) {
//            for (String str : all_operation) {
//                if (str.contains("div")) {
//                    List<String> div =new ArrayList<>();
//                    div.add(str);
//                    req.setAttribute("div",div);
//                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
//                }
//            }
//        }
//
//        if ("minus".equals(operation)) {
//            for (String str : all_operation) {
//                if (str.contains("minus")) { ;
//                    List<String> minus =new ArrayList<>();
//                    minus.add(str);
//                    req.setAttribute("minus",minus);
//                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
//                }
//            }
//        }
//
//        if ("multiply".equals(operation)) {
//            for (String str : all_operation) {
//                if (str.contains("multiply")) {
//                    List<String> multiply =new ArrayList<>();
//                    multiply.add(str);
//                    req.setAttribute("multiply",multiply);
//                    req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
//                }
//            }
//        }
//
//        if ("showAll".equals(operation)) {
//            int count = 0;
//            for (String str : all_operation) {
//                count++;
////                resp.getWriter().println(count + ") " + str);
//                List<String> showAll =new ArrayList<>();
//                req.setAttribute("showAll",count + ") " + showAll);
//                req.getServletContext().getRequestDispatcher("/pages/history.jsp").forward(req, resp);
//            }
//        }

 //    }
}

