package com.khtm.test.referencemodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Entity
@Table(name = "tbl_user_audit", schema = "datapointdb")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "STATE")
    private UserState state;
}
