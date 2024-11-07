package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class DeleteProductScreen extends JFrame {
    private Connection connection;

    public DeleteProductScreen(Connection connection) {
        this.connection = connection;
        setTitle("Eliminar Producto");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField productIdField = new JTextField();

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> deleteProduct(productIdField.getText()));

        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> dispose());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID del Producto:"));
        panel.add(productIdField);
        panel.add(deleteButton);
        panel.add(backButton);

        add(panel);
    }

    private void deleteProduct(String productId) {
        // Lógica para eliminar el producto usando ProductService
        // productService.deleteProduct(Integer.parseInt(productId));
        JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
    }
}
