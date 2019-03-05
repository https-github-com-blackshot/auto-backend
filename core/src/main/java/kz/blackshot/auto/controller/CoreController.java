package kz.blackshot.auto.controller;

import kz.blackshot.auto.model.*;
import kz.blackshot.auto.service.*;
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

    @Autowired
    private IServiceMaintenanceService serviceMaintenanceService;

    @Autowired
    private IServiceMaintenanceFeedbackMapService serviceMaintenanceFeedbackMapService;

    @Autowired
    private IUserServiceMaintenanceMapService userServiceMaintenanceMapService;



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

    @RequestMapping(value = "/serviceMaintenance", method = RequestMethod.GET)
    public List<ServiceMaintenance> readServiceMaintenance() { return  serviceMaintenanceService.getAllServiceMaintenance();
    }

    @RequestMapping(value = "/serviceMaintenanceFeedbackMap", method = RequestMethod.GET)
    public List<ServiceMaintenanceFeedbackMap> readServiceMaintenanceFeedbackMap() { return serviceMaintenanceFeedbackMapService.getAllServiceMaintenanceFeedbackMap();
    }

    @RequestMapping(value = "/userServiceMaintenanceMap", method = RequestMethod.GET)
    public List<UserServiceMaintenanceMap> readUserServiceMaintenanceMap() { return userServiceMaintenanceMapService.getAllUserServiceMaintenanceMap();}




}
