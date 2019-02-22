package kz.blackshot.auto.controller;

import kz.blackshot.auto.model.Users;
import kz.blackshot.auto.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CoreController {

    @Autowired
    private IUserService userService;

    @GetMapping("/auth/{username}/{password}")
    public Users getUserByUsernameAndPassword(@PathVariable(name = "username") String username,
                                              @PathVariable(name = "password") String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }

}
