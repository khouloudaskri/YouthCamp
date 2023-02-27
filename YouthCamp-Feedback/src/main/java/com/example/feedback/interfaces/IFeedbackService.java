package com.example.feedback.interfaces;

import com.example.feedback.entities.Feedback;

import java.util.List;
import java.util.Map;

public interface IFeedbackService {
    public Feedback addFeedback(Feedback f);
    public Feedback updateFeedback(Feedback f);
    public List<Feedback> retrieveAllFeedbacks();
    public  void removeFeedback(Integer idFeedback);
    public void assignFeedbackToUser(Integer idFeedback,Integer IdUser);
    public String filter (String input);
    public  int countOccurrences(String text, String word);
    public  Map<String, Integer> countWords(String text, String[] words);
    public  int countWords2(String text, String[] words) ;





    }
