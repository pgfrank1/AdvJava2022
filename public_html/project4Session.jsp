<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<c:import url="head.jsp" />

<body>
<div id="wrap">

    <c:import url="menu.jsp" />

    <c:import url="sidebar.jsp" />

    <div id="content">
        <p>Session Count: ${project4SessionCounter}</p>
    </div>

    <c:import url="footer.jsp" />

    </div>
</body>
</html>
