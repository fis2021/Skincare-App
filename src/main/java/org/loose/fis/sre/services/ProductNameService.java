package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.NameAlreadyExistsException;
import org.loose.fis.sre.model.ProductName;

import java.util.ArrayList;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ProductNameService {

    private static ObjectRepository<ProductName> productNameRepository;
    private static Nitrite database;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("product-name.db").toFile())
                .openOrCreate("test", "test");

        productNameRepository = database.getRepository(ProductName.class);
    }
    public static void addName(String  name, String category,int price) throws NameAlreadyExistsException {
        checkNameDoesNotAlreadyExist(name);
        productNameRepository.insert(new ProductName(name,category,price));

    }
    public static void checkNameDoesNotAlreadyExist(String name) throws NameAlreadyExistsException {
        for (ProductName productName : productNameRepository.find()) {
            if (Objects.equals(name, productName.getName()))
                throw new NameAlreadyExistsException(name);
        }
    }

    public static ArrayList<ProductName> getAllProductNames() {
        ArrayList<ProductName> list = new ArrayList<>();
        for(ProductName productName : productNameRepository.find()) {
            list.add(productName);
        }

        return list;
    }

    public static ProductName getProductName(String name){
        for(ProductName productName : productNameRepository.find())
            if(Objects.equals(name, productName.getName()))
                return productName;
        return null;


    }


}