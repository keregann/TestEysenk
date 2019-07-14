package com.keregann;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

public class QuestionaireService {

    public static Questionaire findBySubject(String subject){
        Questionaire questionaire = QuestionaireDao.findBySubject(subject);
        return questionaire;
    } //end method

    public static void insertQuestionaireRecord(Questionaire questionaire){
        QuestionaireDao.insertQuestionaireRecord(questionaire);
    } //end method

    public static Questionaire createNewQuestionareRecord(String subject, String result, Map<Integer, Item> items){
        Questionaire q = new Questionaire(subject, result);
        q.setItems(items);
       return q;
    } //end method

    public static void inputQuestionaireAnswers(Questionaire questionaire){
        Iterator<Map.Entry<Integer, Item>> iterator = questionaire.getItems().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            printQuestion(questionaire.getItems().get(entry.getKey()));
            int answer = InputAnswer.inputAnswer();
            questionaire.getItems().get(entry.getKey()).setAnsweredValue(answer);
        }

    } //end method

    public static void printQuestion(Item item){
        System.out.println(item.getQuestion());
    } //end method

    public static void setQuestionaireResult(Questionaire questionaire){
        questionaire.setResult(ResultCalculation.finalRezult(questionaire));
    }

    //Test method - must to be moved in separate class or pacakge
    public static void printQuestionaireInfo(Questionaire questionaire){
        System.out.println(questionaire);
        for(Item item : questionaire.getItems().values()){
            System.out.println(item + ", answeredValue : " + item.getAnsweredValue());
        }
    } //end method

    //Method to move items answers values to an array - must to be moved
    public static int[] answerValuesArray(Questionaire questionaire){
        int[] arr = new int[questionaire.getItems().size()];

        for(Item item : questionaire.getItems().values()){ //fii atent la values ???
            arr[item.getItemId() - 1] = item.getAnsweredValue();
        }
        return arr;
    }

}
