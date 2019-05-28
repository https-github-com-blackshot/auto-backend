package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.Rating;
import kz.blackshot.auto.model.ServiceMaintenance;
import kz.blackshot.auto.repository.RatingRepository;
import kz.blackshot.auto.repository.ServiceMaintenanceRepository;
import kz.blackshot.auto.service.IServiceMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMaintenanceImpl implements IServiceMaintenanceService {

    @Autowired
    private ServiceMaintenanceRepository serviceMaintenanceRepository;
    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public List<ServiceMaintenance> getAllServiceMaintenance() {
        return serviceMaintenanceRepository.findAll();
    }

    @Override
    public List<ServiceMaintenance> search(String name) {
        return serviceMaintenanceRepository.search(name);
    }

    @Override
    public ServiceMaintenance get(Integer id) {
        return serviceMaintenanceRepository.getOne(id);
    }

    @Override
    public ServiceMaintenance create(ServiceMaintenance serviceMaintenance) {
        Rating rating = new Rating();

        rating.setVeryLow(0);
        rating.setLow(0);
        rating.setMedium(0);
        rating.setHigh(0);
        rating.setVeryHigh(0);

        rating = ratingRepository.save(rating);

        serviceMaintenance.setRatingId(rating.getId());

        return serviceMaintenanceRepository.save(serviceMaintenance);
    }

    @Override
    public ServiceMaintenance update(ServiceMaintenance serviceMaintenance) {
        return serviceMaintenanceRepository.save(serviceMaintenance);
    }

    @Override
    public void delete(Integer id) {

        ServiceMaintenance serviceMaintenance = serviceMaintenanceRepository.getOne(id);
        if (serviceMaintenance != null) {
            serviceMaintenanceRepository.delete(serviceMaintenance);
        }

    }
}
