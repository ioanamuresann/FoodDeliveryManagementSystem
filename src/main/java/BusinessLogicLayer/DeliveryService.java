package BusinessLogicLayer;

import DataAccessLayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing  {
    public HashSet<MenuItem> menuHash=new HashSet<>();
    public HashMap<Order, Collection<BaseProduct>> orderCollectionHashMap = new HashMap<>();
    public Map<Order, List<BaseProduct>> orderListHashMap = new HashMap<>();
    public List<Order> orderArrayList = new ArrayList<Order>();
    public Serializator deliverySerializator = new Serializator();
    static List<BaseProduct> baseProductsList = new ArrayList<>();
    static List<CompositeProduct> composedProducts = new ArrayList<>();

    public List<MenuItem> dailyMenu;
    public Map<Order, List<MenuItem>> ordersInformations;

    public DeliveryService(){

        orderCollectionHashMap = deliverySerializator.deserializationFunction();
    }
    public static void addComposedProduct(String nume, ArrayList<BaseProduct> baseProducts) {
        CompositeProduct compositeProduct = new CompositeProduct(nume, baseProducts);
        composedProducts.add(compositeProduct);
    }
    public static ArrayList<BaseProduct> getBaseProducts() {
        return new ArrayList<>(baseProductsList);
    }
    @Override
    public void createNewProduct(MenuItem menuItem) {
        this.menuHash.add(menuItem);
    }

    @Override
    public Object[] importProduct(BaseProduct bp) {
        String  name = bp.getTitle();
        String  rating = Float.toString(bp.getRating());
        String  calories = Integer.toString(bp.getCalories());
        String protein = Integer.toString(bp.getProtein());
        String fat = Integer.toString(bp.getFat());
        String sodium = Integer.toString(bp.getSodium());
        String price = Integer.toString(bp.getPrice());
        Object[] obiect=new Object[]{name,rating,calories,protein,fat,sodium,price};
        return obiect;
    }

    @Override
    public void editProduct(MenuItem menuItem, MenuItem newMenuItem) {
        menuItem.calories= newMenuItem.calories;
        menuItem.title= newMenuItem.title;
        menuItem.fat= newMenuItem.fat;
        menuItem.price= newMenuItem.price;
        menuItem.protein= newMenuItem.protein;
        menuItem.sodium= newMenuItem.sodium;
        menuItem.rating= newMenuItem.rating;
    }
   public boolean invariant()
   {
      if(this.orderCollectionHashMap.size()>0) {
         return true;
      }
      else{
         return false;
      }

   }
    @Override
    public void generateReport1(LocalDateTime inceput, LocalDateTime sfarsit) {

       assert this.menuHash.size()>0;
       int  h1= inceput.getHour();
       int h2= sfarsit.getHour();
       FileWriter file = null;
       try {
          file = new FileWriter("report1.txt");
       } catch (IOException e) {
          e.printStackTrace();
       }
       try {
          file.write("Comenzi cuprinse intre ora "+ inceput.getHour()+" si ora "+ sfarsit.getHour()+":"+sfarsit.getMinute()+"\n");
       } catch (IOException e) {
          e.printStackTrace();
       }
       orderCollectionHashMap = deliverySerializator.deserializationFunction();
       List <Order> dateOrders= orderCollectionHashMap.keySet().stream().filter(e->e.getDate().getHour()>=h1 && e.getDate().getHour()<=h2).collect(Collectors.toList());
       List<BaseProduct> product = new ArrayList<>();
       for(Order o: dateOrders){
          product.addAll(orderCollectionHashMap.get(o));
       }
        for(Order o: dateOrders)
        {  try {
            file.write("Detalii comanda:" + o.toString() + "\n");
        }catch (IOException e) {
            e.printStackTrace();
        }
            for (BaseProduct p : product) {
                try {
                    file.write("Produsele comandate:" + p.toString() + "\n");
                } catch (IOException x) {
                    x.printStackTrace();
                }
            }

    }

       try {
          file.close();
       } catch (IOException e) {
          e.printStackTrace();
       }
       assert this.menuHash.size()>0;
       assert invariant();
       assert WellFormed();


    }

    @Override
    public void generateReport2(Integer nrOrders) {
        assert this.menuHash.size()>0;
        FileWriter fileWriter= null;
        try {
            fileWriter = new FileWriter("report2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write("Produse ce au fost cumparate mai mult de "+ nrOrders +" ori:\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderCollectionHashMap = deliverySerializator.deserializationFunction();
        List <Order> dateOrders= orderCollectionHashMap.keySet().stream().collect(Collectors.toList());
        List<BaseProduct> product = new ArrayList<>();
        for(Order o: dateOrders){
            product.addAll(orderCollectionHashMap.get(o));
        }
     //   List<MenuItem> menuItemList=menuItemHashSet.stream().filter(e->e.getNr()>= nrOrders).collect(Collectors.toList());
        FileWriter finalFw = fileWriter;
       product.stream().forEach(e->{
            try{
                finalFw.write("Produsul "+e.getTitle()+" a fost cumparat de "+ nrOrders +" ori\n");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuHash.size()>0;
        assert invariant();
    }

    @Override
    public void generateReport3(Integer nrOrders, Integer sum) {
        assert this.menuHash.size()>0;
        FileWriter file = null;
        try {
            file = new FileWriter("report3.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.write("Clienti care au comandat de mai mult de "+ nrOrders+" ori ,cu o suma totala mai mare de "+ sum +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderCollectionHashMap = deliverySerializator.deserializationFunction();
        List <Order> dateOrders= orderCollectionHashMap.keySet().stream().collect(Collectors.toList());
        List<BaseProduct> product = new ArrayList<>();
        for(Order o: dateOrders){
            product.addAll(orderCollectionHashMap.get(o));
        }
        Vector<Integer> vector=new Vector<Integer>(100);
        int i=0;
        int ok=1;
        for(Order o: dateOrders)
        {   ok=1;
            for(int j=0;j< vector.size();j++)
            if(vector.get(j) ==o.getClientId())
                ok=0;
            else vector.add(o.getClientId());
        }
        for (int j=0;j< vector.size();j++) {
            try {
                file.write("ID clienti:" + vector.get(j) + "\n");
            } catch (IOException x) {
                x.printStackTrace();
            }
        }
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuHash.size()>0;
        assert invariant();
        assert WellFormed();
    }

    @Override
    public void generateReport4(LocalDateTime date) {
        assert this.menuHash.size()>0;
        FileWriter file= null;
        try {
            file = new FileWriter("report4.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            file.write("Produse ce au fost cumparate in data de "+date.getDayOfMonth()+"-"+date.getMonth()+"-"+date.getYear()+")"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter finalFile = file;
        orderCollectionHashMap.keySet().stream().forEach(orders->{
                orderCollectionHashMap.get(orders).stream().forEach(e->
                {
                    if(orders.getDate().getDayOfMonth()==date.getDayOfMonth())
                    {
                        try {
                            finalFile.write("Produsul:"+e.getTitle()+" , provine din comanda cu id="+orders.getOrderId()+"\n");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                });
            });
        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert this.menuHash.size()>0;
        assert invariant();
    }
    public boolean WellFormed(){
        if(orderListHashMap == null)
            return false;
        if(dailyMenu == null)
            return false;
        if(ordersInformations == null)
            return false;
        return true;
    }
    public boolean noItems() {
        for(Order order : orderArrayList) {
            List<BaseProduct> itemsList;
            itemsList = this.orderListHashMap.get(order);
            if(itemsList.size() != 0) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void createOrder(Order order, List<BaseProduct> productsList) {
        assert order != null;
        if (noItems() == false) {
            orderArrayList.add(order);
            orderCollectionHashMap.put(order, productsList);
            deliverySerializator.serializationFunction(orderCollectionHashMap);
            //It indicates that this Observable object has been modified, and the hasChanged() method will now return true
            setChanged();
            //Dacă metoda hasChanged () indică faptul că acest obiect s-a modificat, alertați toți observatorii săi și apoi apelați metoda clearChanged( ) pentru a arăta că nu s-a modificat.
            // Pentru a actualiza() metoda, un null este trecut ca al doilea parametru.
            notifyObservers();
        }
    }
    public void deleteProduct(String name)
    {
        baseProductsList.removeIf(baseProduct -> baseProduct.getTitle().equals(name));
        for(int i=0;i<baseProductsList.size();i++)
            System.out.println(baseProductsList.get(i).toString());

    }
    public static void showAllComposedProducts() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton back = new JButton("Back");
        frame.add(back);
        back.setBounds(20, 430, 80, 30);
        back.addActionListener(e -> {
            if (e.getSource() == back)
                frame.dispose();
        });

        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(200, 80, 90));
        DefaultTableModel csv_data = new DefaultTableModel();
        panel.setBackground(new Color(200, 80, 90));
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        csv_data.addColumn("Name");
        csv_data.addColumn("Product 1");
        csv_data.addColumn("Product 2");
        csv_data.addColumn("Product 3");
        csv_data.addColumn("Price");
        for (CompositeProduct compositeProduct : composedProducts) {
            Vector<String> row = new Vector<>();
            row.add(compositeProduct.getTitle());
            List<BaseProduct> products = compositeProduct.getProducts();
            int price = 0;
            for (BaseProduct product : products) {
                Random rand = new Random();
                int rand_int = rand.nextInt(200);
                product.setPrice(rand_int);
                price += product.getPrice();
                row.add(product.getTitle());
            }
            row.add(String.valueOf(price));
            csv_data.addRow(row);
        }
        JTable table = new JTable();
        table.setModel(csv_data);
        table.setRowHeight(40);
        table.setGridColor(Color.BLACK);
        table.setForeground(new Color(200, 80, 90));
        table.setFont(new Font("Calibre", Font.PLAIN, 14));
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.getViewport().add(table);
        panel.add(jScrollPane);
    }
   public String afisareComenzi()
    {   String rezultat=" ";
        orderCollectionHashMap = deliverySerializator.deserializationFunction();
        List <Order> dateOrders= orderCollectionHashMap.keySet().stream().collect(Collectors.toList());
        List<BaseProduct> product = new ArrayList<>();
        for(Order o: dateOrders){
            product.addAll(orderCollectionHashMap.get(o));
        }
        for(Order o: dateOrders)
        {    rezultat=rezultat+" COMANDA  " +o.toString() + "\n"+" PRODUSE ";
            for(BaseProduct p:product)
             rezultat=rezultat +p.toString() + "\n";
    }
        return rezultat;
    }
}
