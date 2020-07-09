package com.khtm.test.referencemodule.repository;

import com.khtm.test.referencemodule.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
