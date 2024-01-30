/*
@author :: Abhishek Gaurav
*/

package com.mockito.service;

import com.mockito.model.User;
import com.mockito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User addUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        List<User> users = (List<User>) repository.findAll();
        System.out.println("Getting data from DB : " + users);
        return users;
    }

    public List<User> getUserbyAddress(String address) {
        return repository.findByAddress(address);
    }

    public void deleteUser(User user) {
        repository.delete(user);
    }
}
