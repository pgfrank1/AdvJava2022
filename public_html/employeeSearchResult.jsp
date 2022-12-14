<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp" />

<body>
<div id="wrap">

    <c:import url="menu.jsp" />

    <c:import url="sidebar.jsp" />

    <c:choose>
        <c:when test="${!search.isEmployeeFound()}" >
            <h1>No employee was found</h1>
        </c:when>
        <c:otherwise>
            <c:import url="employeeSearchResultTable.jsp" />
        </c:otherwise>

    </c:choose>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
