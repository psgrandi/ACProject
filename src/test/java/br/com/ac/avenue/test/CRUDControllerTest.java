package br.com.ac.avenue.test;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.ac.avenue.config.SpringConfig;
import br.com.ac.avenue.controller.AvenueController;

public class CRUDControllerTest extends JerseyTest {

    @Override
    protected Application configure() {
		ResourceConfig resourceConfig = new ResourceConfig();
		
		resourceConfig.property("contextConfig", new AnnotationConfigApplicationContext(SpringConfig.class));
		resourceConfig.register(AvenueController.class);
		
		return resourceConfig;
    }
    
    @Test
    public void testPath() {
        String response = target("acode/api/product/test").request().get(String.class);
        System.out.println("response = " + response);
        Assert.assertTrue("Hello".equals(response));
    }

}
