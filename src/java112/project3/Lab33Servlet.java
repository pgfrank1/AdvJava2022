package java112.project3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

/**
 * This class simply creates a HashMap, adds 4 different data types to the HashMap,
 * adds the map to the request argument, gets the location of the Lab 3-3 jsp, and
 * then forwards the HashMap to the Lab 3-3 jsp page.
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 **/

@WebServlet(
        name = "Lab33Servlet",
        value = "/Lab33Servlet"
)
public class Lab33Servlet extends HttpServlet {
    /**
     * This method recieves a request, makes a hash map, and sends that hash map
     * to a specified jsp page
     *
     * @param request the user request
     * @param response the server response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map simpleData = new HashMap<>();
        simpleData.put("number", 2);
        simpleData.put("text", "This is some sample text.");
        simpleData.put("html", "<h2>This is an h2 element</h2>");
        simpleData.put("aDate", new Date());

        request.setAttribute("myMap", simpleData);

        String url = "/lab33.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
