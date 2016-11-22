package com.wso2.gayanw.axis2;

public class Product {

    private int id;
    private String name;
    private float value;

    private static int idCounter = 0;

    private Product() {
        id = idCounter++;
    }

    public static Product newInstance() {
        return new Product();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }
}
