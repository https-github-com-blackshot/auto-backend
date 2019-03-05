package kz.blackshot.auto.service;

import kz.blackshot.auto.model.UserServiceMaintenanceMap;

import java.util.List;

public interface IUserServiceMaintenanceMapService {

    List<UserServiceMaintenanceMap> getAllUserServiceMaintenanceMap();

    UserServiceMaintenanceMap get(Integer id);

    UserServiceMaintenanceMap create(UserServiceMaintenanceMap userServiceMaintenanceMap);

    UserServiceMaintenanceMap update(UserServiceMaintenanceMap userServiceMaintenanceMap);

    void delete (Integer id);
}
