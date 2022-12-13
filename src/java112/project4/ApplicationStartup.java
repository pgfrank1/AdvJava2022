package java112.project4;

import java112.employee.EmployeeDirectory;
import java112.utilities.PropertiesLoader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Properties;

@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/project4-startup" },
        loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    @Override
    public void init() throws ServletException {

        Properties properties = loadProperties("/project4.properties");
        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);

        getServletContext().setAttribute("project4Properties", properties);
        getServletContext().setAttribute("employeeDirectory", employeeDirectory);

    }
}
