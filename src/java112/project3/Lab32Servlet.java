package java112.project3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This servlet gets information from the user request, it then outputs that information to the web page
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 * */
@WebServlet(
        name = "Lab32Servlet",
        value = "/Lab32Servlet"
)
public class Lab32Servlet extends HttpServlet {
    /**
     * This method recieves information from the client, then sends that information back to the webpage.
     *
     * @param request the user request
     * @param response the server response
     * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<title>Lab 3-2</title><ul><li>" + request.getLocale() + "</li><li>" + request.getContextPath()
                + "</li><li>" + request.getLocalName() + "</li><li>" + request.getScheme() + "</li></ul>");
    }
}
