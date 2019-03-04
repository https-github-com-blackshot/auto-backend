package kz.blackshot.auto.service.impl;

import kz.blackshot.auto.model.Rating;
import kz.blackshot.auto.repository.RatingRepository;
import kz.blackshot.auto.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements IRatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRating(Integer id) {
        return ratingRepository.getOne(id);
    }

    @Override
    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void deleteRating(Integer id) {
        Rating rating = ratingRepository.getOne(id);
        if(rating!=null){
            ratingRepository.delete(rating);
        }
    }
}
