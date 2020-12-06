package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.User;

import java.util.List;


public interface UserService {

    User createUser(User user);

    List<User> getUsers();

}