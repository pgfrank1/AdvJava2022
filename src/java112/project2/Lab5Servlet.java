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
    /**
     * Stores the amount of times the site has been accessed
     */
    private int accessCounter;
    /**
     * Stores when the site was first accessed
     */
    private Date firstAccessDate;

    /**
     * This method initializes the needed variables upon deploying the
     * application.
     * 
     * @exception ServletException if there is a Servlet failure
     */
    public void init() throws ServletException {
        log("This is the init method");
        accessCounter = 0;
        firstAccessDate = new Date();
    }
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpServletRequest object
     *@param  response              the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Sets the response type
                response.setContentType("text/html");
                log("This is the doGet method.");
                // Create a printwriter to output html onto the page
                PrintWriter  out  = response.getWriter();
                // Count each time the servlet has been accessed
                accessCounter++;
                // Prints the table with the required data
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
    }

    /**
     * Returns the current date that the user accessed the servlet
     * 
     * @return currentDate the current time the user has accessed the servlet
     */
    public Date getCurrentDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    /**
     * Closes the servlet variables and outputs a line of text to the log file
     * saying so.
     */
    public void destroy() {
        log("Servlet Lab5 engine shutting down.");
    }
}

