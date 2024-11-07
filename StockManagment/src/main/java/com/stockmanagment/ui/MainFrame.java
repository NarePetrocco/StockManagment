package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Stock Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear botones
        JButton addProductButton = new JButton("Agregar Producto");
        addProductButton.addActionListener(e -> openAddProductScreen());

        JButton deleteProductButton = new JButton("Eliminar Producto");
        deleteProductButton.addActionListener(e -> openDeleteProductScreen());

        JButton updateProductButton = new JButton("Actualizar Producto");
        updateProductButton.addActionListener(e -> openUpdateProductScreen());

        JButton viewProductsButton = new JButton("Visualizar Productos");
        viewProductsButton.addActionListener(e -> openViewProductsScreen());

        // Panel para el diseño
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(addProductButton);
        panel.add(deleteProductButton);
        panel.add(updateProductButton);
        panel.add(viewProductsButton);

        add(panel);
    }

    private void openAddProductScreen() {
        try {
            Connection connection = getConnection();
            AddProductScreen addProductScreen = new AddProductScreen(connection);
            addProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openDeleteProductScreen() {
        try {
            Connection connection = getConnection();
            DeleteProductScreen deleteProductScreen = new DeleteProductScreen(connection);
            deleteProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openUpdateProductScreen() {
        try {
            Connection connection = getConnection();
            UpdateProductScreen updateProductScreen = new UpdateProductScreen(connection);
            updateProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openViewProductsScreen() {
        try {
            Connection connection = getConnection();
            ViewAllProductsScreen viewProductsScreen = new ViewAllProductsScreen(connection);
            viewProductsScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        // Reemplaza con tus credenciales y URL de la base de datos
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "Nanonare1466.");
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
