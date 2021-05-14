package org.loose.fis.sre.exceptions;

public class OfferAlreadyExistsException extends Exception {

    private String nameOffer;

    public OfferAlreadyExistsException(String nameOffer) {
        super(String.format("An offer with the name %s already exists!", nameOffer));
        this.nameOffer = nameOffer;
    }

    public String getNameOffer() {
        return nameOffer;
    }
}