import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Creating instances of the Shop class for different stores
        Shop walmart = new Shop("Walmart");
        Shop target = new Shop("Target");
        Shop kroger = new Shop("Kroger");

        // Printing decorative banners for each store
        System.out.println("\r\n" + //
                "░██████╗██╗░░██╗░█████╗░██████╗░██████╗░██╗░░░██╗\r\n" + //
                "██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝\r\n" + //
                "╚█████╗░███████║██║░░██║██████╔╝██████╔╝░╚████╔╝░\r\n" + //
                "░╚═══██╗██╔══██║██║░░██║██╔═══╝░██╔═══╝░░░╚██╔╝░░\r\n" + //
                "██████╔╝██║░░██║╚█████╔╝██║░░░░░██║░░░░░░░░██║░░░\r\n" + //
                "╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░░░░╚═╝░░░░░░░░╚═╝░░░");      

        System.out.println("\n" + //
                "█░█░█ ▄▀█ █░░ █▀▄▀█ ▄▀█ █▀█ ▀█▀\n" + //
                "▀▄▀▄▀ █▀█ █▄▄ █░▀░█ █▀█ █▀▄ ░█░\n"
        );
        // Displaying and printing products available at Walmart
        walmart.getAndPrintProducts();

        System.out.println("\n" + //
                "▀█▀ ▄▀█ █▀█ █▀▀ █▀▀ ▀█▀\n" + //
                "░█░ █▀█ █▀▄ █▄█ ██▄ ░█░\n"
        );
        // Displaying and printing products available at Target
        target.getAndPrintProducts();

        System.out.println("\n" + //
                "█▄▀ █▀█ █▀█ █▀▀ █▀▀ █▀█\n" + //
                "█░█ █▀▄ █▄█ █▄█ ██▄ █▀▄\n"
        );
        // Displaying and printing products available at Kroger
        kroger.getAndPrintProducts();
        
        // Taking user input for payment method and membership status
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would you like to buy anything? (y/n)");
        String answer = scnr.nextLine();
        if (answer.equals("n")) {
            System.exit(0);
        }
        System.out.print("Nice. First, let us know your preferred payment method:\t");
        String paymentMethod = scnr.nextLine();

        System.out.print("Alright. Which store do you want to shop at? (Walmart, Target, Kroger)\t");
        String store = scnr.nextLine();

        System.out.println("Great! Are you an exclusive member? (y/n)\t");
        String exclusiveMember = scnr.nextLine();
        Boolean em = false;
        if (exclusiveMember.equals("y")) {
            em = true;
        }
        Cart userCart = new Cart(paymentMethod, em);

        // Taking user input for the number of products to buy
        System.out.print("How many products do you want to buy?\t");
        int numItems = scnr.nextInt();
        
        // Looping through the user's product choices
        for (int i = 1; i <= numItems; i++) {
            System.out.print("\nEnter the name of the product you want to buy, and we will find the best prices for you! : ");
            String product = scnr.next();
            double price = 0.0;
             if (store.equalsIgnoreCase("Walmart")) {
                // Applying coupons for Walmart and retrieving the product price
                walmart.applyCoupons();
                price = walmart.products.get(product);
             } else if (store.equalsIgnoreCase("Target")) {
               // Applying coupons for Target and retrieving the product price
               target.applyCoupons();
               price = target.products.get(product);
             } else if (store.equalsIgnoreCase("Kroger")) {
               // Applying coupons for Kroger and retrieving the product price
               kroger.applyCoupons();
               price = kroger.products.get(product);
             } else {
                System.out.println("Sorry, we don't have that store in our database.");
                System.exit(0);
              }   
             // Calling the Cart class to add the selected product and price to the user's cart
            userCart.addItem(product, price);
        }
        
        // Updating payment method and membership status if the user desires
        System.out.print("Confirm your payment method: " + userCart.getPaymentMethod() + ". Type 'same' or the new method:\t");
        scnr.nextLine();
        String newPaymentMethod = scnr.nextLine();
        if (!newPaymentMethod.equals("same")) {
            userCart.setPaymentMethod(newPaymentMethod);
        }

        System.out.print("Confirm your membership status: " + userCart.getExclusiveMember() + ". Type 'same' or the new status (true/false):\t");
        String newEM = scnr.nextLine();
        if (!newEM.equals("same")) {
            if (newEM.equalsIgnoreCase("true")) {
                userCart.setExclusiveMember(true);
            } else if (newEM.equalsIgnoreCase("false")) {
                userCart.setExclusiveMember(false);
            }
        }
        scnr.close();

        // Printing the e-receipt for the user
        System.out.println("Thank you for shopping with us! Here is your e-receipt: ");
        userCart.printEReciept();
    }
}
