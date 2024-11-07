package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UpdateProductScreen extends JFrame {
    private Connection connection;

    public UpdateProductScreen(Connection connection) {
        this.connection = connection;
        setTitle("Actualizar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField productIdField = new JTextField();
        JTextField productNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();

        JButton updateButton = new JButton("Actualizar");
        updateButton.addActionListener(e -> updateProduct(productIdField.getText(), productNameField.getText(), quantityField.getText(), priceField.getText()));

        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("ID del Producto:"));
        panel.add(productIdField);
        panel.add(new JLabel("Nombre:"));
        panel.add(productNameField);
        panel.add(new JLabel("Cantidad:"));
        panel.add(quantityField);
        panel.add(new JLabel("Precio:"));
        panel.add(priceField);
        panel.add(updateButton);
        panel.add(backButton);

        add(panel);
    }

    private void updateProduct(String id, String name, String quantity, String price) {
        // Lógica para actualizar el producto usando ProductService
        // productService.updateProduct(Integer.parseInt(id), name, Integer.parseInt(quantity), Double.parseDouble(price));
        JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente.");
    }
}
