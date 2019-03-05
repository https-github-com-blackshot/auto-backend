package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.ServiceBook;
import kz.blackshot.auto.repository.ServiceBookRepository;
import kz.blackshot.auto.service.IServiceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceBookImpl implements IServiceBookService {

    @Autowired
    private ServiceBookRepository serviceBookRepository;


    @Override
    public List<ServiceBook> getAllServiceBook() {
        return serviceBookRepository.findAll();
    }

    @Override
    public ServiceBook get(Integer id) {
        return serviceBookRepository.getOne(id);
    }

    @Override
    public ServiceBook create(ServiceBook serviceBook) {
        return serviceBookRepository.save(serviceBook);
    }

    @Override
    public ServiceBook update(ServiceBook serviceBook) {
        return serviceBookRepository.save(serviceBook);
    }

    @Override
    public void delete(Integer id) {

        ServiceBook serviceBook = serviceBookRepository.getOne(id);
        if (serviceBook != null) {
            serviceBookRepository.delete(serviceBook);
        }
    }


}
