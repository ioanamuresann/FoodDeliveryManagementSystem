package DataAccessLayer;

import BusinessLogicLayer.MenuItem;
import BusinessLogicLayer.Order;

import java.io.File;
import java.io.IOException;

public class FileWriter {
    public void factura(Order order){
        String afisare="";
        int total = 0;
        try{
            java.io.FileWriter myWriter = new java.io.FileWriter("bill.txt");
            myWriter.write("FACTURA:\n");
            myWriter.write("Id order: " + order.getOrderId() + "\n");
            myWriter.write("Id client: " + order.getClientId() + "\n");
            for (MenuItem menuItem : order.getMenuItems()) {
                afisare = afisare +"PRODUS: "+ menuItem.getTitle() + " Pret: " + menuItem.getPrice() + "\n";
                total = total + menuItem.getPrice();
            }
            myWriter.write(afisare + "Total :" + total);
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
