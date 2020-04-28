package org.example.alerts;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

/**
 * A bean consuming data from the "alertData" in memory stream and processing it.
 * The result is pushed to the "alerts" Kafka topic
 */
@ApplicationScoped
public class FooSubscriber {

    @Inject
    @Channel("alertData")
    Emitter<String> emitter;

    public void send(String message) {
        emitter.send(message);
    }

    @Incoming("alertData")
    @Outgoing("alerts")
    public String process(String foo) {
        System.out.println("FooSubscriber : Processing " + foo);
        return "foo " + foo;
    }
}
