package java112.project3;

import java112.utilities.PropertiesLoader;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * This servlet opens the project3.properties file and adds it to an attribute
 * for the Properties jsp to be able to view and output each key/value pair.
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 */
@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = {"/project-3-properties"}
)

public class PropertiesServlet  extends HttpServlet implements PropertiesLoader {
    /**
     * Holds the properties class to be able to open a properties file
     * */
    private Properties properties;

    /**
     * Initializes the properties instance variable
     * */
    @Override
    public void init() throws ServletException {
        properties = new Properties(loadProperties("/project3.properties"));
    }

    /**
     * Returns the properties content from the specified properties file path
     *
     * @param propertiesFilePath a path to a file on the java classpath list
     * @return properties within the specified properties file
     */
    @Override
    public Properties loadProperties(String propertiesFilePath) {
        return PropertiesLoader.super.loadProperties(propertiesFilePath);
    }

    /**
     * This method recieves the client request, adds the properties attribute
     * to the request, then forwards the client to the specified JSP
     *
     * @param req the client request
     * @param resp the server response
     * @throws ServletException throws exception
     * @throws IOException throws exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("properties", properties);

        String url = "/project3Properties.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
