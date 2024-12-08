package com.stockmanagement.ui;

import javax.swing.*;
import java.awt.*;
import com.stockmanagement.services.ProductService;

public class RegisterExistScreen extends JFrame {

    private ProductService productService;

    public RegisterExistScreen(ProductService productService) {
        this.productService = productService; // Inicializar el servicio para interactuar con la base de datos
        setTitle("Registrar Entrada/Salida");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana
        setLocationRelativeTo(null);

        // Crear los componentes de la interfaz
        JLabel labelProductId = new JLabel("ID del Producto:");
        JTextField textFieldProductId = new JTextField(20);

        JLabel labelQuantity = new JLabel("Cantidad:");
        JTextField textFieldQuantity = new JTextField(20);

        JButton buttonRegister = new JButton("Registrar");
        buttonRegister.addActionListener(e -> registerEntryOrExit(textFieldProductId, textFieldQuantity));

        // Botón de retroceder
        JButton buttonBack = new JButton("Retroceder");
        buttonBack.addActionListener(e -> dispose()); // Cerrar la ventana actual

        // Panel para los componentes
        JPanel panel = new JPanel(new GridLayout(5, 2)); // Aumentamos el número de filas a 5
        panel.add(labelProductId);
        panel.add(textFieldProductId);
        panel.add(labelQuantity);
        panel.add(textFieldQuantity);
        panel.add(new JLabel()); // Espacio vacío en la grilla
        panel.add(buttonRegister);
        panel.add(new JLabel()); // Espacio vacío en la grilla
        panel.add(buttonBack); // Botón retroceder

        // Agregar el panel a la ventana
        add(panel);
    }

    // Método para registrar la entrada o salida del producto
    private void registerEntryOrExit(JTextField textFieldProductId, JTextField textFieldQuantity) {
        try {
            int productId = Integer.parseInt(textFieldProductId.getText());
            int quantity = Integer.parseInt(textFieldQuantity.getText());

            // Llamar al método del servicio para registrar la entrada o salida
            productService.registerEntry(); // Lógica de registro de entrada/salida

            JOptionPane.showMessageDialog(this, "Registro exitoso");
            dispose(); // Cerrar la ventana después del registro
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa valores válidos.");
        }
    }
}
