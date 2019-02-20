package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.Users;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username) throws DataAccessException;

}
