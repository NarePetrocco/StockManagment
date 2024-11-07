package com.stockmanagment.ui;

import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("Stock Management Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        JLabel label = new JLabel("Bienvenido a StockManager", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        JButton startButton = new JButton("Iniciar");
        startButton.addActionListener(e -> openMainMenu());

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    private void openMainMenu() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        this.dispose(); // Cierra la pantalla de inicio
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen();
            startScreen.setVisible(true);
        });
    }
}


