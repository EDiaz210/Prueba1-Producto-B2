package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public JPanel menu;
    private JButton buscar;
    private JButton insertar;


    public Menu() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pk = new JFrame();
                pk.setTitle("Login");
                pk.setContentPane(new Insertar().insert);
                pk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pk.setSize(700, 700);
                pk.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(insertar)).dispose();

            }
        });
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pk = new JFrame();
                pk.setTitle("Login");
                pk.setContentPane(new Busqueda().busq);
                pk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pk.setSize(700, 700);
                pk.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();

            }
        });
    }
}
