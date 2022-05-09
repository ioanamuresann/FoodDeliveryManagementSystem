package GUI;


import BusinessLogicLayer.BaseProduct;
import BusinessLogicLayer.DeliveryService;
import BusinessLogicLayer.IDeliveryServiceProcessing;
import DataAccessLayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AdminView extends JFrame{

    JButton backButton=new JButton("Back");
    JButton importProducts = new JButton("Import products");
    JButton addProduct = new JButton("Add new product");
    JButton deleteProduct = new JButton("Delete product");
    JButton modifyProduct = new JButton("Edit product");
    JButton generateReport = new JButton("Generate report 1");
    JButton generateReport2 = new JButton("Generate report 2");
    JButton generateReport3 = new JButton("Generate report 3");
    JButton  generateReport4 = new JButton("Generate report 4");
    JLabel productTitle =new JLabel("Title:");
    JTextField titleText=new JTextField();
    JLabel rating=new JLabel("Rating:");
    JLabel title = new JLabel("ADMINISTRATOR");
    JTextField ratingText=new JTextField();
    JLabel calories=new JLabel("Calories:");
    JTextField  caloriesText=new JTextField();
    JLabel protein=new JLabel("Protein:");
    JTextField proteinText=new JTextField();
    JLabel fat=new JLabel("Fat:");
    JTextField fatText=new JTextField();
    JLabel sodium=new JLabel("Sodium:");
    JTextField sodiumText=new JTextField();
    JLabel price=new JLabel("Price:");
    JTextField priceText=new JTextField();
    BaseProduct productBaseProduct = new BaseProduct();
    DefaultTableModel defaultTableModel= new DefaultTableModel();
    JTable jTable;
    DeliveryService service=new DeliveryService();
    JLabel hour1=new JLabel("Hour1:");
    JTextField hour1Text=new JTextField();
    JLabel hour2=new JLabel("Hour2:");
    JTextField hour2Text=new JTextField();
    JButton composite=new JButton("Create new products");
    DeliveryService deliveryService = new DeliveryService();
    JButton viewComposedButton=new JButton("View composed products");
    Serializator serializator=new Serializator();
    public AdminView(){
        this.setSize(1700, 750);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(200, 80, 90));


        title.setBounds(500, 5, 300, 70);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 35));
        title.setVisible(true);
        this.add(title);


        productTitle.setBounds(300,80,100,40);
        this.add(productTitle);
        titleText.setBounds(420,90,170,25);
        this.add(titleText);


        rating.setBounds(300,120,100,40);
        this.add(rating);
        ratingText.setBounds(420,130,170,25);
        this.add(ratingText);


        calories.setBounds(300,150,100,70);
        this.add(calories);
        caloriesText.setBounds(420,170,170,25);
        this.add(caloriesText);


        protein.setBounds(300,200,100,40);
        this.add(protein);
        proteinText.setBounds(420,210,170,25);
        this.add(proteinText);


        fat.setBounds(300,240,100,40);
        this.add(fat);
        fatText.setBounds(420,250,170,25);
        this.add(fatText);


        sodium.setBounds(300,280,100,40);
        this.add(sodium);
        sodiumText.setBounds(420,290,170,25);
        this.add(sodiumText);


        price.setBounds(300,320,100,40);
        this.add(price);
        priceText.setBounds(420,330,170,25);
        this.add(priceText);

        hour1.setBounds(300,400,100,40);
        this.add(hour1);
        hour1Text.setBounds(420,410,170,25);
        this.add(hour1Text);

        hour2.setBounds(300,440,100,40);
        this.add(hour2);
        hour2Text.setBounds(420,450,170,25);
        this.add(hour2Text);


        composite.setBounds(300,480,250,40);
        this.add(composite);
        composite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==composite){
                    new CreateComposedProductView();
                }
            }
        });

        JPanel jPanel=new JPanel();
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(600,100,900,500);
        jPanel.setVisible(true);

        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Rating");
        defaultTableModel.addColumn("Calories");
        defaultTableModel.addColumn("Protein");
        defaultTableModel.addColumn("Fat");
        defaultTableModel.addColumn("Sodium");
        defaultTableModel.addColumn("Price");

        jTable = new JTable(defaultTableModel);
        jTable.setVisible(true);
        jTable.setBounds(0,0,500,500);
        JScrollPane sp=new JScrollPane(jTable);
        sp.setBounds(0,0,900,500);
        jPanel.add(sp);

        importProducts.setBounds(20,70,250,50);
        importProducts.setFocusable(false);
        importProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==importProducts){
                    List<BaseProduct> baseProductList;
                    baseProductList = productBaseProduct.readCsvFile();

                    for (BaseProduct bp:baseProductList) {
                        Object[] obiect=service.importProduct(bp);
                        defaultTableModel.addRow(obiect);
                    }
                }
            }
        });
        this.add(importProducts);

        addProduct.setBounds(20,150,250,50);
        addProduct.setFocusable(false);
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addProduct){
                    int ok=0;
                    String prName = titleText.getText();
                    String prRating = ratingText.getText();
                    String prCalories = caloriesText.getText();
                    String prProtein = proteinText.getText();
                    String prFat = fatText.getText();
                    String prSodium = sodiumText.getText();
                    String prPrice = priceText.getText();
                    if(Integer.parseInt(ratingText.getText())<0 || Integer.parseInt(caloriesText.getText())<0 || Integer.parseInt(proteinText.getText())<0
                   || Integer.parseInt(fatText.getText())<0 || Integer.parseInt(sodiumText.getText())<0 || Integer.parseInt(priceText.getText())<0)
                        ok=1;
                    if(ok==0)
                    { Object[] obiect=new Object[]{prName,prRating, prCalories, prProtein, prFat, prSodium,prPrice};
                        BaseProduct pr=new BaseProduct(prName,Float.parseFloat(ratingText.getText()),Integer.parseInt(caloriesText.getText()),Integer.parseInt(proteinText.getText()),Integer.parseInt(fatText.getText()),Integer.parseInt(sodiumText.getText()),Integer.parseInt(priceText.getText()));
                    defaultTableModel.addRow(obiect);
                     //   serializator.deserializationFunction2();
                        serializator.serializationFunction2(pr);

                    JOptionPane.showMessageDialog(null,"DONE!");}
                    else
                    {
                        JOptionPane.showMessageDialog(null,"DATE INVALIDE!");
                    }

                }
            }
        });

        this.add(addProduct);
        deleteProduct.setBounds(20,230,250,50);
        deleteProduct.setFocusable(false);
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==deleteProduct){
                    defaultTableModel.removeRow(13);
                    String nume = titleText.getText();
                    service.deleteProduct(nume);
                    JOptionPane.showMessageDialog(null,"Product deleted!");

                }
            }
        });
        this.add(deleteProduct);


        modifyProduct.setBounds(20,310,250,50);
        modifyProduct.setFocusable(false);
        modifyProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==modifyProduct){

                }
            }
        });
        this.add(modifyProduct);

        generateReport.setBounds(20,390,250,50);
        generateReport.setFocusable(false);
        generateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport){
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime h1 = LocalDateTime.parse(hour1Text.getText(), format);
                    LocalDateTime h2 = LocalDateTime.parse(hour2Text.getText(), format);
                    deliveryService.generateReport1(h1, h2);
                    JOptionPane.showMessageDialog(null,"DONE!");
                }
            }
        });

        this.add(generateReport);

        generateReport2.setBounds(20,470,250,50);
        generateReport2.setFocusable(false);
        generateReport2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport2){
                     deliveryService.generateReport2(1);
                     JOptionPane.showMessageDialog(null,"DONE!");
                }
            }
        });
        this.add(generateReport2);

        generateReport3.setBounds(20,550,250,50);
        generateReport3.setFocusable(false);
        generateReport3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport3){
                    deliveryService.generateReport3(6, 100);
                    JOptionPane.showMessageDialog(null,"DONE!");
                }
            }
        });
        this.add(generateReport3);

        generateReport4.setBounds(20,630,250,50);
        generateReport4.setFocusable(false);
        generateReport4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport4){
                    LocalDateTime time = LocalDateTime.now();
                    deliveryService.generateReport4(time);
                    JOptionPane.showMessageDialog(null,"DONE!");
                }
            }
        });
        this.add(generateReport4);


        backButton.setBounds(1300,10,150,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    dispose();
                    MainFrame v=new MainFrame();
                }
            }
        });
        this.add(backButton);

        viewComposedButton.setBounds(300,540,250,40);
        viewComposedButton.setFocusable(false);
        viewComposedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==viewComposedButton)
                {
                    DeliveryService.showAllComposedProducts();
                }
            }
        });
        this.add(viewComposedButton);
        this.setVisible(true);
    }
}