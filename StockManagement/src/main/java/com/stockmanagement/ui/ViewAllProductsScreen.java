package com.stockmanagement.ui;

import com.stockmanagement.services.ProductService;
import com.stockmanagement.models.Products;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class ViewAllProductsScreen extends JFrame {
    private ProductService productService;

    public ViewAllProductsScreen(ProductService productService) {
        this.productService = productService;

        setTitle("Visualizar Productos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        try {
            List<Products> products = productService.getAllProducts(); // Aquí debes asegurarte de que getAllProducts() devuelve una lista de 'Products'
            String[] columnNames = {"ID", "Nombre", "Cantidad", "Precio", "Categoría", "Proveedor"};
            Object[][] data = new Object[products.size()][6];

            for (int i = 0; i < products.size(); i++) {
                Products product = products.get(i);
                data[i][0] = product.getId(); // Asegúrate de que 'Products' tiene los métodos getId(), getName(), etc.
                data[i][1] = product.getName();
                data[i][2] = product.getQuantity();
                data[i][3] = product.getPrice();
                data[i][4] = product.getCategoryId();
                data[i][5] = product.getSupplierId();
            }

            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener productos: " + e.getMessage());
        }

        setVisible(true);
    }
}