package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Properties;

/**
 * This java Servlet acts as the main method, initializes the needed variables,
 * and sets those to the ServletContext.
 *
 * @author pgfrank1
 * @version 1.0
 * @since 11.0
 *
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)

/**
 * Utilizes the init method from HttpServlet to create the needed variables
 * across the application scope.
 */
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * Initializes the properties and employeeDirectory variables.
     *
     * @throws ServletException Servlet error
     */
    @Override
    public void init() throws ServletException {

        Properties properties = loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);

        getServletContext().setAttribute("project4Properties", properties);
        getServletContext().setAttribute("employeeDirectory", employeeDirectory);
    }
}
