package com.stockmanagement.models;

public class Products {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int categoryId;
    private int supplierId;

    // Constructor
    public Products(int id, String name, int quantity, double price, int categoryId, int supplierId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    // Método toString para imprimir el producto de forma legible
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", supplierId=" + supplierId +
                '}';
    }
}
