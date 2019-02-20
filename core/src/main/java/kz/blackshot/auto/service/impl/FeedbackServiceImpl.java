package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.Feedback;
import kz.blackshot.auto.repository.FeedbackRepository;
import kz.blackshot.auto.repository.UserRepository;
import kz.blackshot.auto.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbackByFio(String fio) {
        return feedbackRepository.findByFio(fio);
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback update(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void delete(Integer id) {
        Feedback feedback = feedbackRepository.findById(id).get();
        if(feedback != null)
            feedbackRepository.delete(feedback);

    }
}
