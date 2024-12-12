import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final int maxTicketCapacity;
    private Queue<Ticket> ticketPool;

    public TicketPool(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
        this.ticketPool = new LinkedList<>();
    }

    public synchronized void addTicket(Ticket ticket){
        while (ticketPool.size() >= maxTicketCapacity){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace(); // For command line interface (CLI)
                throw new RuntimeException(e.getMessage()); // For Client-Server application
            }
        }

        this.ticketPool.add(ticket);
        notifyAll(); // Notify all the waiting threads
        System.out.println("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + ticketPool.size());
    }

    // Customer who is the Consumer will call the buyTicket() method
    public synchronized Ticket buyTicket(){
        while (ticketPool.isEmpty()){
            try {
                wait(); // If queue is empty add Customer to waiting status
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        Ticket ticket = ticketPool.poll();
        notifyAll();
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + " - current size is - " + ticketPool.size() + " - Ticket is - " + ticket);
        return ticket;
    }
}
