package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Order;
import org.loose.fis.sre.model.ProductName;

import java.util.ArrayList;

import static org.dizitart.no2.objects.filters.ObjectFilters.eq;
import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OrderService {

    private static ObjectRepository<Order> orderRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders.db").toFile())
                .openOrCreate("test", "test");

        orderRepository = database.getRepository(Order.class);
    }

    public static void addOrder(String client, ProductName productName) {
        orderRepository.insert(new Order(orderRepository.size() ,client,productName));
    }

    public static ArrayList<Order> orders() {
        ArrayList<Order> list = new ArrayList<>();
        for(Order order : orderRepository.find()) {
            list.add(order);
        }
        return list;
    }

    public static ArrayList<Order> orders(String currentUser) {
        ArrayList<Order> list = new ArrayList<>();
        for(Order order : orderRepository.find()) {
            if(order.getClient().equals(currentUser))
                list.add(order);
        }
        return list;
    }

    public static void acceptOrder(Order order){
        for(Order order1 : orderRepository.find()){
            if(order.getId() == order1.getId()) {
                order.setStatus("On its way!");
                orderRepository.update(eq("id", order.getId()), order);
            }
        }
    }

    public static void rejectOrder(Order order){
        for(Order order1 : orderRepository.find()){
            if(order.getId() == order1.getId()) {
                order.setStatus("Rejected");
                orderRepository.update(eq("id", order.getId()), order);
            }
        }
    }
}