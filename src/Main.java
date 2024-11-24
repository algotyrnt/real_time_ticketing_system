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

        SystemConfig systemConfig = new SystemConfig(totalTickets, releaseRate, customerRetrievalRate, maxTicketCapacity);

        while(true){
            System.out.println("Commands: Start (initiate system), Stop (stop system)");
            String command = scanner.next();

            if(command.equalsIgnoreCase("Start")){
                systemConfig.start();
            } else if(command.equalsIgnoreCase("Stop")){
                systemConfig.stop();
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }

        scanner.close();
    }
}