package kz.blackshot.auto.repository;


import kz.blackshot.auto.model.Feedback;
import kz.blackshot.auto.model.ServiceMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMaintenanceRepository extends JpaRepository<ServiceMaintenance, Integer> {
}
