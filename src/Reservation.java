import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class Reservation{
    protected String Client;
    protected int ReservationNumber;
    protected int Arrival;
    protected int DaysOfStay;
    protected int NumberOfPeople;
    protected Room room;
    //protected Object room=new Room();
    protected static AtomicInteger id = new AtomicInteger(100);

    public Reservation()
    {
        room=null;
        ReservationNumber=id.incrementAndGet();
    }

    protected void setRoom(Room r)
    {
    room=r;
    }


}
