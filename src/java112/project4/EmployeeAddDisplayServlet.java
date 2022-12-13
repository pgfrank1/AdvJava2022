package java112.project4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EmployeeAddDisplayServlet", value = "/EmployeeAddDisplayServlet")
public class EmployeeAddDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/employeeAddNewEmployee.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);

        dispatcher.forward(request, response);
    }
}
