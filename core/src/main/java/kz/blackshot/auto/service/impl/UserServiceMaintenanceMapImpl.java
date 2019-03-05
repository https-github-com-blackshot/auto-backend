package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.UserServiceMaintenanceMap;
import kz.blackshot.auto.repository.UserServiceMaintenanceMapRepository;
import kz.blackshot.auto.service.IUserServiceMaintenanceMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMaintenanceMapImpl implements IUserServiceMaintenanceMapService {

    @Autowired
    private UserServiceMaintenanceMapRepository userServiceMaintenanceMapRepository;


    @Override
    public List<UserServiceMaintenanceMap> getAllUserServiceMaintenanceMap() {
        return userServiceMaintenanceMapRepository.findAll();
    }

    @Override
    public UserServiceMaintenanceMap get(Integer id) {
        return userServiceMaintenanceMapRepository.getOne(id);
    }

    @Override
    public UserServiceMaintenanceMap create(UserServiceMaintenanceMap userServiceMaintenanceMap) {
        return userServiceMaintenanceMapRepository.save(userServiceMaintenanceMap);
    }

    @Override
    public UserServiceMaintenanceMap update(UserServiceMaintenanceMap userServiceMaintenanceMap) {
        return userServiceMaintenanceMapRepository.save(userServiceMaintenanceMap);
    }

    @Override
    public void delete(Integer id) {

        UserServiceMaintenanceMap userServiceMaintenanceMap = userServiceMaintenanceMapRepository.getOne(id);
        if (userServiceMaintenanceMap != null) {
            userServiceMaintenanceMapRepository.delete(userServiceMaintenanceMap);
        }

    }
}
