package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JTextField contra;
    private JTextField correo;
    private JButton login;
    public JPanel log;

    String url = "jdbc:mysql://localhost:3306/productos_cp";
    String user = "root";
    String pass = "123456";






    public Login() {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (Connection connection = DriverManager.getConnection(url, user, pass)) {
                    String sql = "select * from usuario";
                    Statement xp = connection.createStatement();
                    ResultSet rs = xp.executeQuery(sql);

                    while (rs.next()) {
                        correo.setText(rs.getString("username"));
                        contra.setText(rs.getString("password"));

                        if (correo.getText().equals(correo.getText()) && contra.getText().equals(contra.getText())) {
                            JFrame pk = new JFrame();
                            pk.setTitle("Login");
                            pk.setContentPane(new Menu().menu);
                            pk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            pk.setSize(700, 700);
                            pk.setVisible(true);
                        }
                    }
            }catch (SQLException e2) {
                e2.printStackTrace();}
            }


        });
    }
}
