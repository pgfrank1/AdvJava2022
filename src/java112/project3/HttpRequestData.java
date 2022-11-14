package java112.project3;

import javax.servlet.http.HttpServlet;

public class HttpRequestData {

    private String requestComputer;
    private String requestIPAddress;
    private String requestHttpMethod;
    private String requestURI;
    private StringBuffer requestURL;
    private String requestProtocol;
    private String serverName;
    private String serverPort;
    private String currentLocale;
    private String queryString;
    //private



    public String getRequestComputer() { return requestComputer; }
    public String getRequestIPAddress() { return requestIPAddress; }
    public String getRequestHttpMethod() {return requestHttpMethod;}
    public String getRequestURI() { return requestURI; }
    public StringBuffer getRequestURL() { return requestURL; }
    public String getRequestProtocol() { return requestProtocol; }
    public String getServerName() { return serverName; }
    public String getServerPort() { return serverPort; }
    public String getCurrentLocale() { return currentLocale; }
    public String getQueryString() { return queryString; }

    public void setRequestComputer(String requestComputer) {this.requestComputer = requestComputer;}
    public void setRequestIPAddress(String requestIPAddress) {this.requestIPAddress = requestIPAddress;}
    public void setRequestHttpMethod(String requestHttpMethod) {this.requestHttpMethod = requestHttpMethod;}
    public void setRequestURI(String requestURI) {this.requestURI = requestURI;}
    public void setRequestURL(StringBuffer requestURL) {this.requestURL = requestURL;}
    public void setRequestProtocol(String requestProtocol) {this.requestProtocol = requestProtocol;}
    public void setServerName(String serverName) {this.serverName = serverName;}
    public void setServerPort(String serverPort) {this.serverPort = serverPort;}
    public void setCurrentLocale(String currentLocale) {this.currentLocale = currentLocale;}
    public void setQueryString(String queryString) {this.queryString = queryString;}
}
