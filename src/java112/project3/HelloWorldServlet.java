package java112.project3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This servlet demonstrates how to use annotations for a url to be able to view
 * the generated webpage
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 * */

@WebServlet(
        name = "HelloWorldServlet",
        value = "/HelloWorldServlet"
)

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>Hello World!</h1>");
    }
}
