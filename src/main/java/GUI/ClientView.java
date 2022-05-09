package GUI;

import BusinessLogicLayer.BaseProduct;
import BusinessLogicLayer.DeliveryService;
import BusinessLogicLayer.Order;
import BusinessLogicLayer.MenuItem;
import DataAccessLayer.FileWriter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ClientView extends JFrame{

    JButton backButton=new JButton("Back");
    JButton viewProducts;
    JButton searchProduct = new JButton("Search product");
    JButton createOrder = new JButton("Create order");
    JLabel productTitle =new JLabel("Title:");
    JTextField titleText=new JTextField();
    JLabel rating=new JLabel("Rating:");
    JTextField ratingText=new JTextField();
    JLabel calories=new JLabel("Calories:");
    JTextField caloriesText=new JTextField();
    JLabel protein=new JLabel("Protein:");
    JTextField proteinText=new JTextField();
    JLabel fat=new JLabel("Fat:");
    JTextField fatText=new JTextField();
    JLabel sodium=new JLabel("Sodium:");
    JTextField sodiumText=new JTextField();
    JLabel price=new JLabel("Price:");
    JTextField priceText=new JTextField();
    BaseProduct productBaseProduct=new BaseProduct();
    DefaultTableModel defaultTableModel;
    JTable jTable;
    DeliveryService deliveryService;
    DeliveryService deliveryService2=new DeliveryService();
    JComboBox comboBox;
    List<BaseProduct> items;
    JButton  viewOrders=new JButton("View orders");

    public ClientView(){
        this.setSize(1350, 750);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(200, 80, 90));

        JLabel title = new JLabel("CLIENT");
        title.setBounds(450, 5, 300, 70);
        title.setBackground(new Color(200, 80, 90));
        title.setFont(new Font("Calibri", Font.ITALIC, 50));
        title.setVisible(true);
        this.add(title);

        List<BaseProduct> baseProductList;
        baseProductList = productBaseProduct.readCsvFile();


        searchProduct.setBounds(20,400,250,50);
        searchProduct.setFocusable(false);
        searchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==searchProduct){
                    if(comboBox.getSelectedItem().equals("Title"))
                    {   String string="";
                        for (BaseProduct baseProduct:cautareDupaTitlu(titleText.getText())) {
                            System.out.println(baseProduct.toString());
                            string=string+baseProduct.toString()+"\n";
                        }
                        ResultView resultView=new ResultView(string);
                    }
                    else
                    {
                        if(comboBox.getSelectedItem().equals("Rating"))
                        { String string="";
                            for (BaseProduct baseProduct:cautareDupaRating(Float.parseFloat(ratingText.getText().toString()))) {
                                System.out.println(baseProduct.toString());
                                string=string+baseProduct.toString()+"\n";
                            }
                            ResultView resultView=new ResultView(string);
                        }
                        else
                        {if(comboBox.getSelectedItem().equals("Calories"))
                            {String string="";
                                for (BaseProduct baseProduct:cautareDupaCalorii(Integer.parseInt(caloriesText.getText().toString()))) {
                                System.out.println(baseProduct.toString());
                                    string=string+baseProduct.toString()+"\n";
                            }
                                ResultView resultView=new ResultView(string);
                            }
                            else
                            {if(comboBox.getSelectedItem().equals("Protein"))
                                {String string="";
                                    for (BaseProduct baseProduct:cautareDupaProteine(Integer.parseInt(proteinText.getText().toString()))) {
                                        System.out.println(baseProduct.toString());
                                        string=string+baseProduct.toString()+"\n";}
                                    ResultView resultView=new ResultView(string);
                                }
                                else
                                {if(comboBox.getSelectedItem().equals("Fat"))
                                    {for (BaseProduct baseProduct:cautareDupaGrasimi(Integer.parseInt(fatText.getText().toString()))) {
                                        System.out.println(baseProduct.toString());}
                                    }
                                    else
                                    {if(comboBox.getSelectedItem().equals("Sodium"))
                                        { String string="";
                                            for (BaseProduct baseProduct:cautareDupaSodium(Integer.parseInt(sodiumText.getText().toString()))) {
                                            System.out.println(baseProduct.toString());
                                                string=string+baseProduct.toString()+"\n";}
                                            ResultView resultView=new ResultView(string);
                                        }
                                        else
                                        {if(comboBox.getSelectedItem().equals("Price")) {
                                            String string="";
                                                for (BaseProduct baseProduct : cautareDupaPret(Integer.parseInt(priceText.getText().toString()))) {
                                                    System.out.println(baseProduct.toString());
                                                    string=string+baseProduct.toString()+"\n";}
                                            ResultView resultView=new ResultView(string);
                                        }
                                        }
                                    }}}}}}}});
        this.add(searchProduct);

        createOrder.setBounds(20,470,250,50);
        createOrder.setFocusable(false);

        createOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==createOrder){
                    FileWriter f=new FileWriter();
                    int[] randuri;
                    randuri = jTable.getSelectedRows();
                    List<MenuItem> menuItems=new ArrayList<>();
                    int lungime=randuri.length;
                    int i=0;
                    List<BaseProduct> prod=new ArrayList<>();
                    while(i<lungime)
                    {
                        BaseProduct baseProductSelected = items.get(jTable.convertRowIndexToModel(randuri[i]));
                        menuItems.add(baseProductSelected);
                        prod.add(baseProductSelected);
                        i++;
                    }
                    Order o=new Order(menuItems);
                    Random rand = new Random();
                    int id= rand.nextInt(170);
                    Random rand2 = new Random();
                    int id2= rand.nextInt(170);
                    o.setIdOrder(id2);
                    o.setClientId(id);
                    o.setDate( LocalDateTime.now());
                    deliveryService = new DeliveryService();
                    //Această metodă creează un nou observator la colecția de observatori pentru un astfel de obiect, atâta timp cât nu este același cu unul care există deja.
                    deliveryService.addObserver((Observer)new EmployeeView("S-a facut o noua comanda"));
                    deliveryService.createOrder(o, prod);
                    System.out.println(o +"\nClientul a comandat: " + menuItems+"\n");
                    f.factura(o);
                }
            }
        });

        this.add(createOrder);

        viewOrders.setBounds(20,600,250,50);
        viewOrders.setFocusable(false);
        viewOrders.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== viewOrders){
                    String scris=deliveryService2.afisareComenzi();
                  ResultView view=new ResultView(scris);
                }
            }
        });
        this.add(viewOrders);

        backButton.setBounds(1100,10,150,30);
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

        productTitle.setBounds(20,80,100,40);
        this.add(productTitle);
        titleText.setBounds(140,90,170,25);
        this.add(titleText);

        rating.setBounds(20,120,100,40);
        this.add(rating);
        ratingText.setBounds(140,130,170,25);
        this.add(ratingText);

        calories.setBounds(20,150,110,70);
        this.add(calories);
        caloriesText.setBounds(140,170,170,25);
        this.add(caloriesText);


        protein.setBounds(20,200,100,40);
        this.add(protein);
        proteinText.setBounds(140,210,170,25);
        this.add(proteinText);

        fat.setBounds(20,240,100,40);
        this.add(fat);
        fatText.setBounds(140,250,170,25);
        this.add(fatText);

        sodium.setBounds(20,280,100,40);
        this.add(sodium);
        sodiumText.setBounds(140,290,170,25);
        this.add(sodiumText);

        price.setBounds(20,320,100,40);
        this.add(price);
        priceText.setBounds(140,330,170,25);
        this.add(priceText);

        JPanel jPanel=new JPanel();
        jPanel.setBorder(new EtchedBorder());
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(400,100,900,500);
        jPanel.setBackground(Color.WHITE);
        jPanel.setVisible(true);

       productBaseProduct =new BaseProduct();
       items = productBaseProduct.readCsvFile();
        defaultTableModel =new DefaultTableModel();
        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Rating");
        defaultTableModel.addColumn("Calories");
        defaultTableModel.addColumn("Protein");
        defaultTableModel.addColumn("Fat");
        defaultTableModel.addColumn("Sodium");
        defaultTableModel.addColumn("Price");

        for (BaseProduct bp:baseProductList) {
            String  name = bp.getTitle();
            String  rating = Float.toString(bp.getRating());
            String  calories = Integer.toString(bp.getCalories());
            String protein = Integer.toString(bp.getProtein());
            String fat = Integer.toString(bp.getFat());
            String sodium = Integer.toString(bp.getSodium());
            String price = Integer.toString(bp.getPrice());
            defaultTableModel.addRow(new Object[]{name,rating,calories,protein,fat,sodium,price});
        }



        jTable =new JTable(defaultTableModel);
        jTable.setVisible(true);
        jTable.setBounds(0,0,500,500);
        jTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable.setColumnSelectionAllowed(false);
        jTable.setRowSelectionAllowed(true);
        jTable.addRowSelectionInterval(1, 100);
        JScrollPane sp=new JScrollPane(jTable);
        sp.setBounds(0,0,900,500);
        jPanel.add(sp);

        String filters[] = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        comboBox = new JComboBox(filters);
        comboBox.setBounds(20,530,200,40);
        this.add(comboBox);


        this.setVisible(true);
    }

    public List<BaseProduct> cautareDupaTitlu(String s){
       return  this.items.stream().filter(e -> e.getTitle().toLowerCase().contains(s.toLowerCase())).collect(Collectors.toList());
    }

    public List<BaseProduct> cautareDupaRating(float value){

     return this.items.stream().filter(e -> e.getRating()==value).collect(Collectors.toList());

    }

    public List<BaseProduct> cautareDupaCalorii(int value){
        return this.items.stream().filter(e -> e.getCalories()==value).collect(Collectors.toList());
    }

    public List<BaseProduct> cautareDupaProteine(int value){
        return this.items.stream().filter(e -> e.getProtein()==value ).collect(Collectors.toList());
    }

    public List<BaseProduct> cautareDupaGrasimi(int value){
        return this.items.stream().filter(e -> e.getFat()==value).collect(Collectors.toList());
    }

    public List<BaseProduct> cautareDupaSodium(int value){
        return this.items.stream().filter(e -> e.getSodium()==value).collect(Collectors.toList());
    }

    public List<BaseProduct> cautareDupaPret(int value){
        return this.items.stream().filter(e -> e.getPrice()==value).collect(Collectors.toList());
    }
}