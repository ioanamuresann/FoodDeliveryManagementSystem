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
            file = new File("delivery.ser");
            fileOutputStream = new FileOutputStream("delivery.ser");
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
        File file = new File("delivery.ser");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if(file.exists()){
            try {
                fileInputStream = new FileInputStream("delivery.ser");
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

    public BaseProduct deserializationFunction2(){
        BaseProduct p= new BaseProduct();
        File file = new File("products.ser");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if(file.exists()){
            try {
                fileInputStream = new FileInputStream("products.ser");
                objectInputStream = new ObjectInputStream(fileInputStream);
                p = (BaseProduct) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
        return p;
    }


}
