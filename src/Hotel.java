import java.util.ArrayList;

public class Hotel {
    String HotelName;
    ArrayList<Room> rooms=new ArrayList<Room>();
    ArrayList<Reservation> reservations=new ArrayList<Reservation>();

    public void addRoom(Room r)
    {
        rooms.add(r);
    }
}
