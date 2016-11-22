package com.wso2.gayanw.axis2;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private int id;
    private int total;
    private static int idCounter = 0;

    // <Product, Count> Map
    private Map<Product, Integer> products = new HashMap<>();

    private Order() {
        id = idCounter++;
        total = 0;
    }

    public static Order newInstance() {
        return new Order();
    }

    public void addProduct(Product product, int count) {
        products.put(product, products.getOrDefault(product, 0) + count);
        total += product.getValue() * count;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }
}
