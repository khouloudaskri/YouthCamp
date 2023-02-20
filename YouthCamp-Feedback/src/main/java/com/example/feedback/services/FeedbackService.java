package com.example.feedback.services;

import com.example.feedback.entities.Feedback;
import com.example.feedback.interfaces.IFeedbackService;
import com.example.feedback.repositories.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FeedbackService implements IFeedbackService {
    FeedbackRepository feedbackRepository;
    public Feedback addFeedback(Feedback f) {
        return feedbackRepository.save(f);
    }


    public Feedback updateFeedback(Feedback f) {
        return feedbackRepository.save(f);
    }


    public List<Feedback> retrieveAllFeedbacks() {
        return feedbackRepository.findAll();
    }


    public void removeFeedback(Integer idFeedback) {
        feedbackRepository.deleteById(idFeedback);
    }
}
