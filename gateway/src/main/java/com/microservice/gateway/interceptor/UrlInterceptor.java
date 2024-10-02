package com.microservice.gateway.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import com.microservice.gateway.interceptor.wrapper.CustomHttpServletRequestWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UrlInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Create a StringBuilder to manipulate the request URL
        /*StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());

        int baseURLEndIndex = requestURL.indexOf("/", requestURL.indexOf("//") + 2); // Find the index of the first slash after "http://"

        if (baseURLEndIndex != -1) {
            // Find the index of the next slash, which marks the end of the first path segment (service name)
            int serviceNameEndIndex = requestURL.indexOf("/", baseURLEndIndex + 1);

            if (serviceNameEndIndex != -1) {
                // Remove the first path segment (service name) from the URL
                requestURL.delete(baseURLEndIndex, serviceNameEndIndex);
            }
        }

        // Wrap the request with the modified URL
        CustomHttpServletRequestWrapper wrappedRequest = new CustomHttpServletRequestWrapper(request, requestURL.toString());

        // Continue the filter chain with the wrapped request*/
        return true;
	}

}
