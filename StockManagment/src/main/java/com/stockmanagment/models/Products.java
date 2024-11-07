
package com.stockmanagment.models;


public class Products {
    private int id;
    private String name;
    private int quantity; // Cambiado de stock a quantity
    private double price;
    private int categoryId; // Nueva propiedad
    private int supplierId; // Nueva propiedad

    public Products(int id, String name, int quantity, double price, int categoryId, int supplierId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity; // Cambiado de stock a quantity
        this.price = price;
        this.categoryId = categoryId; // Nueva propiedad
        this.supplierId = supplierId; // Nueva propiedad
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity; // Cambiado de stock a quantity
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId; // Nueva propiedad
    }

    public int getSupplierId() {
        return supplierId; // Nueva propiedad
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) { // Cambiado de stock a quantity
        this.quantity = quantity; // Cambiado de stock a quantity
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategoryId(int categoryId) { // Nueva propiedad
        this.categoryId = categoryId; // Nueva propiedad
    }

    public void setSupplierId(int supplierId) { // Nueva propiedad
        this.supplierId = supplierId; // Nueva propiedad
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price +
                ", categoryId=" + categoryId + ", supplierId=" + supplierId + "]";
    }
}

