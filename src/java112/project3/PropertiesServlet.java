package java112.project3;
import java112.utilities.PropertiesLoader;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
    name = "project3PropertiesServlet",
    urlPatterns = {"/project3-properties"}
)

public class PropertiesServlet  extends HttpServlet implements PropertiesLoader {
    private Properties properties;

    @Override
    public void init() throws ServletException {
        properties = new Properties();
        loadProperties();
    }

    @Override
    public Properties loadProperties(String propertiesFilePath) {
        return PropertiesLoader.super.loadProperties(propertiesFilePath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
