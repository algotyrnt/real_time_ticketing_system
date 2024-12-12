import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("System Configuration");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Total Tickets");
        int totalTickets = scanner.nextInt();

        System.out.println("Enter Release Rate");
        int releaseRate = scanner.nextInt();

        System.out.println("Enter Customer Retrieval Rate");
        int customerRetrievalRate = scanner.nextInt();

        System.out.println("Enter Max Ticket Capacity");
        int maxTicketCapacity = scanner.nextInt();


        TicketPool ticketPool = new TicketPool(maxTicketCapacity);

        Vendor[] vendors = new Vendor[10]; // Creating array of vendors
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor("vendor" + i, totalTickets, releaseRate,ticketPool);
            Thread vendorThread = new Thread(vendors[i], "Vendor ID-" + i);
            vendorThread.start();
        }

        Customer[] customers = new Customer[10]; // Creating array of customers
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer("Customer" + i,ticketPool, customerRetrievalRate); // Rerieve tickets from the pool
            Thread customerThread = new Thread(customers[i], "Customer ID-" + i);
            customerThread.start();
        }

        scanner.close();
    }
}