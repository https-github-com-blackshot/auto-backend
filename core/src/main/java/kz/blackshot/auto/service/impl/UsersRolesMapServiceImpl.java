package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.UsersRolesMap;
import kz.blackshot.auto.repository.UsersRolesMapReposity;
import kz.blackshot.auto.service.IUsersRolesMapService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersRolesMapServiceImpl implements IUsersRolesMapService{

    @Autowired
    private UsersRolesMapReposity usersRolesMapReposity;

    @Override
    public List<UsersRolesMap> getAll() {
        return usersRolesMapReposity.findAll();
    }

    @Override
    public UsersRolesMap get(Integer id) {
        return usersRolesMapReposity.getOne(id);
    }

    @Override
    public UsersRolesMap create(UsersRolesMap usersRolesMap) {
        return usersRolesMapReposity.save(usersRolesMap);
    }

    @Override
    public UsersRolesMap update(UsersRolesMap usersRolesMap) {
        return usersRolesMapReposity.save(usersRolesMap);
    }

    @Override
    public void delete(Integer id) {
        UsersRolesMap usersRolesMap = usersRolesMapReposity.getOne(id);
        if(usersRolesMap != null)
            usersRolesMapReposity.delete(usersRolesMap);
    }
}
