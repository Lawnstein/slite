package com.alipay.slite2.endpoint.filter;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.util.Set;


/**
 * 增加一个自定义 filter 能够保证 8080 端口访问 8341 的 rest 数据
 *
 * 考虑到:自定义可以访问的域名,所以将这个配置在配置文件中作为一个 bean,不用注解配置 bean
 * <p/>
 * Created by yangguanchao on 16/9/12.
 */
@Provider
@PreMatching
public class CommonContainerResponseFilter extends CorsFilter {

    public void setAllowedOrigins(Set<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

}
