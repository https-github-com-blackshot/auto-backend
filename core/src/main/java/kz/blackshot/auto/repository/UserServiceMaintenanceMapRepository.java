package kz.blackshot.auto.repository;

import kz.blackshot.auto.model.UserServiceMaintenanceMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceMaintenanceMapRepository extends JpaRepository<UserServiceMaintenanceMap, Integer> {
}
