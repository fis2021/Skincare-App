package org.loose.fis.sre.model;

import java.util.Objects;

public class Order {
    private long id;
    private String client;
    private ProductName productName;

    private int price;
    private String status;

    public Order(){}

    public Order(long id, String client,ProductName productName) {
        this.id = id;
        this.client=client;
        this.productName = productName;

        this.price=productName.getPrice();
        this.status="Waiting";
    }

    public long getId(){return id;}

    public void setId(long id){ this.id = id;}

    public String getClient(){
        return client;
    }

    public void setClient(String client){
        this.client=client;
    }

    public ProductName getProductType() {
        return productName;
    }

    public void setProductName(ProductName productName) {
        this.productName = productName;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(client,order.client) && price == order.price && Objects.equals(productName, order.productName)  && Objects.equals(status,order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client,productName, price,status);
    }
}