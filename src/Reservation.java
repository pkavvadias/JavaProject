import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class Reservation{
    String Client;//Variables need to be package-private
    int ReservationNumber;
    int Arrival;
    int DaysOfStay;
    int NumberOfPeople;
    Room room;

    //protected Object room=new Room();
    private static AtomicInteger id = new AtomicInteger();

    public Reservation()
    {
        room=null;
        ReservationNumber=id.incrementAndGet();
    }

    public void setRoom(Room r)
    {
    room=r;
    }


}
