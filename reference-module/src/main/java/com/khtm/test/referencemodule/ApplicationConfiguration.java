package com.khtm.test.referencemodule;

import com.khtm.test.referencemodule.queue.KafkaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Configuration
public class ApplicationConfiguration {

//    @Autowired
//    private KafkaHandler kafkaHandler;

//    @Bean("kafkaHandler2")
//    public KafkaHandler getKafkaHandler(){
//        return kafkaHandler;
//    }

    @Bean("myName")
    public String getName(){
        return "alireza";
    }
}
