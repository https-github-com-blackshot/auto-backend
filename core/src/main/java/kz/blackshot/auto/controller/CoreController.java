package kz.blackshot.auto.controller;

import kz.blackshot.auto.model.*;
import kz.blackshot.auto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/core")
public class CoreController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private IRolesService rolesService;

    @Autowired
    private IRatingService ratingService;

    @Autowired
    private IUsersRolesMapService usersRolesMapService;

    @Autowired
    private IWorkingTimeService workingTimeService;

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


    @RequestMapping(value = "/roles/read", method = RequestMethod.GET)
    public List<Roles> readRoles(){
        return rolesService.getRoles();
    }

    @PostMapping("/users/create")
    public Users createUser(@Valid @RequestBody Users user){
        return userService.create(user);
    }

    @PutMapping("/users/update")
    public Users updateUser(@Valid @RequestBody Users user){
        return userService.update(user);
    }

    @PostMapping("/roles/create")
    public Roles createRole(@Valid @RequestBody Roles role){
        return rolesService.create(role);
    }

    @PutMapping("/roles/update")
    public Roles updateRole(@Valid @RequestBody Roles role){
        return rolesService.update(role);
    }


    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id){
        userService.delete(id);
    }


    @DeleteMapping("/roles/delete/{id}")
    public void deleteRole(@PathVariable(name = "id") Integer id){
        rolesService.delete(id);
    }

    @GetMapping("/auth/{username}/{password}")
    public Users getUserByUsernameAndPassword(@PathVariable(name = "username") String username,
                                              @PathVariable(name = "password") String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }

    @RequestMapping(value = "/serviceBook/read" , method = RequestMethod.GET)
    public List<ServiceBook> readServiceBook(){ return  serviceBookService.getAllServiceBook();
    }

    @PostMapping("/serviceBook/create")
    public ServiceBook createServiceBook(@Valid @RequestBody ServiceBook serviceBook){
        return serviceBookService.create(serviceBook);
    }

    @PutMapping("/serviceBook/update")
    public ServiceBook updateServiceBook(@Valid @RequestBody ServiceBook serviceBook){
        return serviceBookService.update(serviceBook);
    }

    @DeleteMapping("/serviceBook/delete")
    public void deleteServiceBook(@Valid @RequestBody ServiceBook serviceBook){
        serviceBookService.delete(serviceBook.getId());
    }

    @RequestMapping(value = "/serviceBookMaintenance/read", method = RequestMethod.GET)
    public List<ServiceBookContent> readServiceBookContent() {
        return serviceBookContentService.getAllServiceBookContent();
    }

    @RequestMapping(value = "/serviceMaintenance", method = RequestMethod.GET)
    public List<ServiceMaintenance> readServiceMaintenance() {
        return serviceMaintenanceService.getAllServiceMaintenance();
    }

    @RequestMapping(value = "/serviceMaintenanceFeedbackMap", method = RequestMethod.GET)
    public List<ServiceMaintenanceFeedbackMap> readServiceMaintenanceFeedbackMap() {
        return serviceMaintenanceFeedbackMapService.getAllServiceMaintenanceFeedbackMap();
    }

    @RequestMapping(value = "/userServiceMaintenanceMap", method = RequestMethod.GET)
    public List<UserServiceMaintenanceMap> readUserServiceMaintenanceMap() {
        return userServiceMaintenanceMapService.getAllUserServiceMaintenanceMap();
    }

    @RequestMapping(value = "/feedbackService/read", method = RequestMethod.GET)
    public List<Feedback> readFeedback() {
        return feedbackService.getAllFeedback();
    }

    @RequestMapping(value = "/feedbackService/readOne/{id}", method = RequestMethod.GET)
    public Feedback readOneFeedback(@PathVariable(name = "id") Integer id) {
        return feedbackService.getFeedbackById(id);
    }


    @RequestMapping(value = "/ratingService/read", method = RequestMethod.GET)
    public List<Rating> readRating() {
        return ratingService.getAllRating();
    }

    @RequestMapping(value = "/ratingService/readOne/{id}", method = RequestMethod.GET)
    public Rating readOneRating(@PathVariable(name = "id") Integer id) {
        return ratingService.getRating(id);
    }


    @RequestMapping(value = "/rolesService/readOne/{id}", method = RequestMethod.GET)
    public Roles readOneRoles(@PathVariable(name = "id") Integer id) {
        return rolesService.get(id);
    }


    @RequestMapping(value = "/workingTimeService/read", method = RequestMethod.GET)
    public List<WorkingTime> readWorkingTime() {
        return workingTimeService.getAll();
    }

    @RequestMapping(value = "/workingTimeService/readOne/{id}", method = RequestMethod.GET)
    public WorkingTime readOneWorkingTime(@PathVariable(name = "id") Integer id) {
        return workingTimeService.get(id);
    }

    @RequestMapping(value = "/usersRolesMapService/read", method = RequestMethod.GET)
    public List<UsersRolesMap> readUsersRolesMap() {
        return usersRolesMapService.getAll() ;
    }

    @RequestMapping(value = "/usersRolesMapService/readOne/{id}", method = RequestMethod.GET)
    public UsersRolesMap readOneUsersRolesMapService(@PathVariable(name = "id") Integer id) {
        return usersRolesMapService.get(id);
    }




}
