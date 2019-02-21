package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.UsersRolesMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRolesMapReposity extends JpaRepository<UsersRolesMap, Integer> {
}
