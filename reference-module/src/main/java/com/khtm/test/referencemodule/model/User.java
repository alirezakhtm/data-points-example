package com.khtm.test.referencemodule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Entity
@Table(name = "tbl_user", schema = "datapointdb")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
}
