package java112.project3;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "clientServerProperties",
        urlPatterns = { "/client-server-properties" }
)

public class HttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

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

        req.setAttribute("queryParameter", "This is text from a query parameter!");
        req.setAttribute("clientServerInfo", requestData);

        String url = "/HttpRequestData.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
