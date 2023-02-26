package com.example.feedback.services;

import com.example.feedback.entities.Feedback;
import com.example.feedback.entities.User;
import com.example.feedback.interfaces.IFeedbackService;
import com.example.feedback.repositories.FeedbackRepository;
import com.example.feedback.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class FeedbackService implements IFeedbackService {
    FeedbackRepository feedbackRepository;
    UserRepository userRepository;
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
    @Transactional
    public void assignFeedbackToUser(Integer idFeedback,Integer IdUser){
        Feedback F=feedbackRepository.findById(idFeedback).orElse(null);
        User U=userRepository.findById(IdUser).orElse(null);
        F.setUser(U);
        feedbackRepository.save(F);

    }
}
