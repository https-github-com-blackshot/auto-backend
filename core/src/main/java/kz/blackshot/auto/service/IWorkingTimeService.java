package kz.blackshot.auto.service;

import kz.blackshot.auto.model.WorkingTime;

import java.util.List;

public interface IWorkingTimeService {

    List<WorkingTime> getAll();
    WorkingTime get(Integer id);
    WorkingTime create(WorkingTime workingTime);
    WorkingTime update(WorkingTime workingTime);
    void delete(Integer id);

}
