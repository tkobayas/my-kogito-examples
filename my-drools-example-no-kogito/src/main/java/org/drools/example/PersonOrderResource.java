package org.drools.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Path("/person-order")
public class PersonOrderResource {

    @GET
    @Path("/person/{value1a}/{value2a}/{value3a}/{value4a}/{value5a}/order/{value1b}/{value2b}/{value3b}/{value4b}/{value5b}")
    @Produces(MediaType.TEXT_PLAIN)
    public String personOrder( 
              @PathParam("value1a") int value1a, @PathParam("value2a") int value2a, @PathParam("value3a") int value3a, @PathParam("value4a") int value4a, @PathParam("value5a") int value5a ,
              @PathParam("value1b") int value1b, @PathParam("value2b") int value2b, @PathParam("value3b") int value3b, @PathParam("value4b") int value4b, @PathParam("value5b") int value5b 
            ) {
        
        long start = System.currentTimeMillis();
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("personOrderKS");

        Result result = new Result();
        kSession.insert(result);

        Person person = new Person(value1a, value2a, value3a, value4a, value5a);
        Order order = new Order(value1b, value2b, value3b, value4b, value5b);
        kSession.insert(person);
        kSession.insert(order);

        kSession.fireAllRules();
        
        System.out.println("personOrder() : elapsed time = " + (System.currentTimeMillis() - start) + "ms");

        return result.toString();
    }
}