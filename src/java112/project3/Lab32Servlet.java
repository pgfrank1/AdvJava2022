package java112.project3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "Lab32Servlet",
        value = "/Lab32Servlet"
)
public class Lab32Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<ul><li>" + request.getLocale() + "</li><li>" + request.getContextPath() + "</li><li>"
                + request.getLocalName() + "</li><li>" + request.getScheme() + "</li></ul>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
