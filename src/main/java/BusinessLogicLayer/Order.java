package BusinessLogicLayer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    private int clientId;
    private LocalDateTime date;
    private List<MenuItem> menuItems;

    public Order(int client, int order, LocalDateTime date) {
        this.orderId=order;
        this.clientId=client;
        this.date=date;
    }

    public Order(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setIdOrder(int orderId) {
        this.orderId=orderId;
    }

    public void setDate(LocalDateTime date) {
        this.date=date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int hashCode() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", date='" + date + '\'' +
                '}';
    }
}
