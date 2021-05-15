package org.loose.fis.sre.model;

import java.util.Objects;

public class Answer {

    private int idQ;
    private String answer;
    public Answer(int idQ ,String answer) {
        this.idQ = idQ;
        this.answer=answer;
    }
    public Answer(){
    }

    public int  getIdQ() {
        return idQ;
    }

    public void setIdQ(int idQ) {
        this.idQ=idQ;
    }
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer a = (Answer) o;
        if(!Objects.equals(answer, a.answer)) return false;
        return idQ==0 ? idQ==a.idQ  : a.idQ==0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(idQ,answer);
    }

    public String toString(){
        return idQ+answer;
    }
}