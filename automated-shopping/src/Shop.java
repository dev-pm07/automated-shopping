import java.lang.Math;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Shop {
    String name;
    HashMap<String, Double> products = new HashMap<String, Double>();
    // The coupons(discounts)
    Random rand = new Random(); 
    int discount1 = (rand.nextInt(45) + 1); 
    int discount2 = (rand.nextInt(4) + 1);
    int discount3 = (rand.nextInt(75) + 1);
    
    public Shop(String name) { // This will put the names of the ietms and thei prices on the hasmap alongside the discounts.
        this.name = name;
        products.put("Toilet Paper", Math.round((rand.nextDouble()*10 + 5) * 100.0) / 100.0);
        products.put("Bread", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Toy", Math.round((rand.nextDouble()*10 + 10) * 100.0) / 100.0);
        products.put("Baby Food", Math.round((rand.nextDouble()*10 + 25) * 100.0) / 100.0);
        products.put("Diapers", Math.round((rand.nextDouble()*10 + 15) * 100.0) / 100.0);
        products.put("Butter", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Chicken", Math.round((rand.nextDouble()*10 + 5) * 100.0) / 100.0);
        products.put("Eggs", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Milk", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        System.out.println("Before coupons:\t" + products);
    }

    public void applyCoupons() {
        System.out.println("Applying best coupons at " + name);
        // ArrayList<Integer> discounts = new ArrayList<Integer>();
        // discounts.add(discount1);
        // discounts.add(discount2);
        // discounts.add(discount3);
        for (String i : products.keySet()) {
            double price = products.get(i);
            // int applier = Collections.min(discounts);
            // System.out.println(products.get(i) - applier);
            int q = rand.nextInt(2) + 1;
            double off;

            switch (q) {
                case 1:
                    off = (price * discount1) / 100;
                    products.replace(i, price - off); 
                    break;
                case 2:
                    products.replace(i, price - discount2); 
                    break;
                case 3:
                    off = (price * discount3) / 100;
                    products.replace(i, price - off);
                    break;
                    
            }
        }

    }
}