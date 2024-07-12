package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame pk = new JFrame();
        pk.setTitle("Login");
        pk.setContentPane(new Login().log);
        pk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pk.setSize(700, 700);
        pk.setVisible(true);

    }
}