<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<c:import url="head.jsp" />

<body>
<div id="wrap">

    <c:import url="menu.jsp" />

    <c:import url="sidebar.jsp" />

    <div id="content">
        <form method="post" action="java112/employeeSearchServlet">
            <h3><label for="search_term">Search Term:</label></h3>
            <input name="search_term" id="search_term" type="text">
            <br><br>
            <h3>Search Type:</h3>
            <label for="search_for_id">ID</label>
            <input type="radio" name="search_type" id="search_for_id" value="id">
            <br>
            <label for="search_for_first_name">First Name</label>
            <input type="radio" name="search_type" id="search_for_first_name" value="first_name">
            <br>
            <label for="search_for_last_name">Last Name</label>
            <input type="radio" name="search_type" id="search_for_last_name" value="last_name">
            <br><br>
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </form>
    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
