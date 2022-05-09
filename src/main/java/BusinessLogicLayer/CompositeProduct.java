package BusinessLogicLayer;

;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {

    List<MenuItem> productsList = new ArrayList<MenuItem>();
    List<BaseProduct> products = new ArrayList<BaseProduct>();
    public String title;
    public float rating;
    public Integer calories;
    public Integer protein;
    public Integer fat;
    public Integer sodium;
    public Integer price;

    public CompositeProduct(String title, float rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }
    public CompositeProduct(String nume, ArrayList<BaseProduct> products) {
        this.products = products;
        this.title = nume;
    }

    public List<BaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BaseProduct> products) {
        this.products = products;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public float getRating() {
        return this.rating;
    }

    @Override
    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public Integer getCalories() {
        return this.calories;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public Integer getProtein() {
        return this.protein;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public Integer getFat() {
        return this.fat;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public Integer getSodium() {
        return this.sodium;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public List<MenuItem> getItems() {
        return productsList;
    }

    @Override
    public void setItems(List<MenuItem> list) {
        this.productsList=list;
    }

    @Override
    public Integer getNr() {

        return 1;
    }
    public int computePrice() {
        int price = 0;
        for (BaseProduct baseProduct : products) {
            price += baseProduct.getPrice();
        }
        return price;
    }
}
