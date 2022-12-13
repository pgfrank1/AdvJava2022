package java112.project4;

import java112.employee.EmployeeDirectory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "EmployeeAddActionServlet",
        value = "/EmployeeAddActionServlet"
)

public class EmployeeAddActionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        EmployeeDirectory employeeDirectory = (EmployeeDirectory) servletContext.getAttribute("employeeDirectory");
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
        servletContext.setAttribute("project4AddMessage", project4AddMessage);

        String url = "./EmployeeAddDisplayServlet";

        response.sendRedirect(url);

    }
}
