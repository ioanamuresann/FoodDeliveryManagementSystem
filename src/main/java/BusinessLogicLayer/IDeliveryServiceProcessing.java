package BusinessLogicLayer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IDeliveryServiceProcessing {


    public void createNewProduct(MenuItem menuItem);

    public Object[] importProduct(BaseProduct produs);

    public static void deleteProduct(String name){

    }

    public void editProduct(MenuItem menuItem, MenuItem newMenuItem);
    /**
     * generate report 1
     * @pre size-ul listei de produse sa fie mai mare ca 0
     * @post size-ul listei de produse sa fie mai mare ca 0
     * @invariant size-ul listei de produse sa fie mai mare ca 0
     */
    public void generateReport1(LocalDateTime startHour, LocalDateTime endHour) throws IOException;
    /**
     * generate report 1
     * @pre size-ul listei de produse sa fie mai mare ca 0
     * @post size-ul listei de produse sa fie mai mare ca 0
     * @invariant size-ul listei de produse sa fie mai mare ca 0
     */
    public void generateReport2(Integer nrOrders);
    /**
     * generate report 1
     * @pre size-ul listei de produse sa fie mai mare ca 0
     * @post size-ul listei de produse sa fie mai mare ca 0
     * @invariant size-ul listei de produse sa fie mai mare ca 0
     */
    public void generateReport3(Integer nrOrders,Integer sum);
    /**
     * generate report 1
     * @pre size-ul listei de produse sa fie mai mare ca 0
     * @post size-ul listei de produse sa fie mai mare ca 0
     * @invariant size-ul listei de produse sa fie mai mare ca 0
     */
    public void generateReport4(LocalDateTime date) ;
    /**
     * create an order
     * @param order
     * @param productsList
     */
    public void createOrder(Order order, List<BaseProduct> productsList);

}
