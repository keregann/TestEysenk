package com.keregann;

import java.util.List;
import java.util.Map;

public class QuestionaireService {

    public static Questionaire findBySubject(String subject){
        Questionaire questionaire = QuestionaireDao.findBySubject(subject);
        return questionaire;
    }

    public static void insertQuestionaireRecord(Questionaire questionaire){
        QuestionaireDao.insertQuestionaireRecord(questionaire);
    }

    public static Questionaire createNewQuestionareRecord(int id, String subject, String result, Map<Integer, Item> items){
        Questionaire q = new Questionaire(subject, result);
        q.setId(id);
        q.setItems(items);
       return q;
    }
}
