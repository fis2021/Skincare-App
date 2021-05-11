package org.loose.fis.sre.model;

import java.util.Objects;

public class ProductName {
    private String name;
    private int price;

    public ProductName(String name, int price ) {
        this.name = name;
        this.price=price;
    }

    public ProductName() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductName productName = (ProductName) o;
        if(!Objects.equals(name, productName.name)) return false;
        return price==0 ? price== productName.price : productName.price==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String toString(){
        return name;
    }
}