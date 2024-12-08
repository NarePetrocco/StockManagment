package com.stockmanagement.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterEntryScreen extends JFrame {

    public RegisterEntryScreen() {
        setTitle("Registrar Entrada");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana
        setLocationRelativeTo(null);

        // Crear los campos y botones
        JLabel productLabel = new JLabel("Producto:");
        JTextField productField = new JTextField(20);

        JLabel quantityLabel = new JLabel("Cantidad:");
        JTextField quantityField = new JTextField(10);

        JLabel dateLabel = new JLabel("Fecha:");
        JTextField dateField = new JTextField(10);

        JButton submitButton = new JButton("Registrar Entrada");

        // Panel de diseño
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(productLabel);
        panel.add(productField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(submitButton);

        // Agregar panel a la ventana
        add(panel);

        // Acción del botón de registrar
        submitButton.addActionListener(e -> {
            // Aquí puedes agregar la lógica para guardar la entrada de producto
            String product = productField.getText();
            String quantity = quantityField.getText();
            String date = dateField.getText();

            // Aquí puedes agregar lógica para guardar los datos, verificar que no estén vacíos, etc.
            JOptionPane.showMessageDialog(this, "Entrada registrada: " + product + ", Cantidad: " + quantity + ", Fecha: " + date);
        });
        // Botón retroceder
        JButton backButton = new JButton("Retroceder");
        backButton.addActionListener(e -> {
            // Cerrar la ventana actual
            dispose();
        });
        panel.add(backButton);

        add(panel);
    }
}
