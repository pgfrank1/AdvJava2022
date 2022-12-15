package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.employee.Search;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * This servlet retrieves the searchTerm and searchType that is needed to
 * query the database for the related employees
 */
@WebServlet(
        name = "EmployeeSearchResult",
        value = "/EmployeeSearchResult"
)

public class EmployeeSearchResult extends HttpServlet {
    /**
     * Gets the 2 form inputs from the user, checks the database with them,
     * and places the results into the current Session
     *
     * @param request the user request
     * @param response the server response
     * @throws ServletException servlet errors
     * @throws IOException I/O error
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        EmployeeDirectory employeeDirectory = (EmployeeDirectory) getServletContext().
                getAttribute("employeeDirectory");

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
