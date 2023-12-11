public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\r\n" + //
                "░██████╗██╗░░██╗░█████╗░██████╗░██████╗░██╗░░░██╗\r\n" + //
                "██╔════╝██║░░██║██╔══██╗██╔══██╗██╔══██╗╚██╗░██╔╝\r\n" + //
                "╚█████╗░███████║██║░░██║██████╔╝██████╔╝░╚████╔╝░\r\n" + //
                "░╚═══██╗██╔══██║██║░░██║██╔═══╝░██╔═══╝░░░╚██╔╝░░\r\n" + //
                "██████╔╝██║░░██║╚█████╔╝██║░░░░░██║░░░░░░░░██║░░░\r\n" + //
                "╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░░░░╚═╝░░░░░░░░╚═╝░░░");      
        
        Shop walmart = new Shop("Walmart");
        walmart.applyCoupons();
        System.out.println("After coupons:\t" + walmart.products);

        Shop target = new Shop("Target");
        target.applyCoupons();
        System.out.println("After coupons:\t" + target.products);

        Shop kroger = new Shop("Kroger");
        kroger.applyCoupons();
        System.out.println("After coupons:\t" + kroger.products);
    }

} 