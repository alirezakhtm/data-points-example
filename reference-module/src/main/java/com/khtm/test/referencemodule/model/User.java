package com.khtm.test.referencemodule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Entity
@Table(name = "tbl_user", schema = "datapointdb")
@Data
@NoArgsConstructor
@ToString
@EntityListeners({AuditingEntityListener.class, UserAuditingListener.class})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
}
