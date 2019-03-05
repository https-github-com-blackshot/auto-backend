package kz.blackshot.auto.service;

import kz.blackshot.auto.model.ServiceBookContent;

import java.util.List;

public interface IServiceBookContentService {

    List<ServiceBookContent> getAllServiceBookContent();

    ServiceBookContent get(Integer id);

    ServiceBookContent create(ServiceBookContent serviceBookContent);

    ServiceBookContent update(ServiceBookContent serviceBookContent);

    void delete(Integer id);





}
