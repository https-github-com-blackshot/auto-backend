package kz.blackshot.auto.service;

import kz.blackshot.auto.model.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Integer id);
    Feedback create(Feedback feedback);
    Feedback update(Feedback feedback);
    void delete(Integer id);
}
