package com.khtm.test.referencemodule.model;

import com.khtm.test.referencemodule.repository.UserAuditingRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class UserAuditingListener {

    @Autowired
    private UserAuditingRepository repository;

    @Transactional
    @PrePersist
    public void insertData(User user) {
        UserAuditing userAuditing = new UserAuditing(0l, user.getId(), UserState.INSERT);
        repository.save(userAuditing);
    }

    @Transactional
    @PostPersist
    public void afterInsertData(User user){
//        UserAuditing userAuditing = new UserAuditing(0l, user.getId(), UserState.INSERT);
//        repository.save(userAuditing);
        System.out.println(user);
    }

}
