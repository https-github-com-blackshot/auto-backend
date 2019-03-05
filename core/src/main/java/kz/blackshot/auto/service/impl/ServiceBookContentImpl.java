package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.ServiceBookContent;
import kz.blackshot.auto.repository.ServiceBookContentRepository;
import kz.blackshot.auto.service.IServiceBookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceBookContentImpl implements IServiceBookContentService {

    @Autowired
    private ServiceBookContentRepository serviceBookContentRepository;


    @Override
    public List<ServiceBookContent> getAllServiceBookContent() {
        return serviceBookContentRepository.findAll();
    }

    @Override
    public ServiceBookContent get(Integer id) {
        return serviceBookContentRepository.getOne(id);
    }

    @Override
    public ServiceBookContent create(ServiceBookContent serviceBookContent) {
        return serviceBookContentRepository.save(serviceBookContent);
    }

    @Override
    public ServiceBookContent update(ServiceBookContent serviceBookContent) {
        return serviceBookContentRepository.save(serviceBookContent);
    }

    @Override
    public void delete(Integer id) {
        ServiceBookContent serviceBookContent = serviceBookContentRepository.getOne(id);
        if (serviceBookContent != null) {
            serviceBookContentRepository.delete(serviceBookContent);
        }
    }
}
