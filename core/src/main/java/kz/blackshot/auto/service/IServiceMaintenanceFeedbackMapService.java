package kz.blackshot.auto.service;

import kz.blackshot.auto.model.ServiceMaintenanceFeedbackMap;

import java.util.List;

public interface IServiceMaintenanceFeedbackMapService {

    List<ServiceMaintenanceFeedbackMap> getAllServiceMaintenanceFeedbackMap();

    List<ServiceMaintenanceFeedbackMap> getServiceMaintenanceFeedbackMapByServiceId(Integer id);

    ServiceMaintenanceFeedbackMap get(Integer id);

    ServiceMaintenanceFeedbackMap create(ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap);

    ServiceMaintenanceFeedbackMap update(ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap);

    void delete(Integer id);

}
