package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.ServiceMaintenanceFeedbackMap;
import kz.blackshot.auto.repository.ServiceMaintenanceFeedbackMapRepository;
import kz.blackshot.auto.service.IServiceMaintenanceFeedbackMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMaintenanceFeedbackMapImpl implements IServiceMaintenanceFeedbackMapService {

    @Autowired
    private ServiceMaintenanceFeedbackMapRepository serviceMaintenanceFeedbackMapRepository;

    @Override
    public List<ServiceMaintenanceFeedbackMap> getAllServiceMaintenanceFeedbackMap() {
        return serviceMaintenanceFeedbackMapRepository.findAll();
    }

    @Override
    public List<ServiceMaintenanceFeedbackMap> getServiceMaintenanceFeedbackMapByServiceId(Integer id) {
        return serviceMaintenanceFeedbackMapRepository.findAllByServiceMaintenanceId(id);
    }

    @Override
    public ServiceMaintenanceFeedbackMap get(Integer id) {
        return serviceMaintenanceFeedbackMapRepository.getOne(id);
    }

    @Override
    public ServiceMaintenanceFeedbackMap create(ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap) {
        return serviceMaintenanceFeedbackMapRepository.save(serviceMaintenanceFeedbackMap);
    }

    @Override
    public ServiceMaintenanceFeedbackMap update(ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap) {
        return serviceMaintenanceFeedbackMapRepository.save(serviceMaintenanceFeedbackMap);
    }

    @Override
    public void delete(Integer id) {
        ServiceMaintenanceFeedbackMap serviceMaintenanceFeedbackMap = serviceMaintenanceFeedbackMapRepository.getOne(id);
        if (serviceMaintenanceFeedbackMap != null) {
            serviceMaintenanceFeedbackMapRepository.delete(serviceMaintenanceFeedbackMap);
        }

    }
}
