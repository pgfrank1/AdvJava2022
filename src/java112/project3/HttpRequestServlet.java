package java112.project3;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * This servlet acts as the in between for HttpRequestData.java and its jsp
 * counterpart. It sets each instance variable from the HttpRequestData JavaBean
 * then adds all values to a request attribute
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 */
@WebServlet(
        name = "clientServerProperties",
        urlPatterns = { "/client-server-properties" }
)

public class HttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpRequestData requestData = new HttpRequestData();

        requestData.setRequestComputer(req.getRemoteHost());
        requestData.setRequestIPAddress(req.getLocalAddr());
        requestData.setRequestHttpMethod(req.getMethod());
        requestData.setRequestURI(req.getRequestURI());
        requestData.setRequestURL(req.getRequestURL());
        requestData.setRequestProtocol(req.getProtocol());
        requestData.setServerName(req.getServerName());
        requestData.setServerPort(String.valueOf(req.getServerPort()));
        requestData.setCurrentLocale(String.valueOf(req.getLocale()));
        requestData.setQueryString(req.getQueryString());
        requestData.setQueryParameter(req.getParameter("queryParameter"));
        requestData.setRequestHeader(req.getHeader("User-Agent"));
        req.setAttribute("clientServerInfo", requestData);

        String url = "/HttpRequestData.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
