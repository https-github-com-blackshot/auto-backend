package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.Users;
import kz.blackshot.auto.repository.UserRepository;
import kz.blackshot.auto.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Users getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Users getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Users create(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users update(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        Users user = userRepository.findById(id).get();
        if(user != null)
            userRepository.delete(user);
    }

}
