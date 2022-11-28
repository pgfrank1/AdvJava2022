package java112.project4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "JSTLLab1Servlet", value = "/JSTLLab1Servlet")

public class JSTLLab1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> stringList = new ArrayList<>();

        stringList.add("Hello ");
        stringList.add("there ");
        stringList.add("Patrick. ");
        stringList.add("This ");
        stringList.add("is ");
        stringList.add("from ");
        stringList.add("the ");
        stringList.add("servlet.");

        request.setAttribute("listOfStrings", stringList);

        String url = "/jstl-lab2.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
