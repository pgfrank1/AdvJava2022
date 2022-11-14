<!DOCTYPE html>

<%@include file="head.jsp"%>

<body>
<div id="wrap">

    <%@include file="menu.jsp"%>

    <%@include file="sidebar.jsp"%>

    <div id="content">
        <h2>Lorem Ipsum <span class="post-span">- by Maurice from 09 Feb 2013</span></h2>
        <img src="images/placeholder/technics-q-c-680-280-4.jpg" class="post-img" alt="Bild" />

        <ul>
            <li>${clientServerInfo.requestComputer}</li>
            <li>${clientServerInfo.requestIPAddress}</li>
            <li>${clientServerInfo.requestHttpMethod}</li>
            <li>${clientServerInfo.requestURI}</li>
            <li>${clientServerInfo.requestURL}</li>
            <li>${clientServerInfo.requestProtocol}</li>
            <li>${clientServerInfo.serverName}</li>
            <li>${clientServerInfo.serverPort}</li>
            <li>${clientServerInfo.currentLocale}</li>
            <li>${clientServerInfo.queryString}</li>
        </ul>

    </div>

    <%@include file="footer.jsp"%>

</div>
</body>
</html>
