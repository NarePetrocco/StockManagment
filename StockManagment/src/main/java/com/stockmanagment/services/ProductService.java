package com.stockmanagment.services;

import com.stockmanagment.models.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductService {
    private Connection connection;

    // Constructor que inicializa la conexión a la base de datos
    public ProductService(Connection connection) {
        this.connection = connection;
    }

    public void addProduct(String name, int quantity, double price, int categoryId, int supplierId) throws SQLException {
        String query = "INSERT INTO Products (name, quantity, price, category_id, supplier_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setDouble(3, price);
            statement.setInt(4, categoryId);
            statement.setInt(5, supplierId);
            statement.executeUpdate();
        }
    }


    public void updateProduct(int productId, String name, int quantity, double price, int categoryId, int supplierId) throws SQLException {
        String query = "UPDATE Products SET name = ?, quantity = ?, price = ?, category_id = ?, supplier_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setDouble(3, price);
            statement.setInt(4, categoryId);
            statement.setInt(5, supplierId);
            statement.setInt(6, productId);
            statement.executeUpdate();
        }
    }


    // Método para eliminar un producto de la tabla Products usando su ID
    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }

    public List<Products> getAllProducts() throws SQLException {
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int categoryId = resultSet.getInt("category_id");
                int supplierId = resultSet.getInt("supplier_id");
                products.add(new Products(id, name, quantity, price, categoryId, supplierId));
            }
        }
        return products;
    }



    // Método para obtener un producto específico por su ID
    public Products getProductById(int productId) throws SQLException {
        String query = "SELECT * FROM Products WHERE ID = ?"; // Asegúrate de que el nombre de la columna sea correcto
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("ID"); // Asegúrate de que el nombre de la columna sea correcto
                    String name = resultSet.getString("NAME");
                    int quantity = resultSet.getInt("QUANTITY"); // Cambiado de stock a quantity
                    double price = resultSet.getDouble("PRICE");
                    int categoryId = resultSet.getInt("CATEGORY_ID"); // Nueva propiedad
                    int supplierId = resultSet.getInt("SUPPLIER_ID"); // Nueva propiedad
                    return new Products(id, name, quantity, price, categoryId, supplierId);
                }
            }
        }
        return null; // Retorna null si no se encuentra el producto
    }

}

