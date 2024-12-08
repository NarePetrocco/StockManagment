package com.stockmanagement.ui;

import com.stockmanagement.services.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductScreen extends JFrame {
    private ProductService productService;

    public DeleteProductScreen(ProductService productService) {
        this.productService = productService; // Guardar el ProductService para usarlo más tarde
        setTitle("Eliminar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Campos para eliminar producto
        JTextField productIdField = new JTextField();

        // Botón para eliminar
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el ID del producto a eliminar
                    int productId = Integer.parseInt(productIdField.getText());

                    // Llamar al ProductService para eliminar el producto
                    productService.deleteProduct(productId);
                    JOptionPane.showMessageDialog(DeleteProductScreen.this, "Producto eliminado exitosamente.");

                    // Limpiar el campo de texto
                    productIdField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DeleteProductScreen.this, "Error al eliminar producto: " + ex.getMessage());
                }
            }
        });

        // Botón de retroceder
        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> {
            dispose(); // Cerrar la pantalla actual
        });

        // Panel de diseño
        JPanel panel = new JPanel(new GridLayout(3, 2)); // Cambiado a 3 filas, 2 columnas
        panel.add(new JLabel("ID del Producto:")); // Fila 1, Columna 1
        panel.add(productIdField); // Fila 1, Columna 2
        panel.add(deleteButton); // Fila 2, Columna 1
        panel.add(backButton); // Fila 2, Columna 2

        add(panel); // Agregar el panel al marco
    }
}
