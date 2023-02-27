package com.example.feedback.services;

import com.example.feedback.entities.Feedback;
import com.example.feedback.entities.User;
import com.example.feedback.interfaces.IFeedbackService;
import com.example.feedback.repositories.FeedbackRepository;
import com.example.feedback.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@Service
@Slf4j

public class FeedbackService implements IFeedbackService {
    FeedbackRepository feedbackRepository;
    UserRepository userRepository;
    public Feedback addFeedback(Feedback f) {
String d;

d=filter(f.getDescription());
f.setDescription(d);
        Map<String, Integer> wordCounts =countWords(f.getDescription(), words);
int x=countWords2(f.getDescription(), words);
log.info(wordCounts.toString());
log.info(String.valueOf(x));

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


        private static final String[] BAD_WORDS = {"khra", "ham", "kalb"};

        public String filter (String input){
            String filteredInput = input;
            for (String badWord : BAD_WORDS) {
                filteredInput = filteredInput.replaceAll(badWord, "****");
            }
            return filteredInput;
        }

    private static final String[] words = {"important", "urgent", "grave"};
    public  Map<String, Integer> countWords(String text, String[] words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            int count = countOccurrences(text, word);
            wordCounts.put(word, count);
        }
        return wordCounts;
    }
    public  int countWords2(String text, String[] words) {

        int count = 0;
        for (String word : words) {
            count = countOccurrences(text, word);
        count++;
        }
        return count;
    }

    public  int countOccurrences(String text, String word) {
            int count = 0;
            int index = 0;
            while ((index = text.indexOf(word, index)) != -1) {
                count++;
                index += word.length();
            }
            return count;}
    }
   /* public void badwords(String text) {
        String[] badwords = new String[2];
        badwords[0] = "khra";
        badwords[0] = "ham";
        for(int i=0;i<text.length();i++){
            for (int j=0;j<2;j++){
                for(int k=0;k<badwords[j].length();k++){
                    if(text[i])

                }
            }
        }

    }*/

