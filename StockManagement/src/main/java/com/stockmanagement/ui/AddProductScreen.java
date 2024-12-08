package com.stockmanagement.ui;

import com.stockmanagement.services.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductScreen extends JFrame {
    private ProductService productService;

    // Constructor que recibe el ProductService
    public AddProductScreen(ProductService productService) {
        this.productService = productService; // Guardar el ProductService para usarlo más tarde
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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los valores ingresados
                    String name = productNameField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    int categoryId = Integer.parseInt(categoryIdField.getText());
                    int supplierId = Integer.parseInt(supplierIdField.getText());

                    // Llamar al ProductService para agregar el producto
                    productService.addProduct(name, quantity, price, categoryId, supplierId);
                    JOptionPane.showMessageDialog(AddProductScreen.this, "Producto agregado exitosamente.");

                    // Limpiar los campos después de agregar
                    productNameField.setText("");
                    quantityField.setText("");
                    priceField.setText("");
                    categoryIdField.setText("");
                    supplierIdField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(AddProductScreen.this, "Error al agregar producto: " + ex.getMessage());
                }
            }
        });

        // Botón de retroceder
        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> {
            dispose(); // Cerrar la pantalla actual
        });

        // Panel de diseño
        JPanel panel = new JPanel(new GridLayout(6, 2)); // Cambiado a 6 filas, 2 columnas
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
}
