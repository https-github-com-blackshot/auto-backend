package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.UsersRolesMap;
import kz.blackshot.auto.repository.UsersRolesMapRepository;
import kz.blackshot.auto.service.IUsersRolesMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersRolesMapServiceImpl implements IUsersRolesMapService{

    @Autowired
    private UsersRolesMapRepository usersRolesMapRepository;

    @Override
    public List<UsersRolesMap> getAll() {
        return usersRolesMapRepository.findAll();
    }

    @Override
    public UsersRolesMap get(Integer id) {
        return usersRolesMapRepository.getOne(id);
    }

    @Override
    public UsersRolesMap getByUserId(Integer userId) {
        return usersRolesMapRepository.findByUserId(userId);
    }

    @Override
    public UsersRolesMap create(UsersRolesMap usersRolesMap) {
        return usersRolesMapRepository.save(usersRolesMap);
    }

    @Override
    public UsersRolesMap update(UsersRolesMap usersRolesMap) {
        return usersRolesMapRepository.save(usersRolesMap);
    }

    @Override
    public void delete(Integer id) {
        UsersRolesMap usersRolesMap = usersRolesMapRepository.getOne(id);
        if(usersRolesMap != null)
            usersRolesMapRepository.delete(usersRolesMap);
    }
}
