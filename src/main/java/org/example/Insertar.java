package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Insertar {
    public JPanel insert;
    private JTextField cat2;
    private JTextField nom2;
    private JTextField desc2;
    private JTextField precio2;
    private JTextField cant2;
    private JButton inserta;
    private JTextField cod1;


    String url = "jdbc:mysql://localhost:3306/productos_cp";
    String user = "root";
    String pass = "123456";

    Productos pd = new Productos();


    public Insertar() {
        inserta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                    String sql = "insert into producto (codigo_producto, nombre, descripcion, precio, cantidad, categoria) values (?,?,?,?,?,?)";

                    PreparedStatement ps = connection.prepareStatement(sql);

                    System.out.println("Conexión exitosa");
                    pd.setCodigo_producto(cod1.getText());
                    pd.setNombre(nom2.getText());
                    pd.setDescripcion(desc2.getText());
                    pd.setPrecio(Double.parseDouble(precio2.getText()));
                    pd.setCantidad(Integer.parseInt(cant2.getText()));
                    pd.setCategoria(cat2.getText());

                    ps.setString(1, pd.getCodigo_producto());
                    ps.setString(2, pd.getNombre());
                    ps.setString(3, pd.getDescripcion());
                    ps.setDouble(4, pd.getPrecio());
                    ps.setInt(5, pd.getCantidad());
                    ps.setString(6, pd.getCategoria());
                    ps.executeUpdate();

                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

            }
        });
    }
}


