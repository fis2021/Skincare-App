package org.loose.fis.sre.exceptions;

public class AnswerAlreadyExistsException extends Exception {

    private int idQ;

    public AnswerAlreadyExistsException(int idQ) {
        super(String.format("A question with the id %d already exists!", idQ));
        this.idQ = idQ;
    }

    public int getIdQ() {
        return idQ;
    }
}