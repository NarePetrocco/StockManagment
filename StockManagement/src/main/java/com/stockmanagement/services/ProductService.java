package com.stockmanagement.services;

import com.stockmanagement.models.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private final Connection connection;

    public ProductService(Connection connection) {
        this.connection = connection;
    }

    // Método para agregar un producto
    public void addProduct(String name, int quantity, double price, int categoryId, int supplierId) throws SQLException {
        String query = "INSERT INTO products (name, quantity, price, category_id, supplier_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setDouble(3, price);
            statement.setInt(4, categoryId);
            statement.setInt(5, supplierId);
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los productos
    public List<Products> getAllProducts() throws SQLException {
        String query = "SELECT * FROM products";
        List<Products> productsList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int categoryId = resultSet.getInt("category_id");
                int supplierId = resultSet.getInt("supplier_id");

                Products product = new Products(id, name, quantity, price, categoryId, supplierId);
                productsList.add(product);
            }
        }
        return productsList;
    }

    // Método para eliminar un producto
    public void deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            statement.executeUpdate();
        }
    }
    public void registerEntry() {
        // lógica para registrar la entrada del producto
    }

    // Método para actualizar un producto
    public void updateProduct(int id, String name, int quantity, double price, int categoryId, int supplierId) throws SQLException {
        String query = "UPDATE products SET name = ?, quantity = ?, price = ?, category_id = ?, supplier_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, quantity);
            statement.setDouble(3, price);
            statement.setInt(4, categoryId);
            statement.setInt(5, supplierId);
            statement.setInt(6, id);
            statement.executeUpdate();
        }
    }
}
