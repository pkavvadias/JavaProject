import java.util.concurrent.atomic.AtomicInteger;


public class Reservation{
    private String Client;
    private int ReservationNumber;
    private int Arrival;
    private int DaysOfStay;
    private int NumberOfPeople;
    private Room room=null;


    private static AtomicInteger id=new AtomicInteger(1);

    public Reservation()
    {

       ReservationNumber=id.getAndIncrement();
   }

    public void setRoom(Room r)
    {
    room=r;
    }
    public Room getRoom(){return room;}
    public void setArrival(int i){Arrival=i;}
    public int getArrival(){return Arrival;}
    public void setDaysOfStay(int i){DaysOfStay=i;}
    public int getDaysOfStay(){return DaysOfStay;}
    public void setNumberOfPeople(int i){NumberOfPeople=i;}
    public int getNumberOfPeople(){return NumberOfPeople;}
    public void setReservationNumber(int i){ReservationNumber=i;}
    public int getReservationNumber(){return ReservationNumber;}
    public void setClient(String s){Client=s;}
    public String getClient(){return Client;}
}
