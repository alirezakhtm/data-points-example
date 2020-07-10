package com.khtm.test.referencemodule.queue;

import com.google.gson.GsonBuilder;
import com.khtm.test.referencemodule.model.User;
import com.khtm.test.referencemodule.model.UserAuditing;
import com.khtm.test.referencemodule.model.UserState;
import com.khtm.test.referencemodule.repository.UserAuditingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Service
public class UserAuditKafkaListener {

    @Autowired
    private UserAuditingRepository repository;

    @KafkaListener(topics = "user", groupId = "user_group_id")
    public void kafkaListener(@Payload String data){
        try{
            User user = new GsonBuilder().create().fromJson(data, User.class);
            if(user != null){
                UserAuditing userAuditing =
                        new UserAuditing(0L, user.getId(), UserState.INSERT, data);
                repository.save(userAuditing);
                System.out.println(">>>>>>>> Data inserted to user audit table. > " + data);
            }
        }catch (Exception e){
            System.out.println(">>>>> Data is not true: " + data);
        }
    }

}
