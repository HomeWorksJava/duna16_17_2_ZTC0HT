package com.ticktacktoe.game;

import com.ticktacktoe.game.web.GameController;
import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("rest")
public class RESTApplication extends Application{

    public RESTApplication() {
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080/ticktacktoe");
        beanConfig.setBasePath("/rest");
        beanConfig.setResourcePackage("com.ticktacktoe.game.web");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
        
    }
    
   
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(com.ticktacktoe.game.web.GameController.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
    
}
