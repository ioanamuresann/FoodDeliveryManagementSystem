package BusinessLogicLayer;

import java.io.Serializable;
import java.util.List;

public abstract class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;

    public String title;
    public float rating;
    public Integer calories;
    public Integer protein;
    public Integer fat;
    public Integer sodium;
    public Integer price;
    public Integer nrOfAppInOrders;

    public MenuItem() {

    }

    public abstract String getTitle();
    public abstract void setTitle(String title);
    public abstract float getRating();
    public abstract void setRating(float rating);
    public abstract Integer getCalories();
    public abstract void setCalories(int calories);
    public abstract Integer getProtein();
    public abstract void setProtein(int protein);
    public abstract Integer getFat();
    public abstract void setFat(int fat);
    public abstract Integer getSodium();
    public abstract void setSodium(int sodium);
    public abstract Integer getPrice();
    public abstract void setPrice(int price);

    public abstract List<MenuItem> getItems();
    public abstract void setItems(List<MenuItem> list);

    public abstract Integer getNr();
    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
