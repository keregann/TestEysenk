package com.keregann;

public class QuestionaireService {

    public static Questionaire findBySubject(String subject){
        Questionaire questionaire = QuestionaireDao.findBySubject(subject);
        return questionaire;
    }

    public static void insertNewQuestionaireRecord(int id, String subject, String result){
        Questionaire q = new Questionaire(subject, result);
        q.setId(id);
        QuestionaireDao.insertQuestionaireRecord(q);
    }
}
