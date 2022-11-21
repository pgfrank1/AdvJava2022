package java112.project3;

import java112.utilities.PropertiesLoader;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

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

       Map project3Properties = new HashMap<>();

       project3Properties.put("project3Author", properties.getProperty("project.3.author"));
       project3Properties.put("emailAddress", properties.getProperty("author.email.address"));
       project3Properties.put("courseTitle", properties.getProperty("course.title"));
       project3Properties.put("courseMeetingDays", properties.getProperty("course.meeting.days"));
       project3Properties.put("instructorName", properties.getProperty("instructor.name"));
       project3Properties.put("descriptionLineOne", properties.getProperty("description.line.one"));
       project3Properties.put("descriptionLineTwo", properties.getProperty("description.line.two"));
       project3Properties.put("descriptionLineThree", properties.getProperty("description.line.three"));
       project3Properties.put("descriptionLineFour", properties.getProperty("description.line.four"));

       req.setAttribute("properties", project3Properties);

       String url = "/project3Properties.jsp";

       RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
       dispatcher.forward(req, resp);
    }
}