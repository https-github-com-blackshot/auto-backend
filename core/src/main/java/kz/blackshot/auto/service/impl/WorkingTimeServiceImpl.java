package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.WorkingTime;
import kz.blackshot.auto.repository.WorkingTimeRepository;
import kz.blackshot.auto.service.IWorkingTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeServiceImpl implements IWorkingTimeService{

    @Autowired
    private WorkingTimeRepository workingTimeRepository;

    @Override
    public List<WorkingTime> getAll() {
        return workingTimeRepository.findAll();
    }

    @Override
    public WorkingTime get(Integer id) {
        return workingTimeRepository.getOne(id);
    }

    @Override
    public WorkingTime create(WorkingTime workingTime) {
        return workingTimeRepository.save(workingTime);
    }

    @Override
    public WorkingTime update(WorkingTime workingTime) {
        return workingTimeRepository.save(workingTime);
    }

    @Override
    public void delete(Integer id) {
        WorkingTime workingTime = workingTimeRepository.getOne(id);
        if(workingTime!=null)
            workingTimeRepository.delete(workingTime);
    }
}
