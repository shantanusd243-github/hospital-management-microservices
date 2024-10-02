package com.microservice.gateway.interceptor.wrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private String modifiedUrl;

    public CustomHttpServletRequestWrapper(HttpServletRequest request, String modifiedUrl) {
        super(request);
        this.modifiedUrl = modifiedUrl;
    }

    @Override
    public StringBuffer getRequestURL() {
        return new StringBuffer(modifiedUrl);
    }

    @Override
    public String getRequestURI() {
        // Return the URI part only, without the base URL
        return modifiedUrl.substring(modifiedUrl.indexOf("/", modifiedUrl.indexOf("//") + 2));
    }

    // Override other methods if necessary, e.g., getServletPath(), getContextPath(), etc.
}
