import java.math.BigDecimal;

public class Ticket {
    private int ticketID;
    private String eventName;
    private BigDecimal ticketPrice;

    public Ticket(int ticketID, String eventName, BigDecimal ticketPrice) {
        this.ticketID = ticketID;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", eventName='" + eventName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
