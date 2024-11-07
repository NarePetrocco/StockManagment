package com.stockmanagment.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/warehouse"; // Nombre de la base de datos
    private static final String USER = "root"; // nombre de usuario
    private static final String PASSWORD = "Nanonare1466."; // contraseña

    // Método para conectar a la base de datos
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to MySQL has been established.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    // Método para agregar un producto
    public static void addProduct(String name, int quantity, double price) {
        String query = "INSERT INTO productos (nombre, cantidad, precio) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    // Método para actualizar la cantidad de un producto
    public static void updateProductQuantity(int id, int newQuantity) {
        String query = "UPDATE productos SET cantidad = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Product quantity updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating product quantity: " + e.getMessage());
        }
    }

    // Método para consultar el estado de un producto
    public static void checkStock(int id) {
        String query = "SELECT * FROM productos WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                int quantity = rs.getInt("cantidad");
                double price = rs.getDouble("precio");
                System.out.println("Product: " + name + ", Quantity: " + quantity + ", Price: " + price);
            } else {
                System.out.println("Product not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error checking stock: " + e.getMessage());
        }
    }

    // Método para eliminar un producto
    public static void deleteProduct(int id) {
        String query = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Product deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        addProduct("Producto 1", 50, 29.99);
        updateProductQuantity(1, 45);
        checkStock(1);
        deleteProduct(1);
    }
}

