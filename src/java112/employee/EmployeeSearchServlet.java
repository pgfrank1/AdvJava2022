package java112.employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * The type Employee search servlet.
 */

@WebServlet(
        name = "EmployeeSearchServlet",
        value = "/EmployeeSearchServlet"
)

public class EmployeeSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/employeeSearch.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);

        dispatcher.forward(request, response);

    }
}
