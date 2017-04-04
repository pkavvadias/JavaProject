import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;

public class Reservation{
    String Client;//Variables need to be package-private
    int ReservationNumber;
    int Arrival;
    int DaysOfStay;
    int NumberOfPeople;
    Room room=null;

    //protected Object room=new Room();
    static AtomicInteger id=new AtomicInteger(1);
        //ReservationNumber=id.getAndIncrement();
    //} //new AtomicInteger();

    public Reservation()
    {

       ReservationNumber=id.getAndIncrement();
   }

    public void setRoom(Room r)
    {
    room=r;
    }
}
