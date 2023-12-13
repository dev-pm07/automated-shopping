import java.lang.Math;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Shop {
    String name;
    HashMap<String, Double> products = new HashMap<String, Double>();
    // The coupons(discounts)
    Random rand = new Random(); 
    double discount = (rand.nextInt(50) + 1);

    public Shop(String name) { // This will put the names of the items and the prices on the hashmap alongside the discounts.
        this.name = name;
        products.put("Bread", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Toys", Math.round((rand.nextDouble()*10 + 10) * 100.0) / 100.0);
        products.put("Butter", Math.round((rand.nextDouble() * 10) * 100.0) / 100.0);
        products.put("Chicken", Math.round((rand.nextDouble() * 10 + 5) * 100.0) / 100.0);
        products.put("Eggs", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
        products.put("Milk", Math.round((rand.nextDouble()*10) * 100.0) / 100.0);
    }

    public void getAndPrintProducts() {
        for (String i : products.keySet()) {
            System.out.println(i + "      --------        US$" + products.get(i));
        }
    }

    public void applyCoupons() throws InterruptedException {
        System.out.println("Applying best coupons at " + name + "...");
        TimeUnit.SECONDS.sleep(2);
        for (String i : products.keySet()) {
            double reduced = products.get(i) - (products.get(i) * (discount / 100.0));
            products.replace(i, Math.round(reduced * 100.0) / 100.0);
        }
    }
}