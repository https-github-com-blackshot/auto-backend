package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.Users;
import kz.blackshot.auto.model.UsersRolesMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRolesMapRepository extends JpaRepository<UsersRolesMap, Integer> {

    UsersRolesMap findByUserId(Integer userId);

}
