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

        <ul>
            <li>Request Computer: ${clientServerInfo.requestComputer}</li>
            <li>Request IP Address: ${clientServerInfo.requestIPAddress}</li>
            <li>Request HTTP Method: ${clientServerInfo.requestHttpMethod}</li>
            <li>Request URI: ${clientServerInfo.requestURI}</li>
            <li>Request URL: ${clientServerInfo.requestURL}</li>
            <li>Request Protocol: ${clientServerInfo.requestProtocol}</li>
            <li>Web Server Name: ${clientServerInfo.serverName}</li>
            <li>Web Server Port: ${clientServerInfo.serverPort}</li>
            <li>Web Server Current Locale: ${clientServerInfo.currentLocale}</li>
            <li>Query String: ${clientServerInfo.queryString}</li>
            <li>Query Parameter: ${clientServerInfo.queryParameter}</li>
            <li>Request Header: ${clientServerInfo.requestHeader} </li>
        </ul>

    </div>

    <c:import url="footer.jsp" />

</div>
</body>
</html>
