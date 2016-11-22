package com.wso2.gayanw.axis2;

import org.apache.axis2.AxisFault;

import java.util.HashMap;
import java.util.Map;

public class OrderProcessingService {

    //  Map <OrderId, Order>
    private Map<Integer, Order> orders = new HashMap<>();

    // Map <ProductId, Product>
    private Map<Integer, Product> products = new HashMap<>();

    public void createOrder() {
        Order order = Order.newInstance();
        orders.put(order.getId(), order);
    }

    public void createProduct(String name, float value) {
        Product product = Product.newInstance();
        product.setName(name);
        product.setValue(value);
        products.put(product.getId(), product);
    }

    public void addProductToOrder(int orderId, int productId, int count) throws AxisFault {
        Order order = getOrderById(orderId);
        Product product = getProductById(productId);
        order.addProduct(product, count);
    }

    public Order getOrderById(int id) throws AxisFault {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        throw ServiceFault.newNoSuchOrderFault();
    }

    public Product getProductById(int id) throws AxisFault {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        throw ServiceFault.newNoSuchProductFault();
    }

    public int getLastOrderId() {
        return orders.size() - 1;
    }

    public int getLastProductId() {
        return products.size() - 1;
    }
}
