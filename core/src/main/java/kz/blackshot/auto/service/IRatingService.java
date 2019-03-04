package kz.blackshot.auto.service;

import kz.blackshot.auto.model.Rating;

import java.util.List;

public interface IRatingService {

    List<Rating> getAllRating();
    Rating getRating(Integer id);
    Rating updateRating(Rating rating);
    Rating saveRating(Rating rating);
    Rating createRating(Rating rating);
    void deleteRating(Integer id);
}
