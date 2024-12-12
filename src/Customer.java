public class Customer extends Person implements Runnable {

    private TicketPool ticketPool;
    private int customerRetrievalRate;

    public Customer(String name, TicketPool ticketPool, int customerRetrievalRate) {
        super(name);
        this.customerRetrievalRate = customerRetrievalRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        Ticket ticket = ticketPool.buyTicket(); // Call method to buyTickets
        System.out.println("Ticket is - " + ticket + " - Customer name is - " + Thread.currentThread().getName());
        try {
            Thread.sleep(customerRetrievalRate * 1000); // Retrieving delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
