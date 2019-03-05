package kz.blackshot.auto.controller;

import kz.blackshot.auto.model.ServiceBook;
import kz.blackshot.auto.model.ServiceBookContent;
import kz.blackshot.auto.model.Users;
import kz.blackshot.auto.service.IRolesService;
import kz.blackshot.auto.service.IServiceBookContentService;
import kz.blackshot.auto.service.IServiceBookService;
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

    @Autowired
    private IServiceBookService serviceBookService;

    @Autowired
    private IServiceBookContentService serviceBookContentService;



    @RequestMapping(value = "/users/read", method = RequestMethod.GET)
    public List<Users> readUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/auth/{username}/{password}")
    public Users getUserByUsernameAndPassword(@PathVariable(name = "username") String username,
                                              @PathVariable(name = "password") String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }

    @RequestMapping(value = "/serviceBook" , method = RequestMethod.GET)
    public List<ServiceBook> readServiceBook(){ return  serviceBookService.getAllServiceBook();
    }

    @RequestMapping(value = "/serviceBookMaintenance", method = RequestMethod.GET)
    public List<ServiceBookContent> readServiceBookContent() { return serviceBookContentService.getAllServiceBookContent();

    }


}
