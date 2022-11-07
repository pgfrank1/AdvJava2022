<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="javascript/init.js"></script>
    <title>Document</title>
</head>
<body>
    <%
        ServletContext context = request.getSession().getServletContext();
        out.print(context.getAttribute("contextKey"));
    %>
</body>
</html>