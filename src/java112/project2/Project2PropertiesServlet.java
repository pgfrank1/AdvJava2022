package java112.project2;

import java112.utilities.PropertiesLoader;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This class contains the html for the Project2PropertiesServlet to show the 
 * project2.properties file contents
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */

@WebServlet(
    name = "project2PropertiesServlet",
    urlPatterns = {"/project2Properties"}
)


public class Project2PropertiesServlet extends HttpServlet implements
        PropertiesLoader {

    /**
     * Contains the keys and values from the project2.properties file
     */
    private Properties properties;

    /**
     * Initializes the properties variable
     */
    public void init() throws ServletException {
        properties = new Properties(loadProperties(
                "/project2.properties"));
    }

    /**
     * This method outputs HTML to the Project2 site. It shows all of the key
     * value pairs from the project2.properties file
     * 
     * @param req the user request
     * @param resp the server response
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<html><head><title>Project 2 Properties</title></head>"
                + "<body><style>table, th, td{border: 1px solid black}</style>"
                + "<h1>This is the Project 2 properties servlet</h1>"
                + "<a href='/java112'>Back to home</a>"
                + "<table><thead><th>Property</th><th>Value</th></thead>"
                + "<tbody><tr><td>Author Name</td><td>"
                + properties.getProperty("author.name")
                + "</td></tr><tr><td>Author Email</td><td>"
                + properties.getProperty("author.email")
                + "</td></tr><tr><td>Course Title</td><td>"
                + properties.getProperty("course.title")
                + "</td></tr><tr><td>Course Meet Time</td><td>"
                + properties.getProperty("course.meeting.times")
                + "</td></tr><tr><td>Instructor Name</td><td>"
                + properties.getProperty("instructor.name")
                + "</td></tr><tr><td>Project Description</td><td>"
                + properties.getProperty("first.project.description")
                + properties.getProperty("second.project.description")
                + properties.getProperty("third.project.description")
                + properties.getProperty("fourth.project.description")
                + "</td></tr></tbody></table></body></html>");
    }
}
