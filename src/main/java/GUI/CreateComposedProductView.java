package GUI;

import BusinessLogicLayer.BaseProduct;
import BusinessLogicLayer.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CreateComposedProductView implements ActionListener {
    BaseProduct produs=new BaseProduct();
    JFrame frame = new JFrame();
    JLabel nume = new JLabel("Nume: ");
    JTextField numeField = new JTextField();
    JLabel produs1 = new JLabel("Produs 1: ");
    JLabel produs2 = new JLabel("Produs 2: ");
    JLabel produs3 = new JLabel("Produs 3: ");
    JComboBox<Object> comboBox1 = new JComboBox<>();
    JComboBox<Object> comboBox2 = new JComboBox<>();
    JComboBox<Object> comboBox3 = new JComboBox<>();
    JButton create = new JButton("Create");
    JButton inapoi = new JButton("Back");

    public CreateComposedProductView() {
        List<BaseProduct> baseProducts = produs.readCsvFile();
        for (BaseProduct baseProduct : baseProducts) {
            comboBox1.addItem(baseProduct);
            comboBox2.addItem(baseProduct);
            comboBox3.addItem(baseProduct);
        }
        nume.setBounds(20, 10, 100, 30);
        frame.add(nume);

        numeField.setBounds(80, 10, 400, 30);
        frame.add(numeField);

        produs1.setBounds(20, 50, 200, 30);
        frame.add(produs1);

        comboBox1.setBounds(80, 50, 400, 30);
        frame.add(comboBox1);

        produs2.setBounds(20, 90, 200, 30);
        frame.add(produs2);

        comboBox2.setBounds(80, 90, 400, 30);
        frame.add(comboBox2);

        produs3.setBounds(20, 130, 200, 30);
        frame.add(produs3);

        comboBox3.setBounds(80, 130, 400, 30);
        frame.add(comboBox3);

        create.setBounds(100, 220, 200, 30);
        create.addActionListener(this);
        frame.add(create);

        inapoi.setBounds(100, 260, 200, 30);
        inapoi.addActionListener(this);
        frame.add(inapoi);


        frame.getContentPane().setBackground(new Color(200, 80, 90));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Composed product");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inapoi)
            frame.dispose();
        if (e.getSource() == create) {
            String name = numeField.getText();
            BaseProduct selectedProduct1 = (BaseProduct) comboBox1.getSelectedItem();
            BaseProduct selectedProduct2 = (BaseProduct) comboBox2.getSelectedItem();
            BaseProduct selectedProduct3 = (BaseProduct) comboBox3.getSelectedItem();
            ArrayList<BaseProduct> baseProducts = new ArrayList<>();
            baseProducts.add(selectedProduct1);
            baseProducts.add(selectedProduct2);
            baseProducts.add(selectedProduct3);
            DeliveryService.addComposedProduct(name,baseProducts);
            JOptionPane.showMessageDialog(null, "Composed product added");
            frame.dispose();
        }
    }
}

