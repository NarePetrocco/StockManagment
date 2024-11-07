package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class SearchProductScreen extends JFrame {
    private Connection connection;

    public SearchProductScreen(Connection connection) {
        this.connection = connection;
        setTitle("Buscar Producto por ID");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField productIdField = new JTextField();
        JButton searchButton = new JButton("Buscar");
        searchButton.addActionListener(e -> searchProduct(productIdField.getText()));

        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID del Producto:"));
        panel.add(productIdField);
        panel.add(searchButton);
        panel.add(backButton);

        add(panel);
    }

    private void searchProduct(String productId) {
        // Lógica para buscar el producto usando ProductService
        // Products product = productService.getProductById(Integer.parseInt(productId));
        // if (product != null) {
        //     JOptionPane.showMessageDialog(this, "Producto encontrado: " + product.toString());
        // } else {
        //     JOptionPane.showMessageDialog(this, "Producto no encontrado.");
        // }
        JOptionPane.showMessageDialog(this, "Buscar producto no implementado.");
    }
}

