package org.loose.fis.sre.model;

import java.util.Objects;

public class Question {

    private int idQ;
    private String question;

    public Question( int idQ , String question) {
        this.idQ = idQ;
        this.question=question;
    }
    public Question() {
    }

    public int  getIdQ() {
        return idQ;
    }

    public void setIdQ(int idQ) {
        this.idQ=idQ;
    }
    public String getQuestion() {
         return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question q = (Question) o;
        if(!Objects.equals(question, q.question)) return false;
        return idQ==0 ? idQ==q.idQ  : q.idQ==0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(idQ,question);
    }

    public String toString(){
        return idQ+question ;
    }
}