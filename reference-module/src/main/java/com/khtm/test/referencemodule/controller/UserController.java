package com.khtm.test.referencemodule.controller;

import com.khtm.test.referencemodule.model.User;
import com.khtm.test.referencemodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alireza khatami doost [alireza.khtm@gmail.com]
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/add-user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

}
