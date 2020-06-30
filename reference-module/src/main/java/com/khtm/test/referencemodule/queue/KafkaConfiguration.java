package com.khtm.test.referencemodule.queue;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

    @Bean
    public Map<String, Object> getKafkaProperties(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return config;
    }

    @Bean
    public ProducerFactory<String, Object> getKafkaProducerFactory(){
        return new DefaultKafkaProducerFactory<String, Object>(getKafkaProperties());
    }

    @Bean
    public KafkaTemplate<String, Object> getKafkaTemplate(){
        return new KafkaTemplate<String, Object>(getKafkaProducerFactory());
    }

}
