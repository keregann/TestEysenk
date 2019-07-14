package com.keregann;

import java.util.Map;

public class Questionaire {
    private int id;
    private String subject;
    private String result;

    //******************
    private Map<Integer, Item> items;


    public Questionaire(String subject, String result) {
        this.subject = subject;
        this.result = result;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " id : " + getId()  + ", subject : " + this.getSubject() + ", result : " + this.getResult();
    }
}
