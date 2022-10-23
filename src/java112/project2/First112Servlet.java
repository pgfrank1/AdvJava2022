package java112.project2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet simply outputs a name, the class title, an image, and a link
 * back to the home page
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
@WebServlet(
    name = "first112Servlet", 
    urlPatterns = { "/project2FirstServlet" }
)
public class First112Servlet extends HttpServlet{
   
    /**
     * This method recieves the user request and outputs the required HTML
     * text
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<html><head><title>First112Servlet</title></head>"
                + "<body><h1>Patrick Frank</h1><p>Advanced Java Programming"
                + "</p><p><a href='/java112'>Back to home</a></p>"
                + "<img src='./images/code.png' /></body></html>");
    }
}