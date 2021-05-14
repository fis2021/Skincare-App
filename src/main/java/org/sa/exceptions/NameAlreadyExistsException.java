package org.sa.exceptions;

public class NameAlreadyExistsException extends Exception {

    private String name;

    public NameAlreadyExistsException(String name) {
        super(String.format("A product with the name %s already exists!", name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}