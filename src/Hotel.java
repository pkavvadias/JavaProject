import java.util.ArrayList;
import java.util.*;

public class Hotel {
    String HotelName;
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveFromNumber(int id) {
        Room c = new Room();
        Iterator it=rooms.iterator();
        for (int i = -0; it.hasNext(); i++) { //For statement doesnt loop warning.Possible bug to check
            c = rooms.get(i);
            if (c.RoomNumber == id) {
                return c;
            } else {
                c = null;
                return c;
            }

        }
        return c;
    }
}
