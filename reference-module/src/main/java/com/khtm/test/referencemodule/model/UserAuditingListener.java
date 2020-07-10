package com.khtm.test.referencemodule.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.khtm.test.referencemodule.ApplicationConfiguration;
import com.khtm.test.referencemodule.ReferenceModuleApplication;
import com.khtm.test.referencemodule.queue.KafkaConfiguration;
import com.khtm.test.referencemodule.queue.KafkaHandler;
import com.khtm.test.referencemodule.repository.UserAuditingRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.transaction.Synchronization;
import javax.transaction.TransactionSynchronizationRegistry;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class UserAuditingListener {

    @Autowired
    private UserAuditingRepository repository;

//    @Autowired
//    private KafkaHandler handler;

//    @Autowired
//    private TransactionSynchronizationRegistry registry;

    //    @Transactional
    @PrePersist
    public void insertData(User user) {
        UserAuditing userAuditing = new UserAuditing(0l, user.getId(), UserState.INSERT, new GsonBuilder().create().toJson(user, User.class));
        repository.save(userAuditing);
    }

    @PostPersist
    public void afterInsertData(User user) throws JsonProcessingException {
        ApplicationContext context = new AnnotationConfigApplicationContext(KafkaConfiguration.class);
        BeanFactory beanFactory = context;
        KafkaTemplate kafkaTemplate = (KafkaTemplate) beanFactory.getBean("kafkaTemplate");
        KafkaHandler handler = new KafkaHandler(kafkaTemplate);
        handler.sendMessage("user", new GsonBuilder().create().toJson(user, User.class));

        System.out.println(">>>>>>>>>>>>>>> DONE");
//        UserAuditing userAuditing = new UserAuditing(0l, user.getId(), UserState.INSERT);
//        handler.sendMessage("user", new ObjectMapper().writeValueAsString(user));
    }

}
