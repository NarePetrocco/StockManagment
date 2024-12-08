package com.stockmanagement.ui;

import com.stockmanagement.services.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductScreen extends JFrame {
    private ProductService productService;

    public UpdateProductScreen(ProductService productService) {
        this.productService = productService;
        setTitle("Actualizar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Campos para actualizar producto
        JTextField productIdField = new JTextField();
        JTextField productNameField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField categoryIdField = new JTextField();
        JTextField supplierIdField = new JTextField();

        // Botón de actualizar
        JButton updateButton = new JButton("Actualizar");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los valores ingresados
                    int productId = Integer.parseInt(productIdField.getText());
                    String name = productNameField.getText();
                    int quantity = Integer.parseInt(quantityField.getText());
                    double price = Double.parseDouble(priceField.getText());
                    int categoryId = Integer.parseInt(categoryIdField.getText());
                    int supplierId = Integer.parseInt(supplierIdField.getText());

                    // Llamar al ProductService para actualizar el producto
                    productService.updateProduct(productId, name, quantity, price, categoryId, supplierId);
                    JOptionPane.showMessageDialog(UpdateProductScreen.this, "Producto actualizado exitosamente.");

                    // Limpiar los campos después de actualizar
                    productIdField.setText("");
                    productNameField.setText("");
                    quantityField.setText("");
                    priceField.setText("");
                    categoryIdField.setText("");
                    supplierIdField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(UpdateProductScreen.this, "Error al actualizar producto: " + ex.getMessage());
                }
            }
        });

        // Botón de retroceder
        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> {
            dispose(); // Cerrar la pantalla actual
        });

        // Panel de diseño
        JPanel panel = new JPanel(new GridLayout(7, 2)); // Cambiado a 7 filas, 2 columnas
        panel.add(new JLabel("ID del Producto:")); // Fila 1, Columna 1
        panel.add(productIdField); // Fila 1, Columna 2
        panel.add(new JLabel("Nombre del Producto:")); // Fila 2, Columna 1
        panel.add(productNameField); // Fila 2, Columna 2
        panel.add(new JLabel("Cantidad:")); // Fila 3, Columna 1
        panel.add(quantityField); // Fila 3, Columna 2
        panel.add(new JLabel("Precio:")); // Fila 4, Columna 1
        panel.add(priceField); // Fila 4, Columna 2
        panel.add(new JLabel("ID Categoría:")); // Fila 5, Columna 1
        panel.add(categoryIdField); // Fila 5, Columna 2
        panel.add(new JLabel("ID Proveedor:")); // Fila 6, Columna 1
        panel.add(supplierIdField); // Fila 6, Columna 2
        panel.add(updateButton); // Fila 7, Columna 1
        panel.add(backButton); // Fila 7, Columna 2

        add(panel); // Agregar el panel al marco
    }
}
