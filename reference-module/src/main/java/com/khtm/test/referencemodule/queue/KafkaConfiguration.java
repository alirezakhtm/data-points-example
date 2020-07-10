package com.khtm.test.referencemodule.queue;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Configuration
@EnableKafka
public class KafkaConfiguration {

    //#region configuration for kafka producer
    @Bean
    public Map<String, Object> getKafkaProperties(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return config;
    }

    @Bean
    public ProducerFactory<String, Object> getKafkaProducerFactory(){
        return new DefaultKafkaProducerFactory<String, Object>(getKafkaProperties());
    }

    @Bean("kafkaTemplate")
    public KafkaTemplate<String, Object> getKafkaTemplate(){
        return new KafkaTemplate<String, Object>(getKafkaProducerFactory());
    }

    // #endregion

    //#region configuration for kafka consumer
    @Bean
    public Map<String, Object> getConsumerConfiguration(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "user_group_id");
        return config;
    }

    @Bean
    public ConsumerFactory<String, Object> getKafkaConsumer(){
        return new DefaultKafkaConsumerFactory<>(this.getConsumerConfiguration());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> getKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(this.getKafkaConsumer());
        return factory;
    }
    //#endregion

}
