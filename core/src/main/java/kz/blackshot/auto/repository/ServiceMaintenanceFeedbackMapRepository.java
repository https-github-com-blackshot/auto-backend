package kz.blackshot.auto.repository;


import kz.blackshot.auto.model.ServiceMaintenanceFeedbackMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceMaintenanceFeedbackMapRepository extends JpaRepository<ServiceMaintenanceFeedbackMap, Integer> {
    List<ServiceMaintenanceFeedbackMap>  findAllByServiceMaintenanceId(Integer id);
}
