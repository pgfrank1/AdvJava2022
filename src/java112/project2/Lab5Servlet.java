package java112.project2;

import java.io.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * This class displays the number of times the page was accessed, outputs the
 * current date and time, and when the page was first accessed.
 *
 * @author   pgfrank
 */
@WebServlet(
    name = "lab5Servlet", 
    urlPatterns = { "/lab5" }
)
public class Lab5Servlet extends HttpServlet {
    private int accessCounter;
    private Date firstAccessDate;

    public void init() throws ServletException {
        log("This is the init method");
        accessCounter = 0;
        firstAccessDate = new Date();
    }
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html");
                log("This is the doGet method.");
                PrintWriter  out  = response.getWriter();
                accessCounter++;
                out.println("<style>table, th, td {border: 1px solid black; "
                        + "border-collapse: collapse;}</style><table><tr>"
                        + "<td>Access Counter</td><td>Current Date</td><td>"
                        + "First Accessed Date</td></tr><tr><td>"
                        + accessCounter + "</td><td>" + getCurrentDate()
                        + "</td><td>" + firstAccessDate + "</td></tr></table>"
                        + "<p>Question 1: Upon deleting the log files, "
                        + "rerunning tcup, and using ant. The logs show no "
                        + "servlet output yet.<p/><p>Question 2: After "
                        + "accessing the lab5 servlet, the init method runs "
                        + "once and the doGet method runs right afterwards. "
                        + "Each refresh of the page only access the doGet "
                        + "method once the init method has already ran.</p>"
                        + "<p>Extra Challenge: Each time the ant command is "
                        + "called to build and deploy the servlet, it shuts "
                        + "the server down. That will call the destroy method"
                        + ".</p>");
                /**
                 * Question 1: Upon deleting the log files, rerunning tcup, and
                 * using ant. The logs show no servlet output yet.
                 * 
                 * Question 2: After accessing the lab5 servlet, the init method
                 * runs once and the doGet method runs right afterwards. Each
                 * refresh of the page only access the doGet method once the 
                 * init method has already ran.
                 */
                /*out.println("Access Counter: " + accessCounter
                        + "<br>Current Date: " + getCurrentDate()
                        + "<br>First Accessed Date: " + firstAccessDate);*/
    }

    public Date getCurrentDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    public void destroy() {
        log("Servlet Lab5 engine shutting down.");
    }
}

