package java112.employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "EmployeeSearchResult",
        value = "/EmployeeSearchResult"
)

public class EmployeeSearchResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        ServletContext servletContext = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");

        String searchTerm = request.getParameter("search_term");
        String searchType = request.getParameter("search_type");

        Search search = employeeDirectory.searchEmployeeDatabase(searchTerm, searchType);

        session.setAttribute("search", search);

        String url = "/employeeSearchResult.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}
