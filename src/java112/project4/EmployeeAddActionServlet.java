package java112.project4;

import java112.employee.EmployeeDirectory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * This Servlet retrieves the form information sent from the employeeAddNewEmployee.jsp
 * file, checks each input to make sure they meet the database requirements, then
 * outputs if the employee was successfully added to the database.
 *
 * @author pgfrank1
 * @version 1.0
 * @since 11.0
 */
@WebServlet(
        name = "EmployeeAddActionServlet",
        value = "/EmployeeAddActionServlet"
)

public class EmployeeAddActionServlet extends HttpServlet {

    /**
     * Retrieves the form input, checks each input to ensure it meets the
     * database requirements, and tells the user if there has been an input
     * error or if the employee was successfully added to the databse.
     *
     * @param request the user request
     * @param response the user response
     * @throws ServletException servlet error
     * @throws IOException I/O exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory) getServletContext().
                getAttribute("employeeDirectory");
        String project4AddMessage;

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String ssn = request.getParameter("ssn");
        String department = request.getParameter("dept");
        String roomNumber = request.getParameter("room");
        String phoneNumber = request.getParameter("phone");

        if (firstName.equals("") || firstName.length() > 25) {
            project4AddMessage = "You must have a first name and use a maximum of 25 characters";

        } else if (lastName.equals("") || lastName.length() > 30) {
            project4AddMessage = "You must have a last name and use a maximum of 30 characters";

        } else if (ssn.equals("") || ssn.length() > 20) {
            project4AddMessage = "You must have a social security number and use a maximum of 20 characters";

        } else if (department.equals("") || department.length() > 10) {
            project4AddMessage = "You must have a department name and use a maximum of 10 characters";

        } else if (roomNumber.equals("") || roomNumber.length() > 10) {
            project4AddMessage = "You must have a room number and use a maximum of 10 characters";

        } else if (phoneNumber.equals("") || phoneNumber.length() > 10) {
            project4AddMessage = "You must have a phone number and use a maximum of 10 characters";

        } else {
            employeeDirectory.addEmployeeToDatabase(firstName, lastName, ssn,
                    department, roomNumber, phoneNumber);
            project4AddMessage = "Successfully added " + firstName + " " + lastName + " as a new employee";
        }

        session.setAttribute("project4AddMessage", project4AddMessage);

        String url = "./EmployeeAddDisplayServlet";

        response.sendRedirect(url);
    }
}
