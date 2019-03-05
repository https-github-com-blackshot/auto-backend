package kz.blackshot.auto.controller;

import kz.blackshot.auto.model.Users;
import kz.blackshot.auto.service.IRolesService;
import kz.blackshot.auto.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
public class CoreController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRolesService rolesService;

    @RequestMapping(value = "/users/read", method = RequestMethod.GET)
    public List<Users> readUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/auth/{username}/{password}")
    public Users getUserByUsernameAndPassword(@PathVariable(name = "username") String username,
                                              @PathVariable(name = "password") String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }


}
