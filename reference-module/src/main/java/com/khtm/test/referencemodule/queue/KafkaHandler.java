package com.khtm.test.referencemodule.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Service
public class KafkaHandler {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, String message){
        ListenableFuture<SendResult<String, Object>> feature = kafkaTemplate.send(topic, message);
        feature.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.err.println("[>>>] " + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                System.out.println("[>>>] " + stringObjectSendResult.toString());
            }
        });
    }

}
