package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;

public class ResultView {

    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    JLabel title = new JLabel("PRODUSELE GASITE");
    JTextField text=new JTextField();
    public ResultView() {

        frame.setSize(800, 500);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(200, 80, 90));


        title.setBounds(250, 10, 300, 70);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 20));
        title.setVisible(true);
        frame.add(title);

        panel.setSize(900,300);
        panel.setBounds(0,0,800,500);
        panel.setBackground(new Color(200, 80, 90));
        panel.setLayout(null);
        panel.setVisible(true);
        text.setVisible(true);
        text.setSize(10,10);
        text.setLayout(null);
        panel.add(text);
        frame.add(panel);



        frame.setVisible(true);
    }
}
