package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda {
    private JTextField busquedaXD;
    private JButton busque;
    public JPanel busq;
    private JLabel cod;
    private JLabel nom;
    private JLabel desc;
    private JLabel precio;
    private JLabel cant;
    private JLabel cat;

    public Busqueda() {

        String url = "jdbc:mysql://localhost:3306/productos_cp";
        String user = "root";
        String pass = "123456";


        busque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                    String sql = "select * from producto where codigo_producto = '" + busquedaXD.getText() + "'";
                    Statement xp = connection.createStatement();
                    ResultSet rs = xp.executeQuery(sql);

                    System.out.println("Conexión exitosa");
                    while (rs.next()) {
                        cod.setText("Codigo del Producto: " + rs.getString("codigo_producto"));
                        nom.setText("Nombre: " + rs.getString("nombre"));
                        desc.setText("Descripción " + rs.getString("descripcion"));
                        precio.setText("Precio: " + rs.getString("precio"));
                        cant.setText("Cantidad: " + rs.getString("cantidad"));
                        cat.setText("Categoría: " + rs.getString("categoria"));

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

}
