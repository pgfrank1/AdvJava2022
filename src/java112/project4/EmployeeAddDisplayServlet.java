package java112.project4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * This Servlet simply forwards users to the employeeAddNewEmployee.jsp file
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 */
@WebServlet(name = "EmployeeAddDisplayServlet", value = "/EmployeeAddDisplayServlet")
public class EmployeeAddDisplayServlet extends HttpServlet {
    /**
     * Forwards the user to the employeeSearch.jsp file
     * @param request the user request
     * @param response the server response
     * @throws ServletException servlet errors
     * @throws IOException I/O error
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/employeeAddNewEmployee.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
