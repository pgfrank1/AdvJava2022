<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp" />

<body>
<main>
    <div id="wrap">

        <c:import url="menu.jsp" />

        <c:import url="sidebar.jsp" />

        <h3>${project4AddMessage}</h3>
        <c:remove var="project4AddMessage" />
        <br>

        <c:import url="employeeSearchResultTable.jsp" />

        <c:import url="footer.jsp" />

    </div>
</main>
</body>
</html>
