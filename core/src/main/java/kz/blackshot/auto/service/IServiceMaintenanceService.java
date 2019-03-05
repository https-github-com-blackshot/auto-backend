package kz.blackshot.auto.service;

import kz.blackshot.auto.model.ServiceMaintenance;

import java.util.List;

public interface IServiceMaintenanceService {

    List<ServiceMaintenance> getAllServiceMaintenance();

    ServiceMaintenance get(Integer id);

    ServiceMaintenance create(ServiceMaintenance serviceMaintenance);

    ServiceMaintenance update(ServiceMaintenance serviceMaintenance);

    void delete (Integer id);

}
