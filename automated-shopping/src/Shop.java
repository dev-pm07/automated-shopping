import java.lang.Math;
import java.util.HashMap;
import java.util.Random;

public class Shop {
    HashMap<String, Double> products = new HashMap<String, Double>();
    Random rand = new Random();
    double discount1 = rand.nextDouble()*100;
    double discount2 = rand.nextDouble()*100;
    double discount3 = rand.nextDouble()*100;
    
    public Shop() {
        products.put("Toilet Paper", Math.round((rand.nextDouble()*10 + 5) * 100.0) / 100.0);
        products.put("Bread", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Toy", Math.round((rand.nextDouble()*10 + 10) * 100.0) / 100.0);
        products.put("Baby Food", Math.round((rand.nextDouble()*10 + 25) * 100.0) / 100.0);
        products.put("Diapers", Math.round((rand.nextDouble()*10 + 15) * 100.0) / 100.0);
        products.put("Butter", Math.round((rand.nextDouble()*10 + 3) * 100.0) / 100.0);
        products.put("Chicken", Math.round((rand.nextDouble()*10 + 5) * 100.0) / 100.0);
        products.put("Eggs", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Milk", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        
    
        System.out.println(products);
    }
}