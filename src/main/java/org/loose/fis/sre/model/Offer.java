package org.loose.fis.sre.model;

import java.util.Objects;

public class Offer {

    private String nameOffer;
    private int points;
    public Offer(String nameOffer,int points) {
        this.points = points;
        this.nameOffer=nameOffer;
    }

    public String getNameOffer() {
        return nameOffer;
    }

    public void setNameOffer(String nameOffer) {
        this.nameOffer = nameOffer;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points=points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        if(!Objects.equals(nameOffer, offer.nameOffer)) return false;
        return points==0 ? points==offer.points  : offer.points==0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOffer,points);
    }

    public String toString(){
        return nameOffer+points;
    }
}