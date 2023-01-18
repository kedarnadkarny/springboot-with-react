package com.bettercoder.springbootwithreact.controllers;

import com.bettercoder.springbootwithreact.entities.User;
import com.bettercoder.springbootwithreact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET,value="/api/test")
    public ResponseEntity<String> getName() {
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/api/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value="/api/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = new User();
        createUser.setName(user.getName());
        User finalUser = userRepository.save(createUser);
        return new ResponseEntity(finalUser, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value="/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PATCH, value="/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            existingUser.get().setName(user.getName());
            User updatedUser = userRepository.save(existingUser.get());
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/api/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
