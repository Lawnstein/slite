package com.alipay.APPNAME.endpoint.filter;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import org.jboss.resteasy.spi.CorsHeaders;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Set;

/**
 * 增加一个自定义 filter 能够保证 8080 端口访问 8341 的 rest 数据
 *
 * 考虑到:自定义可以访问的域名,所以将这个配置在配置文件中作为一个 bean,不用注解配置 bean
 * <p/>
 * Created by yangguanchao on 16/9/12.
 */
@Provider
public class CommonContainerResponseFilter extends CorsFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        String origin = requestContext.getHeaderString(CorsHeaders.ORIGIN);
        if (origin == null || requestContext.getProperty("cors.failure") != null) {
            // don't do anything if origin is null, its an OPTIONS request, or cors.failure is set
            return;
        }

        responseContext.getHeaders().putSingle(CorsHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        responseContext.getHeaders().putSingle(CorsHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*");
        StringBuilder allowHeaders = new StringBuilder();
        MultivaluedMap<String, String> headers = requestContext.getHeaders();
        for (String headerKey : headers.keySet()) {
            allowHeaders.append(headerKey).append(",");
        }
        responseContext.getHeaders().putSingle(CorsHeaders.ACCESS_CONTROL_ALLOW_HEADERS, allowHeaders.toString());


        if (allowCredentials) {
            responseContext.getHeaders().putSingle(CorsHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        }

        if (exposedHeaders != null) {
            responseContext.getHeaders().putSingle(CorsHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, exposedHeaders);
        }
    }

    public void setAllowedOrigins(Set<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

}