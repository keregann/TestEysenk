package com.keregann;

public class Item {
    private int itemId;
    private String question;
    private int consideredValue;
    private int answeredValue;

    public Item() {
    }

    public Item(int itemId, String question, int consideredValue) {
        this.itemId = itemId;
        this.question = question;
        this.consideredValue = consideredValue;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getConsideredValue() {
        return consideredValue;
    }

    public void setConsideredValue(int consideredValue) {
        this.consideredValue = consideredValue;
    }

    public int getAnsweredValue() {
        return answeredValue;
    }

    public void setAnsweredValue(int answeredValue) {
        this.answeredValue = answeredValue;
    }

    @Override
    public String toString() {
        return "Id : " + this.itemId + ", Question : " + this.question + ", consideredValue : " + this.consideredValue;
    }

}
