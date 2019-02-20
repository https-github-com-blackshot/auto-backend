package kz.blackshot.auto.service;

import kz.blackshot.auto.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getAllFeedback();
    List<Feedback> getFeedbackByFio(String fio);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback);
    void delete(Integer id);
}
