package kz.blackshot.auto.service;

import kz.blackshot.auto.model.Users;

import java.util.List;

public interface IUserService {

    List<Users> getAllUsers();
    Users getById(Integer id);
    Users getByUsername(String username);
    Users create(Users user);
    Users update(Users user);
    void delete(Integer id);

}
