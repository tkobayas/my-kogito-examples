package org.example.alerts;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaClient {

    private static KafkaClient instance;

    private KafkaProducer<String, String> producer;

    private KafkaClient() {} // Singleton

    static {
        System.out.println("Intializing KafkaClient...");
        try {
            instance = new KafkaClient();
            Properties properties = new Properties();
            properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            instance.producer = new KafkaProducer<>(properties, new StringSerializer(), new StringSerializer());
        } catch (Exception e) {
            throw new RuntimeException("Failed in creating instance", e);
        }
    }

    public static KafkaClient getInstance() {
        return instance;
    }

    public void process(String message) {
        System.out.println("KafkaClient : process " + message);
        producer.send(new ProducerRecord<String, String>("alerts", message));
    }
}
