import java.util.ArrayList;
import java.util.*;

public class Hotel {
    String HotelName;
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    public void addRoom(Room r) {
        rooms.add(r);
    }

    public Room retrieveRoomFromNumber(int roomid) {
        Room c;
        Room a=new Room();
        Iterator it=rooms.iterator();
        for (int i = 0; it.hasNext(); i++) {
            c = rooms.get(i);
            if (c.RoomNumber == roomid) {
                a=c;
            } else {
                a = null;
            }

        }
        return a;
    }
    public Reservation retrieveResevationFromNumber(int resid)
    {
        Reservation r;
        Reservation d=new Reservation();
        Iterator itr=reservations.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            r = reservations.get(i);
            if (r.ReservationNumber == resid) {
                d=r;
            } else {
                d=null;
            }

        }
        return d;
    }
}
