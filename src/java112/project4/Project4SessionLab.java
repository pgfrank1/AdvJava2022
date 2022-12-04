package java112.project4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * This servlet gets the project4SessionCounter attribute and adds a 1 each time
 * the page is accessed. Each session will start at 1 and continue until the
 * browser is closed.
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 */
@WebServlet(name = "Project4SessionLab", value = "/Project4SessionLab")
public class Project4SessionLab extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer sessionCounter = (Integer) session.getAttribute("project4SessionCounter");

        if (sessionCounter == null) {
            sessionCounter = 1;
            session.setAttribute("project4SessionCounter", sessionCounter);
        } else {
            sessionCounter++;
            session.setAttribute("project4SessionCounter", sessionCounter);
        }

        String url = "/project4Session.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
