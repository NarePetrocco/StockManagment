package com.stockmanagement.ui;

import com.stockmanagement.services.ProductService;
import com.stockmanagement.ui.RegisterEntryScreen;
import com.stockmanagement.ui.RegisterExistScreen;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Stock-Management");
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

        // Botones para las pantallas de registro
        JButton registerEntryButton = new JButton("Registrar Entrada");
        registerEntryButton.addActionListener(e -> openRegisterEntryScreen());

        JButton registerExistButton = new JButton("Registrar Salida");
        registerExistButton.addActionListener(e -> openRegisterExistScreen());

        // Panel para el diseño
        JPanel panel = new JPanel(new GridLayout(6, 1)); // Cambié el GridLayout a 6 filas para incluir los nuevos botones
        panel.add(addProductButton);
        panel.add(deleteProductButton);
        panel.add(updateProductButton);
        panel.add(viewProductsButton);
        panel.add(registerEntryButton);  // Agregar el botón de "Registrar Entrada"
        panel.add(registerExistButton);  // Agregar el botón de "Registrar Salida"

        add(panel);
    }

    private void openAddProductScreen() {
        try {
            Connection connection = getConnection();
            ProductService productService = new ProductService(connection); // Crear ProductService con conexión
            AddProductScreen addProductScreen = new AddProductScreen(productService); // Pasar ProductService al constructor
            addProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openDeleteProductScreen() {
        try {
            Connection connection = getConnection();
            ProductService productService = new ProductService(connection); // Crear ProductService con conexión
            DeleteProductScreen deleteProductScreen = new DeleteProductScreen(productService); // Pasar ProductService al constructor
            deleteProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openUpdateProductScreen() {
        try {
            Connection connection = getConnection();
            ProductService productService = new ProductService(connection); // Crear ProductService con conexión
            UpdateProductScreen updateProductScreen = new UpdateProductScreen(productService); // Pasar ProductService al constructor
            updateProductScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openViewProductsScreen() {
        try {
            Connection connection = getConnection();
            ProductService productService = new ProductService(connection); // Crear ProductService con conexión
            ViewAllProductsScreen viewProductsScreen = new ViewAllProductsScreen(productService); // Pasar ProductService al constructor
            viewProductsScreen.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error de conexión a la base de datos: " + e.getMessage());
        }
    }

    private void openRegisterEntryScreen() {
        RegisterEntryScreen registerEntryScreen = new RegisterEntryScreen();
        registerEntryScreen.setVisible(true);  // Hacer visible la pantalla de Registrar Entrada
    }

    private void openRegisterExistScreen() {
        try {
            Connection connection = getConnection();
            ProductService productService = new ProductService(connection); // Crear ProductService con conexión
            RegisterExistScreen registerExistScreen = new RegisterExistScreen(productService); // Pasar ProductService al constructor
            registerExistScreen.setVisible(true); // Mostrar la pantalla
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
