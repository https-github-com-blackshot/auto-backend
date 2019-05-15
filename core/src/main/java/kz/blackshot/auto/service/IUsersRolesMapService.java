package kz.blackshot.auto.service;

import kz.blackshot.auto.model.UsersRolesMap;

import java.util.List;

public interface IUsersRolesMapService {

    List<UsersRolesMap> getAll();
    UsersRolesMap get(Integer id);
    UsersRolesMap getByUserId(Integer userId);
    UsersRolesMap create(UsersRolesMap usersRolesMap);
    UsersRolesMap update(UsersRolesMap usersRolesMap);
    void delete(Integer id);

}
