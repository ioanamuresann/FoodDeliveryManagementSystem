package GUI;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;

public class ResultView {

    JFrame frame=new JFrame();
    JButton backButton=new JButton("BACK");
    public ResultView(String mesaj) {

        frame.setSize(1180, 550);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(200, 80, 90));

        JLabel title = new JLabel("PRODUSE GASITE");
        title.setBounds(100, 5, 300, 70);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 40));
        title.setVisible(true);
       frame.add(title);

        backButton.setBounds(930,10,150,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    frame.dispose();
                    ClientView v=new ClientView();
                }
            }
        });
        frame.add(backButton);

        JPanel jPanel=new JPanel();
        jPanel.setBorder(new EtchedBorder());
        frame.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(10,100,900,500);
        jPanel.setVisible(true);


        JTextArea label = new JTextArea(mesaj);
        label.setBounds(10,100,900,500);
        label.setBackground(new Color(200, 80, 90));
        label.setVisible(true);
        jPanel.add(label);

        frame.setVisible(true);

    }


}
