package DataAccessLayer;

import BusinessLogicLayer.BaseProduct;
import BusinessLogicLayer.DeliveryService;
import BusinessLogicLayer.MenuItem;
import BusinessLogicLayer.Order;

import java.io.*;
import java.util.*;

public class Serializator implements Serializable {
    public void serializationFunction(HashMap<Order, Collection<BaseProduct>> orders){
        File file;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            file = new File("orders.ser");
            fileOutputStream = new FileOutputStream("orders.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(orders);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Order, Collection<BaseProduct>> deserializationFunction(){
        HashMap<Order,Collection<BaseProduct>> orderCollectionHashMap= new HashMap<>();
        File file = new File("orders.ser");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if(file.exists()){
            try {
                fileInputStream = new FileInputStream("orders.ser");
                objectInputStream = new ObjectInputStream(fileInputStream);
                orderCollectionHashMap = (HashMap<Order,Collection<BaseProduct>>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return orderCollectionHashMap;
    }
    public void serializationFunction2(BaseProduct product){
        File file;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            file = new File("products.ser");
            fileOutputStream = new FileOutputStream("products.ser");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(product);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void MenuSerialization(List<MenuItem> menu, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(menu);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Menu has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<MenuItem> MenuDeserialization(String fileName){

        List<MenuItem> list = new ArrayList<>();

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            list = (List<MenuItem>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Menu has been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
