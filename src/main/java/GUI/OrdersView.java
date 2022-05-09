package GUI;

import BusinessLogicLayer.BaseProduct;
import BusinessLogicLayer.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrdersView implements ActionListener {
    BaseProduct produs=new BaseProduct();
    JFrame frame = new JFrame();
    DeliveryService delivery=new DeliveryService();
    JButton inapoi = new JButton("Back");

    public OrdersView() {
        inapoi.setBounds(100, 260, 200, 30);
        inapoi.addActionListener(this);
        frame.add(inapoi);


        frame.getContentPane().setBackground(new Color(200, 80, 90));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Orders");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inapoi)
            frame.dispose();
        }

}


