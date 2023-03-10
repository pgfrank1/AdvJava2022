<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<c:import url="head.jsp" />

<body>
<div id="wrap">

    <c:import url="menu.jsp" />

    <c:import url="sidebar.jsp" />

    <div id="content">
        <h2>Lorem Ipsum <span class="post-span">- by Maurice from 09 Feb 2013</span></h2>
        <img src="images/placeholder/technics-q-c-680-280-4.jpg" class="post-img" alt="Bild" />
        <table style="width: 80%; margin: 0 auto;">
            <tbody>
                <tr>
                    <th style="width: 33%;">Project 3 Author</th>
                    <td>${properties["project3.author"]}</td>
                </tr>
                <tr>
                    <th>Author Email Address</th>
                    <td>${properties["author.email.address"]}</td>
                </tr>
                <tr>
                    <th>Course Title</th>
                    <td>${properties["course.title"]}</td>
                </tr>
                <tr>
                    <th>Course Meeting Days/Times</th>
                    <td>${properties["course.meeting.days"]}</td>
                </tr>
                <tr>
                    <th>Instructor Name</th>
                    <td>${properties["instructor.name"]}</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>
                        ${properties["description.line.one"]}
                        ${properties["description.line.two"]}
                        ${properties["description.line.three"]}
                        ${properties["description.line.four"]}
                    </td>
                </tr>
            </tbody>
        </table>


        <c:import url="footer.jsp" />

</div>
</body>
</html>
