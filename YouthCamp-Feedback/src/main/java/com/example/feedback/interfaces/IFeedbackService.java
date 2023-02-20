package com.example.feedback.interfaces;

import com.example.feedback.entities.Feedback;

import java.util.List;

public interface IFeedbackService {
    public Feedback addFeedback(Feedback f);
    public Feedback updateFeedback(Feedback f);
    public List<Feedback> retrieveAllFeedbacks();
    public  void removeFeedback(Integer idFeedback);


}
