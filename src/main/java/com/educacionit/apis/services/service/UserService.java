package com.educacionit.apis.services.service;

import com.educacionit.apis.services.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    //Method POST a user
    public ResponseEntity<?> createUser(@RequestBody User data) throws Exception;

    //Method GET a user
    public ResponseEntity<?> getUserById(@PathVariable("id")Long id) throws Exception;

    //Method PUT a user
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User data) throws Exception;

    //Method DELETE a user
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) throws Exception;

    //public User changePassword(ChangePasswordForm form) throws Exception;
}
