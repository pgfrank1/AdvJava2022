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
        <br>

        <form id="addEmployee" method="post" action="./EmployeeAddActionServlet">
            <label for="first_name">First Name</label>
            <input type="text" name="first_name" id="first_name">
            <br><br>
            <label for="last_name">Last Name</label>
            <input type="text" name="last_name" id="last_name">
            <br><br>
            <label for="ssn">Social Security Number</label>
            <input type="text" name="ssn" id="ssn">
            <br><br>
            <label for="dept">Department</label>
            <input type="text" name="dept" id="dept">
            <br><br>
            <label for="room">Room Number</label>
            <input type="text" name="room" id="room">
            <br><br>
            <label for="phone">Phone Number</label>
            <input type="text" name="phone" id="phone">
            <br><br>
            <div>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </div>
        </form>

        <c:import url="footer.jsp" />

    </div>
</main>
</body>
</html>
