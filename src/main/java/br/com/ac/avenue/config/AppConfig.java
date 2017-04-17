package br.com.ac.avenue.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

@ApplicationPath("/acode")
public class AppConfig extends ResourceConfig {
    
    public AppConfig() {
        packages("br.com.ac.avenue.controller");
        register(RequestContextFilter.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }
}
