<!DOCTYPE html>

<%@include file="head.jsp"%>

<body>
<div id="wrap">

    <%@include file="menu.jsp"%>

    <%@include file="sidebar.jsp"%>

    <div id="content">
        <h2>Lorem Ipsum <span class="post-span">- by Maurice from 09 Feb 2013</span></h2>
        <img src="images/placeholder/technics-q-c-680-280-4.jpg" class="post-img" alt="Bild" />
        <table style="width: 80%; margin: 0 auto;">
            <tbody>
                <tr>
                    <th style="width: 33%;">Project 3 Author</th>
                    <td>${properties.get("project3.author")}</td>
                </tr>
                <tr>
                    <th>Author Email Address</th>
                    <td>${properties.get("author.email.address")}</td>
                </tr>
                <tr>
                    <th>Course Title</th>
                    <td>${properties.get("course.title")}</td>
                </tr>
                <tr>
                    <th>Course Meeting Days/Times</th>
                    <td>${properties.get("course.meeting.days")}</td>
                </tr>
                <tr>
                    <th>Instructor Name</th>
                    <td>${properties.get("instructor.name")}</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>
                        ${properties.get("description.line.one")}
                        ${properties.get("description.line.two")}
                        ${properties.get("description.line.three")}
                        ${properties.get("description.line.four")}
                    </td>
                </tr>
            </tbody>
        </table>


    <%@include file="footer.jsp"%>

</div>
</body>
</html>
