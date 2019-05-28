package kz.blackshot.auto.repository;


import kz.blackshot.auto.model.Feedback;
import kz.blackshot.auto.model.ServiceMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMaintenanceRepository extends JpaRepository<ServiceMaintenance, Integer> {

    @Query(value = "SELECT * FROM service_maintenance WHERE name regexp ?1",
            nativeQuery = true)
    List<ServiceMaintenance> search(String name);

}
