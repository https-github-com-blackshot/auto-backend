package kz.blackshot.auto.controller;

import javafx.concurrent.Service;
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

    /*****************************************************************************************
     * Users API
     *
     */

    @GetMapping("/auth/{username}/{password}")
    public Users getUserByUsernameAndPassword(@PathVariable(name = "username") String username,
                                              @PathVariable(name = "password") String password){
        return userService.getUserByUsernameAndPassword(username, password);
    }

    @RequestMapping(value = "/users/read", method = RequestMethod.GET)
    public List<Users> readUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users/create")
    public Users createUser(@Valid @RequestBody Users user){
        UsersRolesMap usersRolesMap = new UsersRolesMap();

        usersRolesMap.setRoleId(2);
        usersRolesMap.setUserId(user.getId());
        usersRolesMapService.create(usersRolesMap);

        return userService.create(user);
    }

    @PutMapping("/users/update")
    public Users updateUser(@Valid @RequestBody Users user){
        return userService.update(user);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id){
        userService.delete(id);
    }

    @GetMapping("/users/byId/{id}")
    public Users getUserById(@PathVariable(name="id") Integer id) {return userService.getById(id);}
    /*****************************************************************************************
     * Roles API
     *
     */

    @RequestMapping(value = "/roles/read", method = RequestMethod.GET)
    public List<Roles> readRoles(){
        return rolesService.getRoles();
    }

    @RequestMapping(value = "/rolesService/readOne/{id}", method = RequestMethod.GET)
    public Roles readOneRole(@PathVariable(name = "id") Integer id) {
        return rolesService.get(id);
    }

    @PostMapping("/roles/create")
    public Roles createRole(@Valid @RequestBody Roles role){
        return rolesService.create(role);
    }

    @PutMapping("/roles/update")
    public Roles updateRole(@Valid @RequestBody Roles role){
        return rolesService.update(role);
    }

    @DeleteMapping("/roles/delete/{id}")
    public void deleteRole(@PathVariable(name = "id") Integer id){
        rolesService.delete(id);
    }

    /*****************************************************************************************
     * ServiceBook API
     *
     */

    @RequestMapping(value = "/serviceBook/read" , method = RequestMethod.GET)
    public List<ServiceBook> readServiceBook(){

        System.out.println(serviceBookService.getAllServiceBook());
        return  serviceBookService.getAllServiceBook();

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


    /*****************************************************************************************
     * ServiceBookContent API
     *
     */

    @RequestMapping(value = "/serviceBookMaintenance/read", method = RequestMethod.GET)
    public List<ServiceBookContent> readServiceBookContent() {
        return serviceBookContentService.getAllServiceBookContent();
    }

    /*****************************************************************************************
     * ServiceMaintenance API
     *
     */

    @RequestMapping(value = "/serviceMaintenance/read", method = RequestMethod.GET)
    public List<ServiceMaintenance> readServiceMaintenance() {
        return serviceMaintenanceService.getAllServiceMaintenance();
    }

    @GetMapping(value = "/serviceMaintenance/{id}")
    public ServiceMaintenance readServiceMaintenanceById(@PathVariable(name = "id") Integer id) {
        return serviceMaintenanceService.get(id);
    }

    @PostMapping(value = "/serviceMaintenance/create")
    public ServiceMaintenance createServiceMaintenance(@Valid @RequestBody ServiceMaintenance serviceMaintenance){
        return serviceMaintenanceService.create(serviceMaintenance);
    }

    @PutMapping(value = "/serviceMaintenance/update")
    public ServiceMaintenance updateServiceMaintenance(@Valid @RequestBody ServiceMaintenance serviceMaintenance){
        return serviceMaintenanceService.update(serviceMaintenance);
    }

    @DeleteMapping(value = "/serviceMaintenance/delete/{id}")
    public void deleteServiceMaintenance(@PathVariable(name = "id") Integer id){
        serviceMaintenanceService.delete(id);
    }

    /*****************************************************************************************
     * ServiceMaintenanceFeedbackMap API
     *
     */

    @RequestMapping(value = "/serviceMaintenanceFeedbackMap", method = RequestMethod.GET)
    public List<ServiceMaintenanceFeedbackMap> readServiceMaintenanceFeedbackMap() {
        return serviceMaintenanceFeedbackMapService.getAllServiceMaintenanceFeedbackMap();
    }
    @GetMapping(value = "/serviceMaintenanceFeedbackMap/{service_id}")
    public List<ServiceMaintenanceFeedbackMap> getFeedbackByServiceId(@PathVariable(name = "service_id") Integer service_id){
        return serviceMaintenanceFeedbackMapService.getServiceMaintenanceFeedbackMapByServiceId(service_id);
    }
    @PostMapping("/serviceMaintenanceFeedbackMap/create")
    public ServiceMaintenanceFeedbackMap createServiceMaintenanceFeedbackMap(@Valid @RequestBody ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap){
        return serviceMaintenanceFeedbackMapService.create(serviceMaintenanceFeedbackMap);
    }


    /*****************************************************************************************
     * UserServiceMaintenanceMap API
     *
     */

    @RequestMapping(value = "/userServiceMaintenanceMap", method = RequestMethod.GET)
    public List<UserServiceMaintenanceMap> readUserServiceMaintenanceMap() {
        return userServiceMaintenanceMapService.getAllUserServiceMaintenanceMap();
    }

    /*****************************************************************************************
     * UserServiceMaintenanceMap API
     *
     */

    @RequestMapping(value = "/feedbackService/read", method = RequestMethod.GET)
    public List<Feedback> readFeedback() {
        return feedbackService.getAllFeedback();
    }

    @RequestMapping(value = "/feedbackService/readOne/{id}", method = RequestMethod.GET)
    public Feedback readOneFeedback(@PathVariable(name = "id") Integer id) {
        return feedbackService.getFeedbackById(id);
    }
    @PostMapping("/feedback/create")
    public Feedback createFeedback(@Valid @RequestBody Feedback feedback){
        return feedbackService.create(feedback);
    }

    /*****************************************************************************************
     * Rating API
     *
     */

    @RequestMapping(value = "/rating/read", method = RequestMethod.GET)
    public List<Rating> readRating() {
        return ratingService.getAllRating();
    }

    @RequestMapping(value = "/rating/readOne/{id}", method = RequestMethod.GET)
    public Rating readOneRating(@PathVariable(name = "id") Integer id) {
        return ratingService.getRating(id);
    }

    @PostMapping("/rating/create")
    public Rating createRating(@Valid @RequestBody Rating rating){
        return ratingService.createRating(rating);
    }

    @PutMapping("/rating/update")
    public Rating updateRating(@Valid @RequestBody Rating rating){
        return ratingService.updateRating(rating);
    }

    @DeleteMapping("/rating/delete/{id}")
    public void deleteRating(@PathVariable(name = "id") Integer id){
        ratingService.deleteRating(id);
    }

    /*****************************************************************************************
     * WorkingTime API
     *
     */

    @RequestMapping(value = "/workingTimeService/read", method = RequestMethod.GET)
    public List<WorkingTime> readWorkingTime() {
        return workingTimeService.getAll();
    }

    @RequestMapping(value = "/workingTimeService/readOne/{id}", method = RequestMethod.GET)
    public WorkingTime readOneWorkingTime(@PathVariable(name = "id") Integer id) {
        return workingTimeService.get(id);
    }

    /*****************************************************************************************
     * UsersRolesMap API
     *
     */

    @RequestMapping(value = "/usersRolesMapService/read", method = RequestMethod.GET)
    public List<UsersRolesMap> readUsersRolesMap() {
        return usersRolesMapService.getAll() ;
    }

    @RequestMapping(value = "/usersRolesMapService/readOne/{id}", method = RequestMethod.GET)
    public UsersRolesMap readOneUsersRolesMap(@PathVariable(name = "id") Integer id) {
        return usersRolesMapService.get(id);
    }

    @RequestMapping(value = "/users/role/map/byUserId/{userId}", method = RequestMethod.GET)
    public UsersRolesMap readUserRoleMapByUserId(@PathVariable(name = "userId") Integer userId) {
        return usersRolesMapService.getByUserId(userId);
    }


}
