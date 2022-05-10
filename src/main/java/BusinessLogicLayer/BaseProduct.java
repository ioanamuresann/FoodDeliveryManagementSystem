package BusinessLogicLayer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseProduct extends MenuItem{
    public String title;
    public float rating;
    public Integer calories;
    public Integer protein;
    public Integer fat;
    public Integer sodium;
    public Integer price;


    public BaseProduct(String title, float rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public BaseProduct() {
        super();
    }

    public List<BaseProduct> readCsvFile()
    {
        String file;
        file = "src\\main\\java\\DataAccessLayer\\products.csv";
        List<BaseProduct> baseProductsList = null;
        try{
            Stream<String> stream=Files.lines(Paths.get(file));
            List<BaseProduct> baseProductList=new ArrayList<>();
            stream.filter(lines -> !lines.startsWith("Title")).forEach(lines ->
            {
                String[] strings = lines.split(",");
                float rating = Float.parseFloat(strings[1]);
                int calories = Integer.parseInt(strings[2]);
                int protein = Integer.parseInt(strings[3]);
                int fat = Integer.parseInt(strings[4]);
                int sodium = Integer.parseInt(strings[5]);
                int price = Integer.parseInt(strings[6]);
                BaseProduct product =new BaseProduct(strings[0],rating,calories,protein,fat,sodium,price);
                baseProductList.add(product);
            });
            baseProductsList = baseProductList.stream().filter(sameProductTitle(BaseProduct::getTitle)).collect(Collectors.toList());
            FileOutputStream file2=new FileOutputStream("products.ser");
            ObjectOutputStream outFile=new ObjectOutputStream(file2);
            outFile.writeObject(baseProductsList);
            outFile.close();
            file2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseProductsList;
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
        return null;
    }

    @Override
    public void setItems(List<MenuItem> list) {

    }

    @Override
    public String toString() {
        return "Product{" + "title='" + title + '\'' + ", rating=" + rating + ", calories=" + calories + ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
//pentru a verifica ce produse au acelasi tilu
    public static <T> Predicate<T> sameProductTitle(Function<? super T, ?> keyExtractor) {
        Set<Object> objectSet;
        objectSet = ConcurrentHashMap.newKeySet();
        return object -> objectSet.add(keyExtractor.apply(object));
    }
    //chiar daca sunt doua produse cu acelasi titlu,sa aiba pret diferit(poate e de o calitate mai buna)
    /*
    public static <T> Predicate<T> produseCuAcelasiPret(Function<? super T, ?> keyExtractor) {
        Set<Object> objectSet;
        objectSet = ConcurrentHashMap.newKeySet();
        return object -> objectSet.add(keyExtractor.apply(object));
    }

     */

    public Integer getNr() {
        return nrOfAppInOrders;
    }



}
