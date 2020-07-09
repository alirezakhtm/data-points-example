package com.khtm.test.common;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.PrePersist;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
public class AuditEntityBase<ENTITY ,REPOSITORY extends JpaRepository<ENTITY, Long>> {

    @PrePersist
    public void insert(ENTITY entity){

    }

}
