<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <c:forEach var="strings" items="${listOfStrings}" >
        <tr>${strings}</tr>
    </c:forEach>
</table>
