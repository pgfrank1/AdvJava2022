package java112.project2;

import java112.utilities.PropertiesLoader;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This servlet opens the Project 2 servlet properties file and outputs the
 * information to the webpage
 * 
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
@WebServlet(
    name = "project2PropertiesServlet", 
    urlPatterns = { "/project2Properties" }
)
public class Project2PropertiesServlet extends HttpServlet implements PropertiesLoader{
    /**
     * Holds the key value pairs from the properties file
     */
    private Properties properties;

    /**
     * Initializes the properties variable with the project2.properties file
     */
    public void init() throws ServletException {
        properties = new Properties(loadProperties("/project2.properties"));
    }

    /**
     * This method outputs the HTML text with the property file's values
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>"
        + "<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
        + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
        + "<title>Project 2 Properties Servlet</title></head><body><style>table, td, th {border: 1px solid black;}</style><table>"
        + "<thead><tr><th>Property</th><th>Value</th></tr></thead><tbody>"
        + "<tr><td>Author Name</td><td>" + properties.getProperty("author.name") + "</td></tr>"
        + "<tr><td>Author Email</td><td>" + properties.getProperty("author.email") + "</td></tr>"
        + "<tr><td>Course Title</td><td>" + properties.getProperty("course.title") + "</td></tr>"
        + "<tr><td>Course Meeting Times</td><td>" + properties.getProperty("course.meeting.times") + "</td></tr>"
        + "<tr><td>Instructor Name</td><td>" + properties.getProperty("instructor.name") + "</td></tr>"
        + "<tr><td>Author Name</td><td>" + properties.getProperty("first.project.description") + properties.getProperty("second.project.description") + properties.getProperty("third.project.description") + properties.getProperty("fourth.project.description") + "</td></tr>"
        + "</tbody></table></body></html>");
    }


}
