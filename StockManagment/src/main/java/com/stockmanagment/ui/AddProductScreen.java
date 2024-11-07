package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AddProductScreen extends JFrame {
    private Connection connection;

    public AddProductScreen(Connection connection) {
        this.connection = connection; // Guardar la conexión para usarla más tarde
        setTitle("Agregar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Campos para agregar producto
        JTextField productNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField categoryIdField = new JTextField();
        JTextField supplierIdField = new JTextField();

        // Botón de agregar
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> addProduct(productNameField.getText(), quantityField.getText(), priceField.getText(), categoryIdField.getText(), supplierIdField.getText()));

        // Botón de retroceder
        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> {
            dispose(); // Cerrar la pantalla actual
        });

        // Panel de diseño
        JPanel panel = new JPanel(new GridLayout(7, 2)); // Cambiado a 7 filas, 2 columnas
        panel.add(new JLabel("Nombre del Producto:")); // Fila 1, Columna 1
        panel.add(productNameField); // Fila 1, Columna 2
        panel.add(new JLabel("Cantidad:")); // Fila 2, Columna 1
        panel.add(quantityField); // Fila 2, Columna 2
        panel.add(new JLabel("Precio:")); // Fila 3, Columna 1
        panel.add(priceField); // Fila 3, Columna 2
        panel.add(new JLabel("ID Categoría:")); // Fila 4, Columna 1
        panel.add(categoryIdField); // Fila 4, Columna 2
        panel.add(new JLabel("ID Proveedor:")); // Fila 5, Columna 1
        panel.add(supplierIdField); // Fila 5, Columna 2
        panel.add(addButton); // Fila 6, Columna 1
        panel.add(backButton); // Fila 6, Columna 2 (Colocamos el botón de retroceder en la última fila)

        add(panel); // Agregar el panel al marco
    }

    private void addProduct(String name, String quantity, String price, String categoryId, String supplierId) {
        // Lógica para agregar producto usando ProductService
        try {
            // Aquí llamas a ProductService para agregar el producto
            // Por ejemplo:
            // productService.addProduct(name, Integer.parseInt(quantity), Double.parseDouble(price), Integer.parseInt(categoryId), Integer.parseInt(supplierId));
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar producto: " + e.getMessage());
        }
    }
}
