package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class ViewAllProductsScreen extends JFrame {
    private Connection connection;

    public ViewAllProductsScreen(Connection connection) {
        this.connection = connection;
        setTitle("Visualizar Todos los Productos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> dispose());

        // Aquí se agregaría la lógica para mostrar todos los productos
        JTextArea productsArea = new JTextArea();
        productsArea.setEditable(false);
        // productsArea.setText(productService.getAllProductsAsString()); // Supongamos que tienes un método para esto

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(productsArea), BorderLayout.CENTER); // Para poder desplazar si hay muchos productos
        panel.add(backButton, BorderLayout.SOUTH); // Botón al final

        add(panel);
    }

}
