<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
    <table>
        <thead>
            <tr>
                <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee SSN</th>
                <th>Employee Department</th>
                <th>Employee Room Number</th>
                <th>Employee Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${search}">
                <tr>
                    <td>${employee["employeeId"]}</td>
                    <td>${employee["firstName"]}</td>
                    <td>${employee["lastName"]}</td>
                    <td>${employee["socialSecurityNumber"]}</td>
                    <td>${employee["department"]}</td>
                    <td>${employee["roomNumber"]}</td>
                    <td>${employee["phoneNumber"]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>