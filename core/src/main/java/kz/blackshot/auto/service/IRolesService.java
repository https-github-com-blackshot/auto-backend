package kz.blackshot.auto.service;

import kz.blackshot.auto.model.Roles;

import java.util.List;

public interface IRolesService {

    List<Roles> getRoles();

    Roles get(Integer id);

    Roles create(Roles role);

    Roles update(Roles role);

    void delete(Integer id);

}
