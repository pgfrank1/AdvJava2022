package java112.project3;

import javax.servlet.http.HttpServlet;

/**
 * This JavaBean contains all the needed variables for the Webapp part of
 * Project 3. This would be considered the Model part of MVC.
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 */
public class HttpRequestData {

    /**
     * The request computer name
     * */
    private String requestComputer;
    /**
     * The request computer IP Address
     * */
    private String requestIPAddress;
    /**
     * The request computer HTTP method GET or POST
     * */
    private String requestHttpMethod;
    /**
     * The request URI to access the page
     * */
    private String requestURI;
    /**
     * The request full URL to access the page
     * */
    private StringBuffer requestURL;
    /**
     * The request protocol
     * */
    private String requestProtocol;
    /**
     * The web server name
     * */
    private String serverName;
    /**
     * The web server port
     * */
    private String serverPort;
    /**
     * The current locale for the webserver
     * */
    private String currentLocale;
    /**
     * The query string after the request URI
     * */
    private String queryString;
    /**
     * The query parameter name
     * */
    private String queryParameter;
    /**
     * The request header information
     * */
    private String requestHeader;


    /**
     * Gets request computer.
     *
     * @return the request computer
     */
    public String getRequestComputer() { return requestComputer; }

    /**
     * Gets request ip address.
     *
     * @return the request ip address
     */
    public String getRequestIPAddress() { return requestIPAddress; }

    /**
     * Gets request http method.
     *
     * @return the request http method
     */
    public String getRequestHttpMethod() {return requestHttpMethod;}

    /**
     * Gets request uri.
     *
     * @return the request uri
     */
    public String getRequestURI() { return requestURI; }

    /**
     * Gets request url.
     *
     * @return the request url
     */
    public StringBuffer getRequestURL() { return requestURL; }

    /**
     * Gets request protocol.
     *
     * @return the request protocol
     */
    public String getRequestProtocol() { return requestProtocol; }

    /**
     * Gets server name.
     *
     * @return the server name
     */
    public String getServerName() { return serverName; }

    /**
     * Gets server port.
     *
     * @return the server port
     */
    public String getServerPort() { return serverPort; }

    /**
     * Gets current locale.
     *
     * @return the current locale
     */
    public String getCurrentLocale() { return currentLocale; }

    /**
     * Gets query string.
     *
     * @return the query string
     */
    public String getQueryString() { return queryString; }

    /**
     * Gets query parameter.
     *
     * @return the query parameter
     */
    public String getQueryParameter() { return queryParameter; }

    /**
     * Gets request header.
     *
     * @return the request header
     */
    public String getRequestHeader() { return requestHeader; }

    /**
     * Sets request computer.
     *
     * @param requestComputer the request computer
     */
    public void setRequestComputer(String requestComputer) {
        this.requestComputer = requestComputer;
    }

    /**
     * Sets request ip address.
     *
     * @param requestIPAddress the request ip address
     */
    public void setRequestIPAddress(String requestIPAddress) {
        this.requestIPAddress = requestIPAddress;
    }

    /**
     * Sets request http method.
     *
     * @param requestHttpMethod the request http method
     */
    public void setRequestHttpMethod(String requestHttpMethod) {
        this.requestHttpMethod = requestHttpMethod;
    }

    /**
     * Sets request uri.
     *
     * @param requestURI the request uri
     */
    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    /**
     * Sets request url.
     *
     * @param requestURL the request url
     */
    public void setRequestURL(StringBuffer requestURL) {
        this.requestURL = requestURL;
    }

    /**
     * Sets request protocol.
     *
     * @param requestProtocol the request protocol
     */
    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }

    /**
     * Sets server name.
     *
     * @param serverName the server name
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * Sets server port.
     *
     * @param serverPort the server port
     */
    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    /**
     * Sets current locale.
     *
     * @param currentLocale the current locale
     */
    public void setCurrentLocale(String currentLocale) {
        this.currentLocale = currentLocale;
    }

    /**
     * Sets query string.
     *
     * @param queryString the query string
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * Sets query parameter.
     *
     * @param queryParameter the query parameter
     */
    public void setQueryParameter(String queryParameter) {
        this.queryParameter = queryParameter;
    }

    /**
     * Sets request header.
     *
     * @param requestHeader the request header
     */
    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }
}
