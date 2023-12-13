import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    // Fields to store payment method, membership status, and a list of items
    String paymentMethod;
    Boolean exclusiveMember = false;
    ArrayList<HashMap<String, Double>> items = new ArrayList<HashMap<String, Double>>();
    
    // Constructor to initialize the Cart with payment method and membership status
    public Cart(String pm, Boolean em) {
        this.paymentMethod = pm;
        this.exclusiveMember = em;
    }

    // Getter for payment method
    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    // Setter for payment method
    public void setPaymentMethod(String pm) {
        this.paymentMethod = pm;
    }

    // Getter for membership status
    public Boolean getExclusiveMember() {
        return this.exclusiveMember;
    }

    // Setter for membership status
    public void setExclusiveMember(Boolean em) {
        this.exclusiveMember = em;
    }

    // Method to add an item to the cart
    public void addItem(String name, Double price) {
        HashMap<String, Double> item = new HashMap<String, Double>();
        item.put(name, price);
        items.add(item);
    }

    // Method to print the electronic receipt
    public void printEReciept() {
        double total = 0.0;

        // Displaying the payment method used
        System.out.println("Paid via "+ this.paymentMethod);
        
        // Looping through the items in the cart and printing their names and prices
        for (HashMap<String, Double> item : this.items) {
            for (String i : item.keySet()) {
                System.out.println(i + " - " + item.get(i));
                total += item.get(i);
            }
        }

        // Displaying exclusive membership status if applicable
        if (this.exclusiveMember) {
            System.out.println("You are an exclusive member! You get $5 off!");
            total -= 5;
        }

        System.out.println("You paid $" + total + ". Thank you!");

    }
}
