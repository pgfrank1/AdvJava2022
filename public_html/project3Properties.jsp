<!DOCTYPE html>

<%@include file="head.jsp"%>

<body>
<div id="wrap">

    <%@include file="menu.jsp"%>

    <%@include file="sidebar.jsp"%>

    <div id="content">
        <h2>Lorem Ipsum <span class="post-span">- by Maurice from 09 Feb 2013</span></h2>
        <img src="images/placeholder/technics-q-c-680-280-4.jpg" class="post-img" alt="Bild" />
        <table style="width: 50%;">
            <!-- TODO change how these properties are accessed req['']-->
            <tbody>
                <tr>
                    <th>Project 3 Author</th>
                    <td>${properties.getProperty("project.3.author")}</td>
                </tr>
                <tr>
                    <th>Author Email Address</th>
                    <td>${properties.getProperty("author.email.address")}</td>
                </tr>
                <tr>
                    <th>Course Title</th>
                    <td>${properties.getProperty("course.title")}</td>
                </tr>
                <tr>
                    <th>Course Meeting Days/Times</th>
                    <td>${properties.getProperty("course.meeting.days")}</td>
                </tr>
                <tr>
                    <th>Instructor Name</th>
                    <td>${properties.getProperty("instructor.name")}</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td>${properties.getProperty("description.line.one")}
                        ${properties.getProperty("description.line.two")}
                        ${properties.getProperty("description.line.three")}
                        ${properties.getProperty("description.line.four")}</td>
                </tr>
            </tbody>
        </table>


    <%@include file="footer.jsp"%>

</div>
</body>
</html>
