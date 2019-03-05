package kz.blackshot.auto.service;

import kz.blackshot.auto.model.ServiceBook;

import java.util.List;

public interface IServiceBookService {

    List<ServiceBook> getAllServiceBook();

    ServiceBook get(Integer id);

    ServiceBook create(ServiceBook serviceBook);

    ServiceBook update(ServiceBook serviceBook);

    void delete(Integer id);
}
