package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.Roles;
import kz.blackshot.auto.repository.RolesRepository;
import kz.blackshot.auto.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService implements IRolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public List<Roles> read() {
        return rolesRepository.findAll();
    }

    @Override
    public Roles get(Integer id) {
        return rolesRepository.getOne(id);
    }

    @Override
    public Roles create(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public Roles update(Roles role) {
        return rolesRepository.save(role);
    }

    @Override
    public void delete(Integer id) {
        Roles dbRole = rolesRepository.getOne(id);
        rolesRepository.delete(dbRole);
    }
}
