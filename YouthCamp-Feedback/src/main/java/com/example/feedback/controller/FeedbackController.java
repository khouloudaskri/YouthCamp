package com.example.feedback.controller;

import com.example.feedback.entities.Feedback;
import com.example.feedback.interfaces.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Feedback")

public class FeedbackController {
@Autowired
    IFeedbackService feedbackService;

    @PostMapping("/AddFeedback")
    public Feedback addFeedback(@RequestBody Feedback F) {
        Feedback feedback = feedbackService.addFeedback(F);
        return feedback;
    }

    @GetMapping("/retrieve-all-feedbacks")
    public List<Feedback> getFeedbacks() {
        List<Feedback> listFeedbacks = feedbackService.retrieveAllFeedbacks();
        return listFeedbacks;
    }

    @PutMapping("/update-feedback")
    public Feedback updateFeedback(@RequestBody Feedback c) {
        Feedback feedback = feedbackService.updateFeedback(c);
        return feedback;
    }
    @DeleteMapping("/remove-feedback/{feedback-id}")
    public void removeFeedback(@PathVariable("feedback-id") Integer idFeedback) {

        feedbackService.removeFeedback(idFeedback);
    }
}
